package Products.Pay;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class PaymentPage extends Application {
    private String discountCode = "1234";
    private double totalPay = 100.0;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Payment Page");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Name : ");
        TextField nameField = new TextField();
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);

        Label addressLabel = new Label("Address : ");
        TextField addressField = new TextField();
        gridPane.add(addressLabel, 0, 1);
        gridPane.add(addressField, 1, 1);

        Label phoneLabel = new Label("Phone : ");
        TextField phoneField = new TextField();
        gridPane.add(phoneLabel, 0, 2);
        gridPane.add(phoneField, 1, 2);

        Label discountLabel = new Label("Discount Code : ");
        TextField discountField = new TextField();
        gridPane.add(discountLabel, 0, 3);
        gridPane.add(discountField, 1, 3);

        Label total = new Label("totalpay : " + totalPay);
        gridPane.add(total,0,5);

        Button payButton = new Button("Pay");
        gridPane.add(payButton, 0, 6);
        GridPane.setColumnSpan(payButton, 2);

        Button CheckDiscountCode = new Button("check");
        gridPane.add(CheckDiscountCode,0,4);
        GridPane.setColumnSpan(CheckDiscountCode, 2);

        Label DiscountValidation = new Label();
        CheckDiscountCode.setOnAction(event -> {
            String enteredDiscountCode = discountField.getText();
            if (enteredDiscountCode.equals(discountCode)) {
                DiscountValidation.setText("Valid discount Code");
                DiscountValidation.setStyle("-fx-border-color: #41c441;");
                totalPay -= 20 ;
                total.setText("totalpay : " + totalPay);
            } else {
                DiscountValidation.setText("Invalid discount Code");
                DiscountValidation.setStyle("-fx-border-color: red;");
                System.out.println("Invalid discount code");
            }
            if (gridPane.getChildren().contains(DiscountValidation)) {
                gridPane.getChildren().remove(DiscountValidation);
            }
            gridPane.add(DiscountValidation, 1, 4);
        });

        payButton.setOnAction(event -> {
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();

                if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
                    showError("Please fill in all fields");
                    return;
                }
                if (!isValidName(name)) {
                    showError("The name entered is invalid");
                    nameField.setStyle("-fx-border-color: red;");
                    return;
                }else{
                    nameField.setStyle("-fx-border-color: balck;");
                }
                if (!isValidAddress(address)) {
                    showError("The address entered is invalid");
                    addressField.setStyle("-fx-border-color: red;");
                    return;
                }else{
                    addressField.setStyle("-fx-border-color: black;");
                }
                if (!isValidPhone(phone)) {
                    showError("The phone number entered is invalid");
                    phoneField.setStyle("-fx-border-color: red;");
                    return;
                }else{
                    phoneField.setStyle("-fx-border-color: black;");
                }

                sendEmail(name, address, phone);
                //showSuccessMessage();
            GatewayPage gatewayPage = new GatewayPage();
            gatewayPage.showGatewayPage(primaryStage);
        });


        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
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

    private void sendEmail(String name, String address, String phone) {
        // ارسال ایمیل
    }

    private void showSuccessMessage() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful payment");
        alert.setHeaderText(null);
        alert.setContentText("Payment was successful");
        alert.showAndWait();
    }
}
