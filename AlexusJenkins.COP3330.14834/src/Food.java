/*
    Name: Alexus Jenkins
    Course: COP 3330C
    Date: September 23rd, 2023
    Program Objective: Simulate a race between the characters from the Aesop's Fable, the Hare and the Tortoise.
    Inputs:
        eat() - Animal eating
    Outputs:
        N/A
    Purpose: Simulate the animal eating.
 */
public class Food {
    public synchronized void eat(String animalName) { //eat() method
        //Print out the message inside the eat method when the animal begins to eat.
        System.out.println("The " + animalName + " is eating.");
        //Hare takes longer to eat, giving the Tortoise the advantage
        if(animalName.equals("Hare")){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
        }
    } else {
        try {
            //Tortoise eats faster
            Thread.sleep(1000);
        } catch (InterruptedException error) {
            Thread.currentThread().interrupt();
        }
    }
    //Print out the message inside the eat method when the animal is done eating.
        System.out.println("The " + animalName + "is done eating.");
    }
}
