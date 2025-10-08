package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardFormController {

    Stage customerManagement = new Stage();
    Stage itemManagement = new Stage();
    Stage orderManagement = new Stage();
    Stage orderDetailManagement = new Stage();

    @FXML
    public void btnCustManageOnAction(ActionEvent actionEvent) {

        try {
            customerManagement.setScene(
                    new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerManagement.fxml")))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        customerManagement.setResizable(false);
        customerManagement.show();
    }

    public void btnItemManageOnAction(ActionEvent actionEvent) {

        try {
            itemManagement.setScene(
                    new Scene(FXMLLoader.load(getClass().getResource("/view/ItemManagement.fxml")))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        itemManagement.setResizable(false);
        itemManagement.show();
    }

    public void btnOrderManageOnAction(ActionEvent actionEvent) {
        try {
            orderManagement.setScene(
                    new Scene(FXMLLoader.load(getClass().getResource("/view/OrderManagement.fxml")))
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        orderManagement.setResizable(false);
        orderManagement.show();
    }

    public void btnOrderDetailManageOnAction(ActionEvent actionEvent) {

    }
}
