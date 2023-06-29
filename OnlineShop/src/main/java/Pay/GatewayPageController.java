package Pay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GatewayPageController {
    public Stage primaryStage;
    @FXML
    private Button PardakhtButton;

    @FXML
    private Button enserafButton;

    @FXML
    private TextField secondpassField;

    @FXML
    private TextField cvv2Field;

    @FXML
    private Label payLable;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cardcodeField;

    @FXML
    private TextField MounthEXP;

    @FXML
    private TextField yearEXP;

    @FXML
    void payButtonAction(ActionEvent event) {
        if (validateFields()) {
            System.out.println("done");
            showSuccessMessage();
            }
            String email = emailField.getText();
            //sendEmail(email);
    }

    @FXML
    void enserafButtonAction(ActionEvent event) {

    }
        private boolean validateFields() {
        String cardNumber = cardcodeField.getText();
        String cvv2 = cvv2Field.getText();
        String expiryMonth = MounthEXP.getText();
        String expiryYear = yearEXP.getText();
        String secondPassword = secondpassField.getText();
        String email = emailField.getText();

        // Validate card number field
        if (cardNumber == null || cardNumber.isEmpty() || !cardNumber.matches("\\d{16}")) {
            showError("شماره کارت صحیح وارد کنید");
            cardcodeField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            cardcodeField.setStyle("-fx-border-color: white;");
        }

        // Validate CVV2 field
        if (cvv2 == null || cvv2.isEmpty() || !cvv2.matches("\\d{3,4}")) {
            showError("cvv2 صحیح وارد کنید");
            cvv2Field.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            cvv2Field.setStyle("-fx-border-color: white;");
        }

        // Validate expiry month field
        if (expiryMonth == null || expiryMonth.isEmpty() || !expiryMonth.matches("^(0?[1-9]|1[0-2])$")) {
            showError("ماه تاریخ انقضا صحیح وارد کنید");
            MounthEXP.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            MounthEXP.setStyle("-fx-border-color: white;");
        }

        // Validate expiry year field
        if (expiryYear == null || expiryYear.isEmpty() || !expiryYear.matches("^\\d{2}$") || Integer.parseInt(expiryYear) < 23) {
            showError("سال تاریخ انقضا صحیح وارد کنید");
            yearEXP.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            yearEXP.setStyle("-fx-border-color: white;");
        }

        // Validate second password field
        if (secondPassword == null || secondPassword.isEmpty() || !secondPassword.matches("\\d{8}")) {
            showError("رمز دوم صحیح وارد کنید");
            secondpassField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            secondpassField.setStyle("-fx-border-color: white;");
        }

        // Validate email field
        if (email == null || email.isEmpty() || !email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")) {
            showError("ایمیل صحیح وارد کنید");
            emailField.setStyle("-fx-border-color: #e53333;");
            return false;
        } else {
            emailField.setStyle("-fx-border-color: white;");
        }
        return true;
    }
    private void showError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    private void showSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("پرداخت موفق");
        alert.setHeaderText(null);
        alert.setContentText("پرداخت با موفقیت انجام شد!");
        alert.showAndWait();
    }
    private void sendEmail(String email) {
    }
}

