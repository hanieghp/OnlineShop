import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public abstract class User {
    protected String username;
    protected String password;
    protected long puramount;
    private ArrayList<Product> boughtpro = new ArrayList<>();
    private ShoppingCart cart = new ShoppingCart();
    public User(String username,String password){

    }
    public long purchase(){
        puramount = 0;
        for(Map.Entry<Product,Integer> set :cart.getCart().entrySet()){
//            System.out.println(set.getKey());
//            System.out.println(set.getValue());
            puramount+= set.getKey().getPrice()*set.getValue();
        }
        return puramount;
    }
    public void addtocart(Product p){
        cart.add(p);
    }
    public void more(Product p){
        System.out.println(cart.getCart().containsKey(p));
        if(cart.getCart().containsKey(p)) {
            cart.getCart().put(p, cart.getCart().get(p) + 1);

        }}
    public void less(Product p){

        if(cart.getCart().containsKey(p)) {

        if(cart.getCart().get(p)>0){
            cart.getCart().put(p, cart.getCart().get(p)-1);
       }
            if (cart.getCart().get(p) == 0){
                cart.getCart().remove(p);
              }
    }}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
