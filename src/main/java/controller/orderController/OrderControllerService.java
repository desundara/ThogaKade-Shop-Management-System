package controller.orderController;

import javafx.collections.ObservableList;
import model.dto.Item;
import model.dto.Order;

public interface OrderControllerService {

    void addOrderDetails(Order order);
    void updateOrderDetails(Order order);
    default void deleteOrderDetails(Order order) {

    }

    ObservableList<Order> getAllOrderDetails();

}
