package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

public class ViewController {
    public TableView tblItem;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colMfDate;
    public TableColumn colExpDate;
    public TableColumn colQty;
    public TableColumn colPrice;
    public DatePicker Datemf;
    public DatePicker Dateexp;


    private void loadTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("ItemId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("ItemName"));
        colMfDate.setCellValueFactory(new PropertyValueFactory<>("MatufactureDate"));
        colExpDate.setCellValueFactory(new PropertyValueFactory<>("ExpiryDate"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        ObservableList<Item> ItemObservableList = FXCollections.observableArrayList();

        DBConnection.getInstance().getDBlist().forEach(Item -> {
            ItemObservableList.add(Item);
            System.out.println(Item);
        });

        tblItem.setItems(ItemObservableList);
    }
    public void btnReloadAction(ActionEvent actionEvent) {
        loadTable();
    }
}
