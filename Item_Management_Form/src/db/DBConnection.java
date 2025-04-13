package db;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBConnection {
    private List<Item> ItemList;
    private static DBConnection instance;

    private DBConnection(){
        ItemList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DBConnection that = (DBConnection) o;
        return Objects.equals(ItemList, that.ItemList);
    }



    public List<Item> getDBlist(){
        return ItemList;
    }
    public static DBConnection getInstance(){
        return instance==null? instance=new DBConnection(): instance;
    }
}
