//Alexus Jenkins, COP3330C, 08/26/2023
//Program Objective: Create a class named "Rectangle" with variables, functions, and constructors.
/* Input(s):
            double length, width;
   Output(s):
            double area;
 */

//Purpose: The purpose of the class 'Rectangle' is for users to find the area of a rectangle.

public class Rectangle {
    //Fields - Purpose: Used the 'double' variable for side1 and side2, which may include decimals.
    private double length, width;

    //Constructor - Purpose: Using the constructor to initialize the variable of the object, Rectangle.
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    //Overloaded Constructor - Purpose: Set default values for the object, Rectangle.
    public Rectangle(){
        this.length = 0.0;
        this.width = 0.0;
    }

    //Method - Purpose: Using the Accessor (getter) method as a way to access the length and width variable.
    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }

    //Method - Purpose: Using the Mutator (setter) method as a way to update or change the length and width variable.
    public void setLength(double length){
        this.length = length;
    }

    public void setWidth(double width){
        this.width = width;
    }

    //Method - Purpose: Calculating the length and the width of the rectangle.
    public double calculateArea(){
        return length * width;
    }
}
