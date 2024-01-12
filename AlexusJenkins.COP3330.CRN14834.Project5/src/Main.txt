import java.util.ArrayList;

/*
    Name: Alexus Jenkins
    Course: COP 3330C
    Date: October 6th, 2023
    Program Objective: Use the Collections framework via various operations on a collection of names stores in a list.
    Inputs:
        Fields: N/A
        Methods:
                main() - Start the program
        Constructors: N/A
    Outputs: N/A
    Purpose: Entry Point for the Program
 */
public class Main {
    public static void main(String[] args) {
        //Instance of ArrayListCollection
    ArrayListCollection arrayListCollection = new ArrayListCollection();

    //Add names to the list
    arrayListCollection.addNamesToList();

    //Sort the list
    arrayListCollection.sortList();

    //Shuffle the list
    arrayListCollection.shuffleList();

    //Search for names
    arrayListCollection.searchForName("Alexus");
    arrayListCollection.searchForName("Jalanea");
    arrayListCollection.searchForName("Sam");
    arrayListCollection.searchForName("Josh");
    arrayListCollection.searchForName("Robert");
    arrayListCollection.searchForName("Adam");
    arrayListCollection.searchForName("Sarah");
    arrayListCollection.searchForName("Kimberly");

    //Convert the list to an array
    String[] arrayOfNames = arrayListCollection.convertListToArray();

    //Print the array
    arrayListCollection.printArray(arrayOfNames);

    //Convert array back to list
    ArrayList<String> convertedList = arrayListCollection.convertArrayToList(arrayOfNames);

    //Print the list
    arrayListCollection.printList();

    //Provide comments on Collections v Collections and Class v Interface
    arrayListCollection.commentOnCollections();

    }
}