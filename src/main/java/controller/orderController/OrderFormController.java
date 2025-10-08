package controller.orderController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.Item;
import model.dto.Order;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    ObservableList<Order> orderList = FXCollections.observableArrayList();
    OrderControllerService orderControllerService = new OrderController();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<Order, String> colOrderId;

    @FXML
    private TableColumn<Order, String> colCustId;

    @FXML
    private TableColumn<Order, LocalDate> colOrderDate;

    @FXML
    private TableView<Order> tblOrderManage;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private DatePicker dpOrderDate;

    @FXML
    private TextField txtOrderId;

    private void loadOrderDetails() {
        orderList.clear();
        orderList.addAll(orderControllerService.getAllOrderDetails());
        tblOrderManage.setItems(orderList);

    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

        Order order = new Order(
                txtOrderId.getText(),
                dpOrderDate.getValue(),
                txtCustomerId.getText()
        );

        orderControllerService.addOrderDetails(order);
        loadOrderDetails();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderId.setText(null);
        dpOrderDate.setValue(null);
        txtCustomerId.setText(null);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade","root","1234");
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM orders WHERE OrderID = ?");

            pstm.setObject(1, txtOrderId.getText());
            pstm.executeUpdate();

            loadOrderDetails();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Order order = new Order(
                txtOrderId.getText(),
                dpOrderDate.getValue(),
                txtCustomerId.getText()
        );
        orderControllerService.updateOrderDetails(order);
        loadOrderDetails();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colOrderId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colOrderDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustId.setCellValueFactory(new PropertyValueFactory<>("customerId"));

        loadOrderDetails();

        tblOrderManage.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            if(newValue !=null){
                txtOrderId.setText(String.valueOf(newValue.getId()));
                dpOrderDate.setValue(LocalDate.parse(String.valueOf(newValue.getDate())));
                txtCustomerId.setText(String.valueOf(newValue.getCustomerId()));
            }
        });
    }
}


