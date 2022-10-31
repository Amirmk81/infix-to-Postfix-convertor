package Project2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    //Converts infix expression to postfix
    @Test
    public void convertToPostFix(){
        LinkedStack<String> inflixExpression = new LinkedStack<>();
        String result = inflixExpression.convertToPostFix("a+b*c");
        assertEquals("abc*+", result);
    }

    @Test
    //Finds the result of the post fix expression
    public void evaluatePostFix(){
        ResizableArrayStack<Integer> valueStack2 = new ResizableArrayStack<>();
        float result = valueStack2.evaluatePostfix("74+8*2/");
        assertEquals("44", result);
    }
}