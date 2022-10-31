package Project2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedStackTest {
    

    @Test
    //Makes sure push is adding into stack
    public void testPush(){
        StackInterface<Character> operator = new LinkedStack<>();

        operator.push((char) 'a');

        assertFalse(operator.isEmpty());

    }
    @Test
    //Makes sure clear is clearing everything when called
    public void testClear(){
        StackInterface<Character> operator = new LinkedStack<>();
        operator.push((char)'e');
        operator.clear();
        assertTrue(operator.isEmpty());
    }
    @Test
    //Makes sure pop is popping/removing from the stack
    public void testPop(){
        StackInterface<Character> operator = new LinkedStack<>();

        operator.push((char) 'a');
        operator.pop();

        assertTrue(operator.isEmpty());

    }
    @Test
    //Makes sure peek is reading top of the stack
    public void testPeek(){
        StackInterface<Character> operator = new LinkedStack<>();

        operator.push((char) 'a');
        operator.push((char) 'b');
        operator.push((char) 'c');
        
        Object top = operator.peek();

        assertEquals(String.valueOf('c'), top);

    }
    @Test
    //Makes sure expression is converted to postfix form
    public void testConvertToPostFix(){
        StackInterface<Character> operator = new LinkedStack<>();
        String infixExpression = "4*6/(3-2)+7*2";
        String postfixResult = operator.convertToPostFix(infixExpression);
        String expected = "46*32-/72*+";
        assertEquals(postfixResult, expected);

    }
    
}
