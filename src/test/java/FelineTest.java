import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void felineEatFoodReturnsCorrectValue() throws Exception {
        Feline feline  = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assert.assertEquals("Expected value does not equal actual",expected, actual);

    }

    @Test
    public void felineGetFamilyReturnsCorrectValue(){
        // Arrange
        Feline feline = new Feline();
        String expected = "Кошачьи";
        // Act
        String actual = feline.getFamily();
        // Assert
        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }

    @Test
    public void felineGetKittensWithoutParametersReturnsCorrectKittensCount(){
        Feline feline = new Feline();
        int expected = 1;
        int actual = feline.getKittens();
        Assert.assertEquals("Expected value does not equal actual", expected, actual);

    }

    @Test
    public void felineGetKittensWithParametersReturnsCorrectKittensCount(){
        Feline feline = new Feline();
        int expected = 5;
        int actual = feline.getKittens(5);
        Assert.assertEquals("Expected value does not equal actual", expected, actual);
    }

}