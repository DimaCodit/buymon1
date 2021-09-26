import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class Controller {
    @FXML
    public TableView<SaleItem> table;
    @FXML
    public TableColumn<SaleItem, String> titleColumn;
    @FXML
    public TableColumn<SaleItem, String> priceColumn;
    @FXML
    public TableColumn<SaleItem, String> sumColumn;
    @FXML
    public TableColumn<SaleItem, String> countColumn;
    @FXML
    public TableColumn<SaleItem, String> discountColumn;

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
        countColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCount()));
        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrice()));
        discountColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDiscount()));
        sumColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSum()));
    }

    public void showItems(List<SaleItem> saleItems) {
        ObservableList<SaleItem> itemsRows = table.getItems();
        itemsRows.clear();
        for(Object item : saleItems) {
            itemsRows.add((SaleItem)item);
        }
    }
}
