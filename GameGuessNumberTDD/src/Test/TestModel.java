package Test;

import org.junit.Assert;
import org.junit.Test;
import ua.training.guessnumber.Model;

public class TestModel {
    @Test
    public void testSetInitialInterval(){
        Model model = new Model();

        //initial interval shouldn't be hardcoded in the Model. here we check that
        model.setInitialInterval(25, 67);
        Assert.assertEquals( model.getCurrentGuessRangeMin(), 25);
        Assert.assertEquals( model.getCurrentGuessRangeMax(), 67);

        model.setInitialInterval(0, 100);
        Assert.assertEquals( model.getCurrentGuessRangeMin(), 0);
        Assert.assertEquals( model.getCurrentGuessRangeMax(), 100);
    }
}
