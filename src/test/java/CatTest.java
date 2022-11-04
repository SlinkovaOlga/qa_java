import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void catGetSoundReturnsCorrectValue(){
        Cat cat = new Cat(feline);
        String expected = "Мяу";
        String actual = cat.getSound();

        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }

    @Test
    public void catGetFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();

        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }
}
