package controller.customerController;

import javafx.collections.ObservableList;
import model.Customer;

public interface CustomerControllerService {

    void addCustomerDetails(Customer customer);
    void updateCustomerDetails(Customer customer);
    void deleteCustomerDetails(Customer customer);

    ObservableList<Customer> getAllCustomerDetails();
}
