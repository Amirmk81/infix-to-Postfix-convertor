package Project2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResizableArrayStackTest {
    ResizableArrayStack<String> ResizableArrayStackTest;
    @Test
    //Makes sure push, adds something to the stack to not make it empty
    public void testPush(){
        ResizableArrayStackTest.push(String.valueOf('d'));

        assertFalse(ResizableArrayStackTest.isEmpty());

    }

    @Test
    //Makes sure pop removes entries that are added to the stack making sure it is empty
    public void testPop(){
        ResizableArrayStackTest.push(String.valueOf('a'));
        ResizableArrayStackTest.pop();
        
        assertTrue(ResizableArrayStackTest.isEmpty());

    }

    @Test 
    //Makes sure the peek reads the top of the stack or the last value that was added
    public void peek(){
        ResizableArrayStackTest.push(String.valueOf('e'));
        ResizableArrayStackTest.push(String.valueOf('f'));

        Object top = ResizableArrayStackTest.peek();
        assertEquals(String.valueOf('f'), top);


    }

    @Test
    //Evaluates the postfix expression to find the answer
    public void testEvaluatePostFix(){
        ResizableArrayStack<Integer> stackObject = new ResizableArrayStack<>();
        
        float result = stackObject.evaluatePostfix("17+40-/");

        assertEquals("2", result);
        
    }
    
}
