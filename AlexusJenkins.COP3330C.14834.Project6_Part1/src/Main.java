//Name: Alexus Jenkins
//Course: COP 3330C
//Date: October 29th, 2023

//Program Objective: Create a generic method that finds the index of a value within an array of different types.
//Purpose: Test the Generic Method and Display Results


public class Main {
    public static void main(String[] args) {
        //In order to display that the method is flexible, I will test this method with different data types
        Integer[] arrayOne = {3, 2, 1, 0};
        String[] arrayTwo = {"Module", "Six", "Generics", "Method"};
        Double[] arrayThree = {1.1, 1.2, 1.3};

        //Display the results
        System.out.println(ArrayIndex.findIndex(arrayOne, 0));
        System.out.println(ArrayIndex.findIndex(arrayTwo, "Generics"));
        System.out.println(ArrayIndex.findIndex(arrayThree, 1.2));


    }
}