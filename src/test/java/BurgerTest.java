import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientOne;
    @Mock
    Ingredient ingredientTwo;


    @Before
    public void setup(){
        burger = new Burger();
    }

    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredientOne);
        assertTrue(!burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.size() == 0);
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        assertTrue(burger.ingredients.indexOf(ingredientOne) == 1);
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        Mockito.when(bun.getPrice()).thenReturn(1f);
        Mockito.when(ingredientOne.getPrice()).thenReturn(1f);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(1f);

        assertTrue(burger.getPrice() == 4f);
    }

    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(988f);
        Mockito.when(ingredientOne.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(ingredientOne.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientOne.getPrice()).thenReturn(90f);
        Mockito.when(ingredientTwo.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientTwo.getPrice()).thenReturn(1337f);

        StringBuilder expected = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("= %s %s =%n", ingredientOne.getType().toString().toLowerCase(),
                        ingredientOne.getName()))
                .append(String.format("= %s %s =%n", ingredientTwo.getType().toString().toLowerCase(),
                        ingredientTwo.getName()))
                .append(String.format("(==== %s ====)%n", bun.getName()))
                .append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(expected.toString(), burger.getReceipt());

    }
}
