/*
    Name: Alexus Jenkins
    Course: COP 3330
    Date: September 16th, 2023
    Program Objective: Manage and handle exceptions for FM Radio Stations.
    Inputs: N/A
    Outputs:
        Success Message - Displayed during execution
        Error Message - Displayed during execution
    Purpose: Manage Radio Stations.
 */
public class FMRadioStationApp {
    public static void main(String[] args){
        //Array of FMRadioStation 8 Objects
        FMRadioStation[] stations = new FMRadioStation[8];

        //Validate and Set up Radio Stations

        //Valid Values
        stations[0] = createRadioStation("WABC", 95.5f);
        stations[1] = createRadioStation("WXYZ", 107.9f);
        stations[2] = createRadioStation("ALEX", 104.4f);
        stations[3] = createRadioStation("NOON", 102.0f);

        //Invalid Values
        stations[4] = createRadioStation("4001", 404.1f);
        stations[5] = createRadioStation("Z883", 88.3f);
        stations[6] = createRadioStation("COP", 333.0f);
        stations[7] = createRadioStation("MTV", 106.0f);

        //Display station info
        for(FMRadioStation station : stations){
            if(station != null){
                if(isStationValid(station)){
                    System.out.println("Success! | Station: " + station.getCallSign() +
                    ", Frequency: " + station.getFrequency() + " MHz.");
                } else {
                    System.err.println("Uh oh! The radio station you are trying to reach is invalid.");
                }
            }
        }
    }

    //Create FM Radio Stations
    private static FMRadioStation createRadioStation(String callSign, float frequency){
        try {
            return new FMRadioStation(callSign, frequency);
        } catch (FMRadioStationException error){
            System.err.println("Error: " + error.getMessage());
            return null; //Returns null if the station has invalid values
        }
    }

    //Checks if a station is valid
    private static boolean isStationValid(FMRadioStation station){
        return station != null && station.getCallSign() != null && station.getFrequency() >= 88.0f && station.getFrequency() <= 108.0f;
    }
}
