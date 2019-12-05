package ua.training.task1var8railways.model.entity;

public enum CompartmentRailcarComfortLevel {
    SECOND_A(PassengerRailcarComfortLevel.SECOND_A),
    SECOND_B(PassengerRailcarComfortLevel.SECOND_B),
    SECOND_C(PassengerRailcarComfortLevel.SECOND_C);

    private PassengerRailcarComfortLevel comfortLevel;

    CompartmentRailcarComfortLevel(PassengerRailcarComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public PassengerRailcarComfortLevel getComfortLevel() {
        return comfortLevel;
    }
}
