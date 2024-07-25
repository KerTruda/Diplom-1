import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    private String name = "Bun name";
    private float price = Float.MAX_VALUE;

    @Mock
    Ingredient ingredient;
    @Mock
    private IngredientType type;

    @Before
    public void setup(){
        ingredient = new Ingredient(type, name, price);
    }


    @Test
    public void getNameTest(){
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest(){
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void getTypeTest(){
        assertEquals(type, ingredient.getType());
    }

}
