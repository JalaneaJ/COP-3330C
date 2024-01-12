/*
    Name: Alexus Jenkins
    Course: COP 3330C
    Date: September 23rd, 2023
    Program Objective: Simulate a race between the characters from the Aesop's Fable, the Hare and the Tortoise.
    Inputs:
        String name // Name of the animal
        int position // Position of the animal
        int distanceTraveled // Current distance traveled by the animal
        int restMax // Maximum resting time for the animal
        static boolean winner // Determines which animal is the winner
        run() // Method - Allows the animal to rest and move forward
    Outputs:
        N/A
    Purpose: Represents the animals participating in the race
 */
public class Animal implements Runnable {
    String name; // Name of the Animal
    int position; // Position of the Animal
    int distanceTraveled; //Current distance traveled by the animal
    int restMax; //Maximum resting time for the animal
    static boolean winner; //Determines which animal is the winner
    private Food food; //Refer to the Food object

    //Constructor - Set up and Validate the variables
    public Animal(String name, int position, int distanceTraveled, int restMax, Food food) {
        this.name = name;
        this.position = position;
        this.distanceTraveled = distanceTraveled;
        this.restMax = restMax;
        this.food = food;
    }

    //Setter and Getter(s)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public int getRestMax() {
        return restMax;
    }

    public void setRestMax(int restMax) {
        this.restMax = restMax;
    }

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        Animal.winner = winner;
    }

    @Override
    public void run() {
        while (!isWinner()) { //Loop until a winner is determined
            try {
                food.eat(getName()); //Allow the animal to eat

                //Allow the animal to rest for a random amount of time that is no greater than the restMax value
                int restTime = (int) (Math.random() * (getRestMax() + 1));
                Thread.sleep(restTime);

                //Travel forward by the amount provided in distanceTraveled
                int distanceMovement = (int) (Math.random() * 4);

                //Update animal's position
                setPosition(getPosition() + distanceMovement);

                //Update animal's distance traveled
                setDistanceTraveled(getDistanceTraveled() + distanceMovement);

                //Print the animal's name and current position
                System.out.println(getName() + ": Position: " + getPosition());

                //Determine if the animal has won the race (traveling a distance of 120+).
                if (getDistanceTraveled() >= 120) {
                    setWinner(true);
                    //Announce the winner
                    System.out.println("Winner: " + getName() + "!");
                }
            } catch (InterruptedException error) { //In case of error
                throw new RuntimeException(error);
            }
        }
    }
}
