//Name: Alexus Jenkins
//Course: COP 3330C
//Date: October 29th, 2023

//Program Objective: Create a generic method that finds the index of a value within an array of different types.
//Purpose: Define the Generic Method

import java.util.Arrays;
public class ArrayIndex {
    //Define the Generic Method that finds the index of a value within an array
    public static <T> int findIndex(T[] array, T value){
        //Scans the array to find the value
        for (int i = 0; i < array.length; i++){
            //Checks if the current element equals the value
            if(array[i].equals(value)){
                //Return if value is found
                return i;
            }
        }
        //Return if value is not found
        return -1;
    }
}
