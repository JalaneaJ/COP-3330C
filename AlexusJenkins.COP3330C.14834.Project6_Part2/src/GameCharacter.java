//Name: Alexus Jenkins
//Course: COP 3330C
//Date: October 29th, 2023

//Program Objective: Create a generic method that compares 2 objects based on the return value of a method called 'returnValue'
//Context: I am working on a gaming project where I'm comparing 2 game levels based on their
// difficult rating in order to decide which one should be unlocked next. This will be done by
// comparing objects of different classes (levels and characters) based on a common method that returns
// a rating.

//Purpose: Represents a game character
public class GameCharacter implements ReturnValue{
    private final int power;
    public GameCharacter(int power){
        this.power = power;
    }

    @Override
    public int returnValue(){
        return power;
    }
}
