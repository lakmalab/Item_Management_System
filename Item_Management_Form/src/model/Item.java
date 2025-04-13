package model;

public class Item {
    private Integer ItemId;
    private String ItemName;
    private String MatufactureDate;
    private String ExpiryDate;
    private Integer Qty;
    private Double Price;

    public Item(Integer itemId, String itemName, String matufactureDate, String expiryDate, Integer qty, Double price) {
        ItemId = itemId;
        ItemName = itemName;
        MatufactureDate = matufactureDate;
        ExpiryDate = expiryDate;
        Qty = qty;
        Price = price;
    }

    public Integer getItemId() {
        return ItemId;
    }



    public void setItemId(Integer itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getMatufactureDate() {
        return MatufactureDate;
    }

    public void setMatufactureDate(String matufactureDate) {
        MatufactureDate = matufactureDate;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public Integer getQty() {
        return Qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemId=" + ItemId +
                ", ItemName='" + ItemName + '\'' +
                ", MatufactureDate='" + MatufactureDate + '\'' +
                ", ExpiryDate='" + ExpiryDate + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                '}';
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
