package controller.itemController;

import javafx.collections.ObservableList;
import model.Item;

public interface ItemControllerService {

    void addItemDetails(Item item);
    void updateItemDetails(Item item);
    void deleteItemDetails(Item item);
    ObservableList<Item> getAllItemDetails();
}
