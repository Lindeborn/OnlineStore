package Admin;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    private SimpleStringProperty productname;
    private SimpleIntegerProperty productnumber;
    private SimpleDoubleProperty productprice;
    private SimpleStringProperty supplier;
    private SimpleDoubleProperty discount;
    private SimpleStringProperty description;
    private SimpleStringProperty productType;


    public Product(String name, int number, double price, String supplier, double discount, String description, String productType) {
        this.productname = new SimpleStringProperty(name);
        this.productnumber = new SimpleIntegerProperty(number);
        this.productprice = new SimpleDoubleProperty(price);
        this.supplier = new SimpleStringProperty(supplier);
        this.discount = new SimpleDoubleProperty(discount);
        this.description = new SimpleStringProperty(description);
        this.productType = new SimpleStringProperty(productType);
    }


    public String getProductname() {
        return productname.get();
    }

    public void setProductname(String name) {
        this.productname.set(name);
    }

    public int getProductnumber() {
        return productnumber.get();
    }

    public void setProductnumber(int productnumber) {
        this.productnumber.set(productnumber);
    }

    public double getProductprice() {
        return productprice.get();
    }

    public void setProductprice(double productprice) {
        this.productprice.set(productprice);
    }

    public String getSupplier() {
        return supplier.get();
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

    public double getDiscount() {
        return discount.get();
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getProductType() {
        return productType.get();
    }

    public void setProductType(String productType) {
        this.productType.set(productType);
    }
}

