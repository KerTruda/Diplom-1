import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private String name;
    private float price;

    public BunParameterizedTest(String name, float price){
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Big bun", Float.MAX_VALUE},
                {"Little bun", Float.MIN_VALUE},
                {"Воздушная булочка", 0},
                {"Космическая-булочка", 1.5f},
                {"Space-bun", -1.5f},
                {"!@#$%^&*()/-+", 10f},
                {"1234567890", -20f},
                {" ", 30f},
                {"", -400F},
                {null, 5000f}
        };
    }

    @Test
    public void getNameTest(){
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}
