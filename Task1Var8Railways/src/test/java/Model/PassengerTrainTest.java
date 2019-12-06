package Model;

import org.junit.Assert;
import org.junit.Test;
import ua.training.task1var8railways.model.entity.*;

import java.util.ArrayList;
import java.util.Arrays;

public class PassengerTrainTest {

    /**
     * This is test data. If you decide to change it, check test methods too.
     * */
    private enum PassengerRailcarTypes{
        SLEEPING (18, 50),
        COMPARTMENT (36, 36),
        COUCHETTE (54, 36);

        private int numberOfPassengers;
        private int luggagePerPassengerAllowanceKg;

        PassengerRailcarTypes(int numberOfPassengers, int luggagePerPassengerAllowanceKg){
            this.numberOfPassengers = numberOfPassengers;
            this.luggagePerPassengerAllowanceKg = luggagePerPassengerAllowanceKg;
        }

        public int getNumberOfPassengers() {
            return numberOfPassengers;
        }

        public int getLuggagePerPassengerAllowanceKg() {
            return luggagePerPassengerAllowanceKg;
        }
    }
    private CouchetteRailcar car1 = new CouchetteRailcar("t-1", CouchetteRailcarComfortLevel.THIRD_A);
    private CouchetteRailcar car2 = new CouchetteRailcar("t-2", CouchetteRailcarComfortLevel.THIRD_B);
    private CouchetteRailcar car3 = new CouchetteRailcar("t-3", CouchetteRailcarComfortLevel.THIRD_C);
    private CompartmentRailcar car4 = new CompartmentRailcar("t-4", CompartmentRailcarComfortLevel.SECOND_A);
    private CompartmentRailcar car5 = new CompartmentRailcar("t-5", CompartmentRailcarComfortLevel.SECOND_B);
    private CompartmentRailcar car6 = new CompartmentRailcar("t-6", CompartmentRailcarComfortLevel.SECOND_C);
    private SleepingRailcar car7 = new SleepingRailcar("t-7");
    private SleepingRailcar car8 = new SleepingRailcar("t-8");
    private CouchetteRailcar car9 = new CouchetteRailcar("t-9", CouchetteRailcarComfortLevel.THIRD_A);
    private CouchetteRailcar car10 = new CouchetteRailcar("t-10", CouchetteRailcarComfortLevel.THIRD_A);
    private CompartmentRailcar car11 = new CompartmentRailcar("t-11", CompartmentRailcarComfortLevel.SECOND_C);
    private CompartmentRailcar car12 = new CompartmentRailcar("t-12", CompartmentRailcarComfortLevel.SECOND_C);

    private ArrayList<PassengerRailcar> testCarsList = new ArrayList<>(Arrays.asList(car1, car2, car3, car4, car5, car6, car7,car8, car9, car10, car11, car12));
    //end of test data

    @Test
    public void countPassengersTest(){

        ArrayList<PassengerRailcar> testCarsList = new ArrayList<>(Arrays.asList(car1, car2, car3));
        int checkingNumberOfPassengers = 3 * PassengerRailcarTypes.COUCHETTE.getNumberOfPassengers();
        PassengerTrain testTrain1 = new PassengerTrain("t1",testCarsList);
        Assert.assertEquals( checkingNumberOfPassengers, testTrain1.countPassengers());

        ArrayList<PassengerRailcar> testCarsList2 = new ArrayList<>(Arrays.asList(car1, car4, car7, car8));
        checkingNumberOfPassengers = PassengerRailcarTypes.COUCHETTE.getNumberOfPassengers() + PassengerRailcarTypes.COMPARTMENT.getNumberOfPassengers() +
                (2 * PassengerRailcarTypes.SLEEPING.getNumberOfPassengers());
        PassengerTrain testTrain2 = new PassengerTrain("t2",testCarsList2);
        Assert.assertEquals( checkingNumberOfPassengers, testTrain2.countPassengers());
    }

