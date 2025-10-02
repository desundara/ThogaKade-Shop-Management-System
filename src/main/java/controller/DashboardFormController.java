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
    public void btnCustManageOnClick(ActionEvent actionEvent) {

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

    public void btnItemManageOnClick(ActionEvent actionEvent) {

    }

    public void btnOrderDetailManageOnClick(ActionEvent actionEvent) {

    }

    public void btnOrderManageOnClick(ActionEvent actionEvent) {

    }
}
