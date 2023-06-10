package Products;

public class InvalidNumberException extends RuntimeException {
    public  InvalidNumberException(String msg){
        super(msg);

    }
    public  InvalidNumberException(){
        super();
    }
}
