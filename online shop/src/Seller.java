import java.util.Timer;

public class Seller extends User{
    private Timer timer = new Timer();
    public Seller(String username, String password) {
        super(username, password);
    }
}
