package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;

import javax.swing.*;
import java.io.IOException;


public class CustomerFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;
    public TextField txtSalary;
    public TextField txtEmail;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colPhone;
    public TableColumn colSalary;


    public void btnAddCustomerAction(ActionEvent actionEvent) {
        DBConnection.getInstance().getDBlist().add(
                new Customer(
                        Integer.parseInt(txtId.getText()),
                        txtName.getText(),
                        txtEmail.getText(),
                        txtAddress.getText(),
                        txtPhone.getText(),
                        Double.parseDouble(txtSalary.getText())
                )
        );

        loadTable();
    }
    private void loadTable(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        DBConnection.getInstance().getDBlist().forEach(customer -> {
            customerObservableList.add(customer);
            System.out.println(customer);
        });

        tblCustomer.setItems(customerObservableList);
    }

    public void btnReloadAction(ActionEvent actionEvent) {
        loadTable();

    }

    public void btnViewAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/View_form.fxml"))));
        stage.show();
    }
}
