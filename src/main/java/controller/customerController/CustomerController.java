package controller.customerController;


import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerController implements CustomerControllerService {

    public void addCustomerDetails(Customer customer) {
        String SQL = "INSERT INTO customer(CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode) VALUES(?,?,?,?,?,?,?,?,?);";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, customer.getId());
            preparedStatement.setString(2, customer.getTitle());
            preparedStatement.setString(3, customer.getName());
            preparedStatement.setObject(4, customer.getDob());
            preparedStatement.setDouble(5, customer.getSalary());
            preparedStatement.setString(6, customer.getAddress());
            preparedStatement.setString(7, customer.getCity());
            preparedStatement.setString(8, customer.getProvince());
            preparedStatement.setString(9, customer.getPostalCode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomerDetails(Customer customer) {
        String SQL = "UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, customer.getTitle());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setObject(3, customer.getDob());
            preparedStatement.setDouble(4, customer.getSalary());
            preparedStatement.setString(5, customer.getAddress());
            preparedStatement.setString(6, customer.getCity());
            preparedStatement.setString(7, customer.getProvince());
            preparedStatement.setString(8, customer.getPostalCode());
            preparedStatement.setString(9, customer.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteCustomerDetails(Customer customerDto) {
        String SQL = "DELETE FROM customer WHERE CustID = ?;";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, customerDto.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ObservableList<Customer> getAllCustomerDetails() {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        String SQL = "SELECT CustID, CustTitle, CustName, DOB, salary, CustAddress, City, Province, PostalCode FROM customer";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                customerList.add(new Customer(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getDate("DOB").toLocalDate(),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("City"),
                        resultSet.getString("Province"),
                        resultSet.getString("PostalCode")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
