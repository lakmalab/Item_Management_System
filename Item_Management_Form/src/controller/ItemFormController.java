package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;
import java.time.LocalDate;

public class ItemFormController {
    public TextField ItemID;
    public TextField txtName;
    public TextField txtQty;
    public TextField txtPrice;
    public TableView tblItem;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colMfDate;
    public TableColumn colExpDate;
    public TableColumn colQty;
    public TableColumn colPrice;
    public DatePicker Datemf;
    public DatePicker Dateexp;
    public Button BtnDelete;
    public Button BtnUpdate;

    public void btnAddCustomerAction(ActionEvent actionEvent) {
        DBConnection.getInstance().getDBlist().add(
                new Item(
                        Integer.parseInt(ItemID.getText()),
                        txtName.getText(),
                        Datemf.getValue().toString(),
                        Dateexp.getValue().toString(),
                        Integer.parseInt(txtQty.getText()),
                        Double.parseDouble(txtPrice.getText())
                )
        );

        loadTable();
    }
    private Item Search() {
        for (Item item : DBConnection.getInstance().getDBlist()) {
            if (item.getItemId() == Integer.parseInt(ItemID.getText())) {
                System.out.println(item);
                return item;
            }
        }
        return null;
    }
    private void SearchItem() {
        if (Search()!=null) {
            System.out.println(Search());
            txtName.setText(Search().getItemName());
            Datemf.setValue(LocalDate.parse(Search().getMatufactureDate()));
            Dateexp.setValue(LocalDate.parse(Search().getExpiryDate()));
            txtQty.setText(Search().getQty().toString());
            txtPrice.setText(Search().getPrice().toString());

            ObservableList<Item> ItemObservableList = FXCollections.observableArrayList();
            ItemObservableList.add(Search());
            System.out.println(Search());
            tblItem.setItems(ItemObservableList);
            BtnDelete.setDisable(false);
            BtnUpdate.setDisable(false);
        }else {
            BtnDelete.setDisable(true);
            BtnUpdate.setDisable(true);
            new Alert(Alert.AlertType.INFORMATION,"Item not found").show();
        }
    }
    private void DeleteItem(){
        System.out.println(Search());
        DBConnection.getInstance().getDBlist().remove(Search());
        loadTable();
    }
    private void UpdateItem(){
        Search().setItemName(txtName.getText());
        Search().setMatufactureDate(Datemf.getValue().toString());
        Search().setExpiryDate(Dateexp.getValue().toString());
        Search().setQty(Integer.parseInt(txtQty.getText()));
        Search().setPrice(Double.parseDouble(txtPrice.getText()));

        loadTable();
    }
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

    public void btnViewAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemView_form.fxml"))));
        stage.show();
    }

    public void btnSearchItemAction(ActionEvent actionEvent) {
        SearchItem();
    }

    public void btnDeleteItemAction(ActionEvent actionEvent) {
        DeleteItem();
    }

    public void btnUpdaateitemAction(ActionEvent actionEvent) {
        UpdateItem();
    }
}
