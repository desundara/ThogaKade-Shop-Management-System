package controller.orderController;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.dto.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController implements OrderControllerService {

    public void addOrderDetails(Order order) {
        String SQL = "INSERT INTO orders(OrderID, OrderDate, CustID) VALUES(?,?,?);";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, order.getId());
            preparedStatement.setString(2, String.valueOf(order.getDate()));
            preparedStatement.setString(3, order.getCustomerId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<Order> getAllOrderDetails() {

        ObservableList<Order> orderList = FXCollections.observableArrayList();

        String SQL = "SELECT OrderID, OrderDate, CustID FROM orders";

        try (Connection connection = DBConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                orderList.add(new Order(
                        resultSet.getString("OrderID"),
                        resultSet.getDate("OrderDate").toLocalDate(),
                        resultSet.getString("CustID")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }

    @Override
    public Order getOrderDetails() {
        return null;
    }
}
