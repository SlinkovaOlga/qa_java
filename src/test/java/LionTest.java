import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test(expected = Exception.class)
    public void lionConstructorExceptionOnUnsupportedSex() throws Exception {
        Lion lion = new Lion("Титан", feline);
    }

    @Test
    public void lionConstructorThrowsExceptionOnUnsupportedSex() {
        Exception exception = null;
        String expected = "Используйте допустимые значения пола животного - самей или самка";
        try {
            Lion lion = new Lion("Марс", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        //boolean ActualNotNull = (exception != null);
        //Assert.assertEquals("NullPointerException", true, ActualNotNull);
        Assert.assertEquals(expected, exception.getMessage());
    }

    @Test
    public void lionGetKittensReturnsCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expected = 2;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }

    @Test
    public void lionDoesHaveManeCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }

    @Test
    public void lionGetFoodReturnsCorrectList() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();

       Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }
}

