package Products;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Product kl =new Drink("soda2","400ml","ss",20000,100,0);
        Product ol =new Drink("soda1","300ml","sd",10000,100,0);
        Product pl =new Drink("soda3","200ml","ss",30000,100,0);
        Comment comm= new Comment("s","kiri",1);
        System.out.println(comm.getTimeposted());
        Comment comm2= new Comment("s","kiri",2);
        kl.addComment(comm);
        kl.addComment(comm2);
        Comment comm3= new Comment("s","kiri",5);
        pl.addComment(comm3);

        try {
            Products pp = new Products();
            pp.addProduct(kl);
            pp.addProduct(ol);
            pp.addProduct(pl);
            pp.sortbyBrand("ss");
            pp.sortbyRating(pp.getDrinks());
            // pp.save();
            //pp.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
