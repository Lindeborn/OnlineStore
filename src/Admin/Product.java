package Admin;

public class Product {
    String productname;
    String productnumber;
    String productprice;
    String supplier;
    String discount;
    String discrition;
    String productType;

    public Product(String name, String number, String price, String supplier, String discount, String discrition, String productType) {
        this.productname = name;
        this.productnumber = number;
        this.productprice = price;
        this.supplier = supplier;
        this.discount = discount;
        this.discrition = discrition;
        this.productType = productType;
    }


    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscrition() {
        return discrition;
    }

    public void setDiscrition(String discrition) {
        this.discrition = discrition;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}

