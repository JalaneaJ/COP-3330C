/*
Name: Alexus Jenkins
Course: COP 3330-14834
Date: September 15th, 2023
Project Objective: Prompt the user to divide num2 by num1.
Inputs: num1, num2 - Inputs will be used to prompt the user to enter 2 numbers.
Output:
    result - User will either get the result of the 2 numbers being divided
    ArithmeticException - User will receive an error message.
Purpose: Divides two values and outputs the result.
 */
import java.util.Scanner;
public class DivisionCalculator {
    public static void main(String [] args){
        //Open a line of communication with the user

        try (Scanner scanner = new Scanner(System.in)) {
            //Prompt the user to enter 2 numbers
            System.out.print("Enter a number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter a second number: ");
            int num2 = scanner.nextInt();

            //Check to see if the 2nd number = 0.
            if (num2 == 0) {
                throw new ArithmeticException("Yikes, looks like you can't divide any number by 0. Try again.");
            } else {
                //If the 2nd number is not 0, calculate the result as a double with 2 decimal places.
                double result = (double) num1 / (double) num2;

                //Display the Result
                System.out.println("Your result is: " + num1 + " / " +  num2 + " = "+ result);
            }
        } catch (java.util.InputMismatchException a) {
            //Scenario: User inputs a letter instead of a number.
            System.out.println("Uh oh! It looks like you've entered a letter. Please enter a number instead.");
        }
        //End the line of communication with the user.
    }
}
