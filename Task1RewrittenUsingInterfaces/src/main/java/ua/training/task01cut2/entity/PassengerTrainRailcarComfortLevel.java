package ua.training.task01cut2.entity;

/**
 * enum represents typical comfort levels of Ukrainian passenger trains
 * */
public enum PassengerTrainRailcarComfortLevel {
    DINING (null, true,true),
    FIRST (true, true,true),
    SECOND_A (true, true,true),
    SECOND_B (true, true,false),
    SECOND_C (true, false,false),
    THIRD_A(false,true,true),
    THIRD_B(false,true,false),
    THIRD_C(false,false,false),
    BAGGAGE(null,null,null);

    Boolean hasSoftBunks;
    Boolean hasAirConditioning;
    Boolean hasBioToilet;

    PassengerTrainRailcarComfortLevel (Boolean hasSoftBunks, Boolean hasAirConditioning, Boolean hasBioToilet){
        this.hasSoftBunks = hasSoftBunks;
        this.hasAirConditioning = hasAirConditioning;
        this.hasBioToilet = hasBioToilet;
    }
}
