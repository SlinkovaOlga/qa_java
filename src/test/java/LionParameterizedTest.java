import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean hasManeExpectedResult;

    @Mock
    private Feline feline;

    public LionParameterizedTest(String sex, boolean hasManeExpectedResult) {
        this.sex = sex;
        this.hasManeExpectedResult = hasManeExpectedResult;
    }

    @Parameterized.Parameters
    public static Object [][] getCorrectHasManeValue() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        Assert.assertEquals("Expected value does not equal actual", hasManeExpectedResult, actual);
    }
}
