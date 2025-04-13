package db;

import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private List<Customer> CustomerList;
    private static DBConnection instance;

    private DBConnection(){
        CustomerList = new ArrayList<>();
    }
    public List<Customer> getDBlist(){
        return CustomerList;
    }
    public static DBConnection getInstance(){
       return instance==null? instance=new DBConnection(): instance;
    }
}
