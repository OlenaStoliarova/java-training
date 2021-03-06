package Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.guessnumber.Model;

public class TestModel {
    private Model model;
    private int intervalMin = 0, intervalMax = 100;

    @Before
    public void setModel(){
        model = new Model();
    }

    @Test
    public void testSetInitialInterval(){
        //initial interval shouldn't be hardcoded in the Model. here we check that
        model.setInitialInterval(25, 67);
        Assert.assertEquals( model.getCurrentGuessRangeMin(), 25);
        Assert.assertEquals( model.getCurrentGuessRangeMax(), 67);

        model.setInitialInterval(0, 100);
        Assert.assertEquals( model.getCurrentGuessRangeMin(), 0);
        Assert.assertEquals( model.getCurrentGuessRangeMax(), 100);
    }

    @Test
    public void testSetSecretNumber(){
        model.setInitialInterval(intervalMin, intervalMax);

        int i = 10000;
        while( i-- > 0) {
            model.setSecretNumber();
            int secretNumber = model.getSecretNumber();
            if ((secretNumber <= intervalMin) || (secretNumber >= intervalMax))
                Assert.fail();
        }
    }

    @Test
    public void testIsVictory(){
        model.setInitialInterval(intervalMin, intervalMax);
        model.setSecretNumber();

        int secretNumber = model.getSecretNumber();
        Assert.assertTrue( model.isVictory(secretNumber));

        for (int i =  intervalMax; i>= intervalMin; i--)
            if ( i != secretNumber)
                Assert.assertFalse( model.isVictory(i) );
    }
}
