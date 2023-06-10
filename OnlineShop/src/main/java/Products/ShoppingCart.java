package Products;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product,Integer>  cart= new HashMap<Product,Integer>();
    public void add(Product p){
        if( p.amount>1){
            if(cart.containsKey(p)){
                cart.put(p, cart.get(p)+1);
            }else cart.put(p,1);
            p.amount--;}

    }}
