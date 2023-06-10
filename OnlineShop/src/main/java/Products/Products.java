package Products;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Products {
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<Edible> edibles = new ArrayList<Edible>();
    private ArrayList<DairyProducts> dairyProducts = new ArrayList();
    private ArrayList<Drink> drinks = new ArrayList();
    private ArrayList<Junkfood> junkfoods = new ArrayList();
    private ArrayList<Meats> meats = new ArrayList();
    private File pro = new File("pro.txt");
    private File dairy = new File("dairy.txt");
    private File drink = new File("drinks.txt");
    private File edible= new File("edible.txt");
    private File jf= new File("jf.txt");
    private File meat = new File("meats.txt");

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public Products() throws IOException, ClassNotFoundException {

        //if(pro != null && edible != null&& drink!= null && dairy != null && meat != null && jf != null )
        //k();



    }
    private void k() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pro));
        products = (ArrayList<Product>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream(edible));
        edibles = (ArrayList<Edible>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream(dairy));
        dairyProducts = (ArrayList<DairyProducts>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream(drink));
        drinks = (ArrayList<Drink>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream(jf));
        junkfoods = (ArrayList<Junkfood>) ois.readObject();
        ois = new ObjectInputStream(new FileInputStream(meat));
        meats = (ArrayList<Meats>) ois.readObject();
        for(Product myp: products){
            System.out.println(myp);
        }
        System.out.println("p[p[p");
        for(Edible myp: edibles){
            System.out.println(myp);
        }
        ois.close();


    }
    public void  clear() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pro));
        oos.writeObject(null);
        oos= new ObjectOutputStream(new FileOutputStream(edible));
        oos.writeObject(null);
        oos= new ObjectOutputStream(new FileOutputStream(drink));
        oos.writeObject(null);
        oos= new ObjectOutputStream(new FileOutputStream(dairy));
        oos.writeObject(null);
        oos= new ObjectOutputStream(new FileOutputStream(meat));
        oos.writeObject(null);
        oos= new ObjectOutputStream(new FileOutputStream(jf));
        oos.writeObject(null);
        System.out.println("fi");
        oos.close();


    }
    public int addProduct(Product p) throws IOException {if( !products.contains(p)){
        products.add(p);

        if(p instanceof Edible){
            edibles.add((Edible) p);

            if(p instanceof DairyProducts){
                dairyProducts.add((DairyProducts) p);

            }
            if(p instanceof Drink){
                drinks.add((Drink) p);
            }
            if(p instanceof Meats){
                meats.add((Meats) p);

            }
            if (p instanceof  Junkfood){
                junkfoods.add((Junkfood) p);

            }

        }}

        return 1;

    }
    public void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pro));
        oos.writeObject(products);
        oos= new ObjectOutputStream(new FileOutputStream(edible));
        oos.writeObject(edibles);
        oos= new ObjectOutputStream(new FileOutputStream(drink));
        oos.writeObject(drinks);
        oos= new ObjectOutputStream(new FileOutputStream(dairy));
        oos.writeObject(dairyProducts);
        oos= new ObjectOutputStream(new FileOutputStream(meat));
        oos.writeObject(meats);
        oos= new ObjectOutputStream(new FileOutputStream(jf));
        oos.writeObject(junkfoods);
        System.out.println("fi");
        oos.close();

    }
    public  ArrayList<Product> sortbyBrand(String brand){
        ArrayList<Product> sbb = new ArrayList<>();
        for(Product myp: products){
            if(myp.brand == brand){
                sbb.add(myp);
                System.out.println(myp);}

        }
        return sbb;

    }
    public <T extends Product> ArrayList< T> sortbyPrice(ArrayList<T> filter){
        ArrayList<T> sbp = new ArrayList<>();
        for(T myp: filter){
            sbp.add(myp);
        }
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.price < o2.price ? -1 :(o1.price == o2.price ? 0: 1);
            }};
        Collections.sort(sbp,comp);
        for(T myp: filter){
            System.out.println(myp);
        }
        for(T myp: sbp){
            System.out.println(myp);
        }
        return sbp;
    }
    public <T extends Product> ArrayList< T> sortbyRating(ArrayList<T> filter){
        ArrayList<T> sbr = new ArrayList<>();
        for(T myp: filter){
            sbr.add(myp);
        }
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.rating < o2.rating ? -1 :(o1.rating == o2.rating ? 0: 1);
            }};
        Collections.sort(sbr,comp);
        for(T myp: filter){
            System.out.println(myp);
        }
        for(T myp: sbr){
            System.out.println(myp);
        }
        return sbr;
    }

}
