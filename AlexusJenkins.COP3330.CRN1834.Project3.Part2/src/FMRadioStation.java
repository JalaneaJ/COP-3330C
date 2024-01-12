/*
    Name: Alexus Jenkins
    Course: COP 3330
    Date: September 16th, 2023
    Program Objective: Manage and handle exceptions for FM Radio Stations.
    Inputs:
        String callSign - Consists of 3 Capital letters that begin with 'A', 'K', 'N', or 'W'
        float frequency - Represents the frequency of the Fm radio station measured in MHz. Should fall within the range of 88.0-108.0.
    Outputs:
        getCallSign()
        getFrequency()
    Purpose: Blueprint for FM Radio Stations.
 */
public class FMRadioStation {
    private final String callSign;
    private final float frequency;

    //Constructor - Validate and Set up 'callSign' and 'frequency'
    public FMRadioStation(String callSign, float frequency) throws FMRadioStationException {
        if(!validateCallSign(callSign) || !validateFrequency(frequency)){
            throw new FMRadioStationException(callSign, frequency);
        }
        this.callSign = callSign;
        this.frequency = frequency;
    }

    //Validate callSign

    //Checks if callSign consists of 4 Capital Letters
    //Checks if callSign begins with an 'A', 'K', 'N', or 'W'

    private boolean validateCallSign(String callSign){
        return callSign.matches("[A-Z]{4}") && callSign.matches("[AKNW].*");
    }

    //Check is frequency is between 88.0 MHz and 108.0 MHz
    private boolean validateFrequency(float frequency){
        return frequency >= 88.0 && frequency <= 108.0;
    }

    //Getters - Retrieve the values of callSign and frequency
    public String getCallSign() {
        return callSign;
    }

    public float getFrequency(){
        return frequency;
    }
}
