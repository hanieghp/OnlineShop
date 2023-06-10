package Pay;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GatewayPage extends Application {

    private Stage primaryStage;
    TextField cardNumberTextField = new TextField();
    PasswordField cvv2PasswordField = new PasswordField();
    private TextField expiryMonthField = new TextField();
    private TextField expiryYearField = new TextField();
    PasswordField pinCodePasswordField = new PasswordField();
    TextField emailTextField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    public void showGatewayPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        start(primaryStage);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bank portal page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //adding stuff to page
        Label cardNumberLabel = new Label("card number ");
        gridPane.add(cardNumberLabel, 0, 0);
        gridPane.add(cardNumberTextField, 1, 0);

        Label cvv2Label = new Label("CVV2 ");
        gridPane.add(cvv2Label, 0, 1);
        gridPane.add(cvv2PasswordField, 1, 1);

        Label expiryDateLabel = new Label("Expiration date ");
        gridPane.add(expiryDateLabel, 0, 2);
        gridPane.add(expiryYearField, 1, 2);
        gridPane.add(expiryMonthField,2,2);

        Label pinCodeLabel = new Label("second password ");
        gridPane.add(pinCodeLabel, 0, 3);
        gridPane.add(pinCodePasswordField, 1, 3);

        Label emailLabel = new Label("Email (optional) ");
        gridPane.add(emailLabel, 0, 4);
        gridPane.add(emailTextField, 1, 4);

        //Payment confirmation button
        Button confirmButton = new Button("Payment confirmation ");
        gridPane.add(confirmButton, 1, 5);

        //Payment confirmation button action listener
        confirmButton.setOnAction(event -> {
            //Show payment success message
            if (validateFields()) {
                System.out.println("done");
            }
            String email = emailTextField.getText();
            //sendEmail(email);
            showSuccessMessage();
        });
        Scene scene = confirmButton.getScene();
        //scene.getStylesheets().add(getClass().getResource("@../CSS/StyleSheet.css/").toExternalForm());
        scene.getStylesheets().add("@../CSS/StyleSheet.css/");
        //Scene scene = new Scene(gridPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private boolean validateFields() {
        String cardNumber = cardNumberTextField.getText();
        String cvv2 = cvv2PasswordField.getText();
        String expiryMonth = expiryMonthField.getText();
        String expiryYear = expiryYearField.getText();
        String secondPassword = pinCodePasswordField.getText();
        String email = emailTextField.getText();

        // Validate card number field
        if (cardNumber == null || cardNumber.isEmpty() || !cardNumber.matches("\\d{16}")) {
            cardNumberTextField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            cardNumberTextField.setStyle("-fx-border-color: white;");
        }

        // Validate CVV2 field
        if (cvv2 == null || cvv2.isEmpty() || !cvv2.matches("\\d{3,4}")) {
            cvv2PasswordField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            cvv2PasswordField.setStyle("-fx-border-color: white;");
        }

        // Validate expiry month field
        if (expiryMonth == null || expiryMonth.isEmpty() || !expiryMonth.matches("^(0?[1-9]|1[0-2])$")) {
            expiryMonthField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            expiryMonthField.setStyle("-fx-border-color: white;");
        }

        // Validate expiry year field
        if (expiryYear == null || expiryYear.isEmpty() || !expiryYear.matches("^\\d{2}$") || Integer.parseInt(expiryYear) < 23) {
            expiryYearField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            expiryYearField.setStyle("-fx-border-color: white;");
        }

        // Validate second password field
        if (secondPassword == null || secondPassword.isEmpty() || !secondPassword.matches("\\d{8}")) {
            pinCodePasswordField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            pinCodePasswordField.setStyle("-fx-border-color: white;");
        }

        // Validate email field
        if (email == null || email.isEmpty() || !email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
            emailTextField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            emailTextField.setStyle("-fx-border-color: white;");
        }
        return true;
    }

    private void sendEmail(String email) {
    }

    private void showSuccessMessage() {
        //Show payment success message
        Label successLabel = new Label("Your purchase was successful!");
        Scene successScene = new Scene(successLabel, 300, 100);
        primaryStage.setScene(successScene);
    }
}
