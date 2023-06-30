package Pay;

import javafx.event.ActionEvent;
import  javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class PaymentPageController {
    PaymentPage paymentPage = new PaymentPage();
    private String discountCode = "1234";
    public static double totalPay = 100.0;
    @FXML
    private Label namefeild;

    @FXML
    private TextField phoneFeild;

    @FXML
    private TextField addressFeild;

    @FXML
    private TextField DiscountField;

    @FXML
    private Button checkButton;

    @FXML
    private Button PayButton;

    @FXML
    private Label totalPayLable;

    @FXML
    private TextField Name;
    @FXML
    private Label DiscountValidation;

    @FXML
    void CheckButtonAction (ActionEvent event) throws Exception{
        String enteredDiscountCode = DiscountField.getText();
        if (enteredDiscountCode.equals(discountCode)) {
            DiscountValidation.setText("Valid discount Code");
            DiscountValidation.setStyle("-fx-border-color: #41c441;");
            totalPay -= 20;
            totalPayLable.setText("totalpay : " + totalPay);
        } else {
            totalPayLable.setText("totalpay : " + totalPay);
            DiscountValidation.setText("Invalid discount Code");
            DiscountValidation.setStyle("-fx-border-color: red;");
        }
    }

    @FXML
    void PayButtonAction (ActionEvent event)throws Exception{
        System.out.println("done");
        String name = Name.getText();
            String address = addressFeild.getText();
            String phone = phoneFeild.getText();
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                showError("Please fill in all fields");
                return;
            }
            if (!isValidName(name)) {
                showError("The name entered is invalid");
                Name.setStyle("-fx-border-color: red;");
                return;
            }else{
                Name.setStyle("-fx-border-color: balck;");
            }
            if (!isValidAddress(address)) {
                showError("The address entered is invalid");
                addressFeild.setStyle("-fx-border-color: red;");
                return;
            }else{
                addressFeild.setStyle("-fx-border-color: black;");
            }
            if (!isValidPhone(phone)) {
                showError("The phone number entered is invalid");
                phoneFeild.setStyle("-fx-border-color: red;");
                return;
            }else{
                phoneFeild.setStyle("-fx-border-color: black;");
            }
//            paymentPage.primaryStage.close();
//            GatewayPage gatewayPage = new GatewayPage();
//            gatewayPage.show();
        }
    private void showError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    private boolean isValidAddress(String address) {
        return true;
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{11}");
    }


    private void showSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful payment");
        alert.setHeaderText(null);
        alert.setContentText("Payment was successful");
        alert.showAndWait();
    }
}

