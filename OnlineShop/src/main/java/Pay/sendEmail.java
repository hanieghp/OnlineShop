package Pay;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class sendEmail {
    private Properties prop;
    private Session ssn;
    private MimeMessage message;
    private Transport tr;

    public sendEmail(String host, String port, String username, String password){
        prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port",port);//25 //587
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        ssn = Session.getInstance(prop , null);
        ssn = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
    public void send(String subject , String to , String messageBody)throws MessagingException {
        message = new MimeMessage(ssn);
        message.setSubject(subject);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setContent(messageBody, "text/html;charset=UTF-8");

        Transport.send(message);
//        tr = ssn.getTransport("smtp");
//        tr.connect("smtp.gmail.com" , "hanie.ghp82" , "0926775847Hg");
//        tr.sendMessage(message , message.getAllRecipients());
//        tr.close();
    }
}
//    public static void main(String [] args) {
//        String to = "abcd@gmail.com";
//
//        String from = "web@gmail.com";
//
//        String host = "localhost";
//
//        Properties properties = System.getProperties();
//
//        properties.setProperty("mail.smtp.host", host);
//
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            MimeMessage message = new MimeMessage(session);
//
//            message.setFrom(new InternetAddress(from));
//
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//            message.setSubject("This is the Subject Line!");
//
//            message.setText("This is actual message");
//
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//    }
//}
