package Project2;
import java.util.Scanner;

public class Calculator {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program will output a solutions to a postfix or an infix equation.");
        while(true) {
            System.out.println("Would you like to convert a infix to an postfix(1), Evaluate a postfix(2), or Quit (e).");
            int menu = input.nextInt();
            if(menu == 1) {
                Scanner scan = new Scanner(System.in);
                System.out.println("You have chosen to convert an infix to postfox");
                System.out.println("Please enter your infix");
                String Infix = scan.nextLine();
                LinkedStack<String> infixExpression = new LinkedStack<>();
                String result = infixExpression.convertToPostFix(Infix);
                System.out.println(result);
                scan.close();
                input.close();
                break;
            }
            else if(menu == 2) {
                Scanner scan = new Scanner(System.in);
                System.out.println("you have chosen to convert postfix to infix");
                System.out.println("please enter the number of characters in expression");
                ResizableArrayStack<Integer> valueStack2 = new ResizableArrayStack<>();
                int result = valueStack2.evaluatePostfix(postfix);
                System.out.println(result);
                scan.close();
                input.close();
                break;
            }
            else if (menu == 0) {
                break;
            }
        }
        input.close();
    }
}