    @Test
    public void countLuggageKgTest(){
        ArrayList<PassengerRailcar> testCarsList1 = new ArrayList<>(Arrays.asList(car1, car2));
        int checkingLuggageKg1 = 2 * PassengerRailcarTypes.COUCHETTE.getNumberOfPassengers() * PassengerRailcarTypes.COUCHETTE.getLuggagePerPassengerAllowanceKg();
        PassengerTrain testTrain1 = new PassengerTrain("t1",testCarsList1);
        Assert.assertEquals( checkingLuggageKg1, testTrain1.countLuggageKg());

        ArrayList<PassengerRailcar> testCarsList2 = new ArrayList<>(Arrays.asList(car7, car8));
        int checkingLuggageKg2 = 2 * PassengerRailcarTypes.SLEEPING.getNumberOfPassengers() * PassengerRailcarTypes.SLEEPING.getLuggagePerPassengerAllowanceKg();
        PassengerTrain testTrain2 = new PassengerTrain("t2",testCarsList2);
        Assert.assertEquals( checkingLuggageKg2, testTrain2.countLuggageKg());

        ArrayList<PassengerRailcar> testCarsList3 = new ArrayList<>(Arrays.asList(car5, car6));
        int checkingLuggageKg3 = 2 * PassengerRailcarTypes.COMPARTMENT.getNumberOfPassengers() * PassengerRailcarTypes.COMPARTMENT.getLuggagePerPassengerAllowanceKg();
        PassengerTrain testTrain3 = new PassengerTrain("t3",testCarsList3);
        Assert.assertEquals( checkingLuggageKg3, testTrain3.countLuggageKg());

        ArrayList<PassengerRailcar> testCarsList4 = new ArrayList<>(Arrays.asList(car1, car2, car7, car8, car5, car6));
        int checkingLuggageKg4 = checkingLuggageKg1 + checkingLuggageKg2 + checkingLuggageKg3;
        PassengerTrain testTrain4 = new PassengerTrain("t2",testCarsList4);
        Assert.assertEquals( checkingLuggageKg4, testTrain4.countLuggageKg());
    }

    @Test
    public void sortRailcarsByComfortLevelTest(){
        ArrayList<PassengerRailcar> sortedCarsList = new ArrayList<>(Arrays.asList(car7, car8, car4, car5, car6, car11, car12, car1, car9, car10, car2, car3));

        PassengerTrain testTrain = new PassengerTrain("ts", testCarsList);
        testTrain.sortRailcarsByComfortLevel();

        for(int i=0; i < sortedCarsList.size(); i++){
            Assert.assertEquals(sortedCarsList.get(i), testTrain.getRailcar(i));
        }
    }

    @Test
    public void findRailcarsByNumberOfPassengersTest(){
        ArrayList<PassengerRailcar> testCarsList1 = new ArrayList<>(Arrays.asList(car1, car2, car3));
        PassengerTrain testTrain1 = new PassengerTrain("t1",testCarsList1);
        ArrayList<PassengerRailcar> result1 = testTrain1.findRailcarsByNumberOfPassengers(10,20);
        Assert.assertEquals(0, result1.size());

        ArrayList<PassengerRailcar> testCarsList2 = new ArrayList<>(Arrays.asList(car7, car7));
        PassengerTrain testTrain2 = new PassengerTrain("t2",testCarsList2);
        ArrayList<PassengerRailcar> result2 = testTrain2.findRailcarsByNumberOfPassengers(10,20);
        Assert.assertEquals(2, result2.size());

        ArrayList<PassengerRailcar> testCarsList3 = new ArrayList<>(Arrays.asList(car1, car7, car5, car6));
        PassengerTrain testTrain3 = new PassengerTrain("t3",testCarsList3);
        ArrayList<PassengerRailcar> result3 = testTrain3.findRailcarsByNumberOfPassengers(10,20);
        Assert.assertEquals(1, result3.size());

        PassengerTrain testTrain4 = new PassengerTrain("t4",testCarsList);
        ArrayList<PassengerRailcar> result4 = testTrain4.findRailcarsByNumberOfPassengers(36,36);
        Assert.assertEquals(5, result4.size());
    }
}
