package Products;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private String username;
    private String body;
    private  LocalDateTime now ;
    //between 1-5
    private double rate = 0;

    public double getRate() {
        return rate;
    }


    public void setRate(double rate) {
        if (rate >= 1 && rate <= 5){
            this.rate = rate;
        }else{
            throw new InvalidNumberException();
        }
    }

    public LocalDateTime getTimeposted() {
        return now;
    }

    public void setTimeposted() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();

    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comment(String username, String body){
        setBody(body);

        setTimeposted();
        setUsername(username);

    }
    public Comment(String username, String body,double rate){
        setBody(body);
        setRate(rate);
        setTimeposted();
        setUsername(username);

    }

}
