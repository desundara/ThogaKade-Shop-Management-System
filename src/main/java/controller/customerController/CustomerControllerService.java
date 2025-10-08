package controller.customerController;

import javafx.collections.ObservableList;
import model.dto.Customer;

public interface CustomerControllerService {

    void addCustomerDetails(Customer customer);
    void updateCustomerDetails(Customer customer);
    void deleteCustomerDetails(Customer customer);

    ObservableList<Customer> getAllCustomerDetails();
}
