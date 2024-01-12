/*
    Name: Alexus Jenkins
    Course: COP 3330C
    Date: October 6th, 2023
    Program Objective: Use the Collections framework via various operations on a collection of names stores in a list.
    Inputs:
        Fields:
                ArrayListCollection<String> namesList //Holds list for the names
        Methods:
                addNamesToList() //Add 8 names to the 'namesList'
                sortList() // Uses 'Collections.sort' to sort the list
                shuffleList() // Uses 'Collections.shuffle' to shuffle the list
                searchForName() // Searches for a name in the list and reports its location
                convertListToArray() // Converts the list to an array using 'toArray' and outputs the elements
                convertArrayToList() //Converts the array back to a list using 'Array.asList' and outputs the elements
                commentOnCollections() //Contains comments explaining the difference between Collections and Collection, and Class vs Interface
                printList() //Prints the List
                printArray() //Prints the Array
        Constructors: N/A
    Outputs: N/A
    Purpose: Collection of names using an ArrayList.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class ArrayListCollection {
    private final ArrayList<String> namesList;

    public ArrayListCollection(){
        namesList = new ArrayList<>();
    }
    //Method: addNamesToList() //Add 8 names to the 'namesList'
    public void addNamesToList(){
        namesList.add("Alexus");
        namesList.add("Jalanea");
        namesList.add("Sam");
        namesList.add("Josh");
        namesList.add("Robert");
        namesList.add("Adam");
        namesList.add("Sarah");
        namesList.add("Kimberly");
    }

    //Method: sortList() // Uses 'Collections.sort' to sort the list
    public void sortList(){
        Collections.sort(namesList);
    }

    //Method: shuffleList() // Uses 'Collections.shuffle' to shuffle the list
    public void shuffleList(){
        Collections.shuffle(namesList);
    }

    //Method: searchForName() // Searches for a name in the list and reports its location
    public void searchForName(String name){
        int index = namesList.indexOf(name);
        if(index != -1){
            System.out.println(name + " found at index " + index + ".");
        } else {
            System.out.println(name + " not found in the list.");
        }

    }

    //Method: convertListToArray() // Converts the list to an array using 'toArray' and outputs the elements
    public String[] convertListToArray(){
        String[] namesArray = namesList.toArray(new String[0]);
        return namesArray;
    }

    //Method: printArray() //Prints the Array
    public void printArray(String[] arrayOfNames){
        System.out.println("Array of Names: " + arrayOfNames);
        String names = String.join(", ", arrayOfNames);
        System.out.println(names);
    }

    //Method: convertArrayToList() //Converts the array back to a list using 'Array.asList' and outputs the elements
    public ArrayList<String> convertArrayToList(String [] namesArray){
        ArrayList<String> convertedList = new ArrayList<>(Arrays.asList(namesArray));
        return convertedList;
    }

    //Method: printList() //Prints the List
    public void printList(){
        System.out.println("List of Names: ");
        for (String item: namesList){
            System.out.println(item);
        }
    }

    //Method: commentOnCollections() //Contains comments explaining the difference between Collections and Collection, and Class vs Interface
    public void commentOnCollections(){
        /*
            Collections: A class that provides a set of tools in the form of methods, such as
            sorting, shuffling, searching, etc., on objects in the collection.

            Collection: A library where you can store and organize different objects.

         */

        /*
            Class: A blueprint for objects.
            Interface: A set of instructions in the form of methods that a class
            needs to follow in order to successfully execute the plan.

         */
    }
}
