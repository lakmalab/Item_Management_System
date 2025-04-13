package model;

public class Customer {
    private Integer Id;
    private String Name;
    private String email;
    private String Address;
    private String Phone;
    private Double Salary;

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    public Customer(Integer id, String name, String email, String address, String phone, Double salary) {
        Id = id;
        Name = name;
        this.email = email;
        Address = address;
        Phone = phone;
        Salary = salary;
    }

    public Integer getId() {
        return Id;
    }



    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }
}
