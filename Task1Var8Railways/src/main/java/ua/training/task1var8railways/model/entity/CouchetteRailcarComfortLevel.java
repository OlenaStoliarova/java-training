package ua.training.task1var8railways.model.entity;

public enum CouchetteRailcarComfortLevel {
    THIRD_A(PassengerRailcarComfortLevel.THIRD_A),
    THIRD_B(PassengerRailcarComfortLevel.THIRD_B),
    THIRD_C(PassengerRailcarComfortLevel.THIRD_C);

    private PassengerRailcarComfortLevel comfortLevel;

    CouchetteRailcarComfortLevel(PassengerRailcarComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public PassengerRailcarComfortLevel getComfortLevel() {
        return comfortLevel;
    }
}
