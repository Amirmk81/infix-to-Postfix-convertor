package Project2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
    A class of stacks whose entries are stored in an array.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class ResizableArrayStack<T> implements StackInterface<T> {
    
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
	public ResizableArrayStack() {
	    this(DEFAULT_CAPACITY);
	} // end default constructor
  
	public ResizableArrayStack(int initialCapacity) {
	    integrityOK = false;
	    checkCapacity(initialCapacity);
      
	    // The cast is safe because the new array contains null entries
	    @SuppressWarnings("unchecked")
	    T[] tempStack = (T[])new Object[initialCapacity];
	    stack = tempStack;
		topIndex = -1;
		integrityOK = true;
	}// end constructor
  
	//adding to the top
	public void push(T newEntry) {
	    checkIntegrity();
	    ensureCapacity();
	    stack[topIndex + 1] = newEntry;
	    topIndex++;
	} // end push

	private void ensureCapacity() {
	    //If array is full, double its capacity
	    if (topIndex >= stack.length - 1) {
	        int newLength = 2 * stack.length;
	        checkCapacity(newLength);
	        stack = Arrays.copyOf(stack, newLength);
	    } // end if
	} // end ensureCapacity

	//removing from the top
	public T pop() {
	    checkIntegrity();
	    if (isEmpty())
	        throw new EmptyStackException();
	    else {
	        T top = stack[topIndex];
	        stack[topIndex] = null;
	        topIndex--;
	        return top;
	    } // end if
	} // end pop

   //Retreiving the top
	public T peek() {
         checkIntegrity();
         if (isEmpty())
            throw new EmptyStackException();
         else
            return stack[topIndex];
	} // end peek

	//isEmpty and Clear
	public boolean isEmpty() {
	    return topIndex < 0;
	} // end isEmpty
	
	public void clear() {
        checkIntegrity();
         
        // Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1) {
            stack[topIndex] = null;
            topIndex--;
        } // end while
         //Assertion: topIndex is -1
	} // end clear
	
	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) {
	    if (capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
	} // end checkCapacity
	
	// Throws an exception if receiving object is not initialized.
	private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException ("ArrayBag object is corrupt.");
	} // end checkintegrity
	
    public int evaluatePostfix(String postfix) {
        ResizableArrayStack<Integer> stackObject = new ResizableArrayStack<>(); //creating a new array object named valueStack
        for(int c : postfix.toCharArray()) { //iterating through when there is a char in param
            if(Character.isDigit(c)) {
                stackObject.push(c); //push inside the stack if the char is a digit
            } else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^') { //if we have an arithmetic operator
                int opTwo = stackObject.pop(); //popping the top of the stack.
                int opOne = stackObject.pop(); //popping top of the stack again.
                int result = asciiToNum(c, opOne, opTwo); //converting to numbers to perform the operations.
                //System.out.println("\nResult: " + result);
                stackObject.push(result + '0'); //pushing the result
            }
        }
        System.out.println("\nEvaluation of Postfix is: ");
        return stackObject.peek() - 48;
    }
    //ascoo to number method
    public static int asciiToNum(int c, int opOne, int opTwo) {
        int result = 0;
        opOne -= 48; 
        opTwo -= 48; 
        //
        //switch case for operands.
        switch (c) {
            case '+':
                result = opOne + opTwo;
                break;
            case '-':
                result = opOne - opTwo;
                break;
            case '*':
                result = opTwo * opOne;
                break;
            case '/':
                result = opOne / opTwo;
                break;
            case '^':
                result = opOne * opOne;
                break;
            
        }
        //prints the results.
        System.out.println("Result of the operation: is: " + result);
        return result;
    }     // end ascii to num
} // end ArrayStack

