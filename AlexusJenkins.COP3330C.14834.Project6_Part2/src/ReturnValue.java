//Name: Alexus Jenkins
//Course: COP 3330C
//Date: October 29th, 2023

//Program Objective: Create a generic method that compares 2 objects based on the return value of a method called 'returnValue'
//Context: I am working on a gaming project where I'm comparing 2 game levels based on their
// difficult rating in order to decide which one should be unlocked next. This will be done by
// comparing objects of different classes (levels and characters) based on a common method that returns
// a rating.
//Purpose: Defines the blueprint for classes to implement the return value method
public interface ReturnValue {
    int returnValue();
}
