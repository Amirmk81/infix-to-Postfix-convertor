package Project2;

import java.util.EmptyStackException;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStack<T> implements StackInterface<T> {
    
    private Node topNode; // References the first node in the chain
    
    public LinkedStack() {
        topNode = null;
    } // end default constructor
    
    public void push(T newEntry) {
        Node newNode = new Node(newEntry, topNode);
        topNode = newNode;
        //topNode = new Node(newEntry, topNode); // Alternate code
    } // end push
    
    //adds a new element
    public T pop() {
        T top = peek();  // Might throw EmptyStackException
        // Assertion: topNode != null
        topNode = topNode.getNextNode();
        return top;
    } // end pop

    //Retrieving the top
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    } // end peek
    
    //checks if stack is empty
    public boolean isEmpty() {
        return topNode == null;
    } // end isEmpty
   
    //removes all elements from stack
    public void clear() {
        topNode = null;
    } // end clear
   
    private class Node {
        private T    data; // Entry in stack
        private Node next; // Link to next node
      
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor
      
        private Node(T dataPortion, Node linkPortion) {
            data = dataPortion;
            next = linkPortion;
        } // end constructor
      
        private T getData() {
            return data;
        } // end getData
      
        private void setData(T newData) {
            data = newData;
        } // end setData
      
        private Node getNextNode() {
            return next;
        } // end getNextNode
      
        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    } // end Node
	/**
     * 
     * @param nextChar
     * @return int
     */
	//order of the operation
    private int pemdas(char nextChar) {
        if(nextChar == '+')
            return 2;
        else if(nextChar == '-')
            return 2;
        else if(nextChar == '/')
            return 1;
        else if(nextChar == '*')
            return 1;
        else if(nextChar == '(')
            return 3;
        else if(nextChar == ')')
            return 3;
        else 
            return 0;
    }
/**
 * @param infix
 * @return String 
 */
//converting infix to postfix
public String convertToPostFix(String infix) {
    StackInterface<Character> operatorStack = new LinkedStack<>();
    String postfix = "";
    int index = 0;
    while(index < infix.length()) {
        char nextCharacter = infix.charAt(index);
        if(nextCharacter == 'a' || nextCharacter == 'b' || nextCharacter == 'd' ||
        nextCharacter == 'e') {
			//adding the next character when we have a letter
            postfix += nextCharacter;
        }

        else if (nextCharacter == '+' || nextCharacter == '-' || nextCharacter == '*' || nextCharacter == '/') {
			//peeking and popping the operator if the next charact has a higher pemdas.
            while(!operatorStack.isEmpty() && pemdas(nextCharacter) >= pemdas(operatorStack.peek())){
                postfix += operatorStack.peek();
                operatorStack.pop();

            }
			//pushing the next character.
            operatorStack.push(nextCharacter);
        } else if (nextCharacter == '(') {				// pushing the next character when we have open paranthesis.
            operatorStack.push(nextCharacter);
        } else if (nextCharacter == ')') {				//poping the top operators between paranthesis one we have close paranthesis .
            char topOperator = operatorStack.pop();
            while(topOperator != '(') {
                postfix += topOperator;
                topOperator = operatorStack.pop();
            }
        }
        System.out.println(postfix);	//printing the converted postfix and incrementing the index for while loop.
        index++;
    }

//adding the top operator to our postfix
while(!operatorStack.isEmpty()) {
    char topOperator = operatorStack.pop();
    postfix += topOperator;
}
return postfix;
} // end LinkedStackpackage Project2;

}