package Pay;

import javax.mail.MessagingException;

public class EmailMain {
    public static void main(String[] args){
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "hanie.ghp82@gmail.com";
        String password = "123456";

        String subject = "Test Email";
        String to =  /*GatewayPageController.email;*/"hanie.ghavipanjeh@gmail.com"; //hanie.ghavipanjeh@example.com
        String messageBody = "This is a test email.";

        sendEmail emailSender = new sendEmail(host, port, username, password);

        try {
            emailSender.send(subject, to, messageBody);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
}
