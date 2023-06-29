package Pay;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class PaymentPage extends Application {
    public Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Payment page");
        URL url = PaymentPage.class.getResource("/Pay/PaymentPage.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
//        @FXML
//        private Label namefeild;
//
//        @FXML
//        private TextField phoneFeild;
//
//        @FXML
//        private TextField addressFeild;
//
//        @FXML
//        private TextField DiscountField;
//
//        @FXML
//        private Button checkButton;
//
//        @FXML
//        private Button PayButton;
//
//        @FXML
//        private Label totalPayLable;
//
//        @FXML
//        private TextField Name;
//        @FXML
//        private Label DiscountValidation;
//        @FXML
//        void CheckButtonAction (ActionEvent event){
//            System.out.println("done");
//            String enteredDiscountCode = DiscountField.getText();
//            if (enteredDiscountCode.equals(discountCode)) {
//                DiscountValidation.setText("Valid discount Code");
//                DiscountValidation.setStyle("-fx-border-color: #41c441;");
//                totalPay -= 20;
//                totalPayLable.setText("totalpay : " + totalPay);
//            } else {
//                DiscountValidation.setText("Invalid discount Code");
//                DiscountValidation.setStyle("-fx-border-color: red;");
//                System.out.println("Invalid discount code");
//            }
//        }
//
//        @FXML
//        void PayButtonAction (ActionEvent event){
//            GatewayPage gatewayPage = new GatewayPage();
//
//        }
    }
//public class PaymentPage extends Application {
//    private String discountCode = "1234";
//    private double totalPay = 100.0;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//    @Override
//    public void start(Stage primaryStage) throws IOException {
//        URL url = PaymentPage.class.getResource("/FXML/PaymentPage.fxml");
//        AnchorPane anchorPane = FXMLLoader.load(url);
//        Scene scene = new Scene(anchorPane);
//        primaryStage.setScene(scene);
//        primaryStage.show();
////        Parent root = FXMLLoader.load(getClass().getResource("PaymentPage.fxml"));
////        primaryStage.setTitle("Payment Page");
////        FXMLLoader fxmlLoader = new FXMLLoader(PaymentPage.class.getResource("PaymentPage.fxml"));
////        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
////        primaryStage.setScene(new Scene(root));
////        primaryStage.show();
////        GridPane gridPane = new GridPane();
////        gridPane.setPadding(new Insets(20));
////        gridPane.setVgap(10);
////        gridPane.setHgap(10);
////
////        Label nameLabel = new Label("Name : ");
////        TextField nameField = new TextField();
////        gridPane.add(nameLabel, 0, 0);
////        gridPane.add(nameField, 1, 0);
////
////        Label addressLabel = new Label("Address : ");
////        TextField addressField = new TextField();
////        gridPane.add(addressLabel, 0, 1);
////        gridPane.add(addressField, 1, 1);
////
////        Label phoneLabel = new Label("Phone : ");
////        TextField phoneField = new TextField();
////        gridPane.add(phoneLabel, 0, 2);
////        gridPane.add(phoneField, 1, 2);
////
////        Label discountLabel = new Label("Discount Code : ");
////        TextField discountField = new TextField();
////        gridPane.add(discountLabel, 0, 3);
////        gridPane.add(discountField, 1, 3);
////
////        Label total = new Label("totalpay : " + totalPay);
////        gridPane.add(total,0,5);
////
////        Button payButton = new Button("Pay");
////        gridPane.add(payButton, 0, 6);
////        GridPane.setColumnSpan(payButton, 2);
////
////        Button CheckDiscountCode = new Button("check");
////        gridPane.add(CheckDiscountCode,0,4);
////        GridPane.setColumnSpan(CheckDiscountCode, 2);
////
////        Label DiscountValidation = new Label();
//        CheckDiscountCode.setOnAction(event -> {
//            String enteredDiscountCode = discountField.getText();
//            if (enteredDiscountCode.equals(discountCode)) {
//                DiscountValidation.setText("Valid discount Code");
//                DiscountValidation.setStyle("-fx-border-color: #41c441;");
//                totalPay -= 20 ;
//                total.setText("totalpay : " + totalPay);
//            } else {
//                DiscountValidation.setText("Invalid discount Code");
//                DiscountValidation.setStyle("-fx-border-color: red;");
//                System.out.println("Invalid discount code");
//            }
//            if (gridPane.getChildren().contains(DiscountValidation)) {
//                gridPane.getChildren().remove(DiscountValidation);
//            }
//            gridPane.add(DiscountValidation, 1, 4);
//        });
////
////        payButton.setOnAction(event -> {
////            String name = nameField.getText();
////            String address = addressField.getText();
////            String phone = phoneField.getText();
////
////            if (name.isEmpty() || address.isEmpty() || phone.isEmpty()) {
////                showError("Please fill in all fields");
////                return;
////            }
////            if (!isValidName(name)) {
////                showError("The name entered is invalid");
////                nameField.setStyle("-fx-border-color: red;");
////                return;
////            }else{
////                nameField.setStyle("-fx-border-color: balck;");
////            }
////            if (!isValidAddress(address)) {
////                showError("The address entered is invalid");
////                addressField.setStyle("-fx-border-color: red;");
////                return;
////            }else{
////                addressField.setStyle("-fx-border-color: black;");
////            }
////            if (!isValidPhone(phone)) {
////                showError("The phone number entered is invalid");
////                phoneField.setStyle("-fx-border-color: red;");
////                return;
////            }else{
////                phoneField.setStyle("-fx-border-color: black;");
////            }
////
//            GatewayPage gatewayPage = new GatewayPage();
//            gatewayPage.showGatewayPage(primaryStage);
////        });
//    }
//    private void showError(String errorMessage) {
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setTitle("Error");
//        alert.setHeaderText(null);
//        alert.setContentText(errorMessage);
//        alert.showAndWait();
//    }
//
//    private boolean isValidName(String name) {
//        return name.matches("[a-zA-Z\\s]+");
//    }
//
//    private boolean isValidAddress(String address) {
//        return true;
//    }
//
//    private boolean isValidPhone(String phone) {
//        return phone.matches("\\d{11}");
//    }
//
//
//    private void showSuccessMessage() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Successful payment");
//        alert.setHeaderText(null);
//        alert.setContentText("Payment was successful");
//        alert.showAndWait();
//    }
//}
//
