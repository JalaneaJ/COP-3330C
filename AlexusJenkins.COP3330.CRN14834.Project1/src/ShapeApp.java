public class ShapeApp {
    public static void main(String[] args){
        //Create 2 circles
        Circle circleOne = new Circle(5.1);
        circleOne.setRadius(7.8);
        Circle circleTwo = new Circle (8.9);
        circleTwo.setRadius(9.1);

        //Create 2 rectangles
        Rectangle rectangleOne = new Rectangle(2.0, 11.2);
        rectangleOne.setLength(1.22);
        Rectangle rectangleTwo = new Rectangle(55.2, 1.0);
        rectangleTwo.setWidth(9.44);

        //Print the radius of circleOne and the area
        System.out.println("The radius of circleOne is " + circleOne.getRadius());
        System.out.println("The area of circleOne is " + circleOne.calculateArea());

        //Print the radius of circleTwo and the area
        System.out.println("The radius of circleTwo is " + circleTwo.getRadius());
        System.out.println("The area of circleTwo is " + circleTwo.calculateArea());

        //Print the length, width, and area of rectangleOne
        System.out.println("The length of rectangle of RectangleOne is " + rectangleOne.getLength());
        System.out.println("The width of the rectangle of RectangleOne is " + rectangleOne.getWidth());
        System.out.println("The area of the rectangle of RectangleOne is " + rectangleOne.calculateArea());

        //Print the length, width, and area of rectangleTwo
        System.out.println("The length of rectangle of RectangleTwo is " + rectangleTwo.getLength());
        System.out.println("The width of the rectangle of RectangleTwo is " + rectangleTwo.getWidth());
        System.out.println("The area of the rectangle of RectangleTwo is " + rectangleTwo.calculateArea());
    }
}
