import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private String nameType;

    public IngredientTypeTest(String nameType){
        this.nameType = nameType;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void ingredientTypeTest(){
        assertThat(nameType.valueOf(nameType), is(notNullValue()));
    }
}
