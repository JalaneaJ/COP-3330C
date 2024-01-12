/*
    Name: Alexus Jenkins
    Course: COP 3330
    Date: September 16th, 2023
    Program Objective: Manage and handle exceptions for FM Radio Stations.
    Inputs:
        String callSign - Call Sign of the FM Radio Station
        float frequency - Frequency of the FM Radio Station
    Outputs:
        N/A
    Purpose: Exceptions for FM Radio Stations.
 */
public class FMRadioStationException extends Exception{
    //Validate and Set error message
    public FMRadioStationException(String callSign, float frequency){
        super("Uh oh! We have received an error. Call Sign: " + callSign + " , Frequency: " + frequency + ". " +
                "Make sure that call sign consists of 4 capital letters beginning with an " +
                        "'A', 'K', 'N', or 'W' and has a frequency between 88.0 MHz and 108.0 MHz.");
    }

}
