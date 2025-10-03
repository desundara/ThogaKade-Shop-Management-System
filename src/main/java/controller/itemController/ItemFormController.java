package controller.itemController;

import controller.customerController.CustomerController;
import controller.customerController.CustomerControllerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Item;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemFormController implements Initializable {
    ObservableList<Item> itemList = FXCollections.observableArrayList();
    ItemControllerService itemControllerService = new ItemController();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colPackSize;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtPackSize;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TableView<Item> tblItemManage;

    private void loadItemDetails() {
        itemList.clear();
        itemList.addAll(itemControllerService.getAllItemDetails());
        tblItemManage.setItems(itemList);

    }

    @FXML
    void btnAddOnClick(ActionEvent event) {
        Item item = new Item(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQty.getText())
        );

        itemControllerService.addItemDetails(item);
        loadItemDetails();
    }

    @FXML
    void btnClearOnClick(ActionEvent event) {
        txtItemCode.setText(null);
        txtDescription.setText(null);
        txtPackSize.setText(null);
        txtUnitPrice.setText(null);
        txtQty.setText(null);
    }

    @FXML
    void btnDeleteOnClick(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colPackSize.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        loadItemDetails();
    }
}
