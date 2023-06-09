package Products;

import java.io.Serializable;

public class Drink extends Edible  {
    public Drink(String nameofpro, String description,String brand, long price, int amount, int discount) {
        super(nameofpro, description,brand, price, amount, discount);
    }
}
