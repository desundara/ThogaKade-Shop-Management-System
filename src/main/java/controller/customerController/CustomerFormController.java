package controller.customerController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    ObservableList<Customer> customer = FXCollections.observableArrayList();
    CustomerControllerService customerControllerService = new CustomerController();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> cmbProvince;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCustId;

    @FXML
    private TableColumn<?, ?> colCustName;

    @FXML
    private TableColumn<?, ?> colCustTitle;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private DatePicker dpDob;

    @FXML
    private TableView<Customer> tblCustManagement;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtCustName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtSalary;

    private void loadCustomerDetails() {

        customer.clear();
        customer = customerControllerService.getAllCustomerDetails();
        tblCustManagement.setItems(customer);
    }

    @FXML
    public void btnAddOnClick(ActionEvent actionEvent) {
        Customer customer = new Customer(
                txtCustId.getText(),
                cmbTitle.getValue(),
                txtCustName.getText(),
                dpDob.getValue(),
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                cmbProvince.getValue(),
                txtPostalCode.getText()
        );

        customerControllerService.addCustomerDetails(customer);
        loadCustomerDetails();

    }

    @FXML
    public void btnUpdateOnClick(ActionEvent actionEvent) {
    }

    @FXML
    public void btnClearOnClick(ActionEvent actionEvent) {
        txtCustId.setText(null);
        cmbTitle.getSelectionModel().clearSelection();
        txtCustName.setText(null);
        dpDob.setValue(null);
        txtSalary.setText(null);
        txtAddress.setText(null);
        txtCity.setText(null);
        cmbProvince.getSelectionModel().clearSelection();
        txtPostalCode.setText(null);
    }

    @FXML
    public void btnDeleteOnClick(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> titles = FXCollections.observableArrayList(
                "Mr", "Mrs", "Ms", "Miss");

        ObservableList<String> provinces = FXCollections.observableArrayList(
                "Western", "Central", "Southern", "North", "Eastern", "North", "Uva", "Sabaragamuwa");

        cmbTitle.setItems(titles);
        cmbProvince.setItems(provinces);


        colCustId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();
    }
}
