//Name: Alexus Jenkins
//Course: COP 3330C
//Date: October 29th, 2023

//Program Objective: Create a generic method that compares 2 objects based on the return value of a method called 'returnValue'
//Context: I am working on a gaming project where I'm comparing 2 game levels based on their
// difficult rating in order to decide which one should be unlocked next. This will be done by
// comparing objects of different classes (levels and characters) based on a common method that returns
// a rating.

public class Main {
    public static void main(String[] args) {
        //Create Objects
        GameLevel easy = new GameLevel(1);
        GameLevel hard = new GameLevel(3);

        GameCharacter hero = new GameCharacter(4);
        GameCharacter villian = new GameCharacter(6);

        //Call the greaterThan method and display the results
        System.out.println(Comparison.greaterThan(easy, hard).returnValue());
        System.out.println(Comparison.greaterThan(hero, villian).returnValue());
    }
}