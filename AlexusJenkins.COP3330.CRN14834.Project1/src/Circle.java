//Alexus Jenkins, COP3330C, 08/26/2023
//Program Objective: Create a class named "Circle" with variables, functions, and constructors.
/* Input(s):
            double radius;
   Output(s):
            double area;
 */

//Purpose: The purpose of the class 'Circle' is for users to find the area of a circle.

public class Circle {
    //Fields - Purpose: Used the 'double' variable to store the radius of the circle, which may include decimals.
    private double radius;

    //Constructor - Purpose: Using the constructor to initialize the variable of the object, Circle.
    public Circle(double radius){
        this.radius = radius;
    }

    //Overloaded Constructor - Purpose: Set default values for the object, Circle.
    public Circle(){
        this.radius = 0.0;
    }

    //Method - Purpose: Using the Mutator (setter) method as a way to change or update the variable.
    public void setRadius(double radius){
        this.radius = radius;
    }

    //Method - Purpose: Using the Accessor (getter) method as a way to access the variable.
    public double getRadius() {
        return radius;
    }

    //Method - Purpose: Calculating the area of the circle.
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

}