package ua.training.task1var8railways.model.entity;

/**
 * enum represents typical comfort levels of Ukrainian passenger trains
 * */
public enum PassengerRailcarComfortLevel {
    FIRST (true, true,true),
    SECOND_A (true, true,true),
    SECOND_B (true, true,false),
    SECOND_C (true, false,false),
    THIRD_A(false,true,true),
    THIRD_B(false,true,false),
    THIRD_C(false,false,false);

    Boolean hasSoftBunks;
    Boolean hasAirConditioning;
    Boolean hasBioToilet;

    PassengerRailcarComfortLevel (Boolean hasSoftBunks, Boolean hasAirConditioning, Boolean hasBioToilet){
        this.hasSoftBunks = hasSoftBunks;
        this.hasAirConditioning = hasAirConditioning;
        this.hasBioToilet = hasBioToilet;
    }
}
