package Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Product implements Serializable {
    protected String nameofpro;
    protected String description;
    protected String brand;
    protected  double rating;

    protected long price;
    protected int amount;
    protected int discount;
    protected ArrayList<Comment>  comments= new ArrayList<>();
    public Product(String nameofpro,String description,String brand,long price,int amount,int discount){
        setNameofpro(nameofpro);
        setDescription(description);
        setBrand(brand);

        setPrice(price);
        setAmount(amount);
        setDiscount(discount);


    }
    public void addComment(Comment comment){
        if(comment.getRate() != 0)
            if(rating != 0)
               rating= (rating+comment.getRate())/2;
        else rating+=comment.getRate();
        comments.add(comment);
    }

    protected boolean isinStock(){
        return (amount>0 ?  true:false);
    }
    protected boolean isonSale(){
        return (discount>0 ?  true:false);
    }

    public String getNameofpro() {
        return nameofpro;
    }

    public void setNameofpro(String nameofpro) {
        this.nameofpro = nameofpro;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getRating(), getRating()) == 0 && getPrice() == product.getPrice() && getAmount() == product.getAmount() && getDiscount() == product.getDiscount() && Objects.equals(getNameofpro(), product.getNameofpro()) && Objects.equals(getDescription(), product.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameofpro(), getDescription(), getRating(), getPrice(), getAmount(), getDiscount());
    }

    public String toString(){
        return nameofpro+" "+description+" "+brand+" "+rating+" "+price+" "+discount;
    }
}
