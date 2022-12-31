package cn.oldfish.builder;

import cn.oldfish.builder.pizza.Calzone;
import cn.oldfish.builder.pizza.NyPizza;
import cn.oldfish.builder.pizza.Pizza;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void nutritionFactsTest() {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println(nutritionFacts.toString());
    }

    @Test
    public void pizzaTest() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();

        System.out.println(nyPizza);
        System.out.println(calzone);
    }
}
