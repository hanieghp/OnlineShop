package Products;

public abstract class Edible extends Product{
    public Edible(String nameofpro, String description,String brand, long price, int amount, int discount) {
        super(nameofpro, description,brand, price, amount, discount);
    }
}
