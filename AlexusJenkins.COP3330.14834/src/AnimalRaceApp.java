/*
    Name: Alexus Jenkins
    Course: COP 3330C
    Date: September 23rd, 2023
    Program Objective: Simulate a race between the characters from the Aesop's Fable, the Hare and the Tortoise.
    Inputs:
        N/A
    Outputs:
        N/A
    Purpose: Initiates the race between the Hare and the Tortoise
 */
public class AnimalRaceApp {
    public static void main(String[] args){
        Food food = new Food(); //Instance of Food

        //Create 2 stances of the Animal class, one called 'Hare' and one called 'Tortoise'
        //Initial position for all animals are set to 0
        Animal hare = new Animal("Hare", 0, 100, 1000, food); //Hare rests are longer, but has a longer distance traveled
        Animal tortoise = new Animal("Tortoise", 0, 0, 400, food); //Tortoise rests are shorter.

        //Set Threads for the Hare and the Tortoise
        Thread hareThread = new Thread(hare);
        Thread tortoiseThread = new Thread(tortoise);

        //User Threads (Non-Daemon Threads) that is created and controlled by the user/application
        hareThread.setDaemon(false);
        tortoiseThread.setDaemon(false);

        //Start Threads for the Hare and the Tortoise
        hareThread.start();
        tortoiseThread.start();
    }

}
