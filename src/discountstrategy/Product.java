package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class Product {

    private String prodID;
    private String prodName;
//    private String prodDetails;
    private double price;
    private DiscountStrategy ds;

    public Product(String prodID, String prodName, double price, DiscountStrategy ds) {
        setProdID(prodID);
        setProdName(prodName);
        setPrice(price);
        setDiscountStrategy(ds);
    }

    public final double getDiscount(int qty) {
        if (qty < 1 || qty > 10000) {
            throw new IllegalArgumentException("Quantity must be betweeen 1 and 10,000");
        } else {
            return ds.getDiscount(qty, price);
        }
    }

    public final String getProdID() {
        return prodID;
    }

    public final void setProdID(String prodID) {
        if (prodID == null) {
            throw new IllegalArgumentException("prodID can't be null");
        }
        this.prodID = prodID;
    }

    public final String getProdName() {
        return prodName;
    }

    public final void setProdName(String prodName) {
        if (prodName == null || prodName == "") {
            throw new IllegalArgumentException("Product name must be provided. It cannot be null or empty");
        } else {
            this.prodName = prodName;
        }
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        if (price < 0 || price >= 1000000) {
            throw new IllegalArgumentException("Enter valid price greater than 0 and less than 1,000,000");
        } else {
            this.price = price;
        }
    }

    public final DiscountStrategy getDiscountStrategy() {
        return ds;
    }

    public final void setDiscountStrategy(DiscountStrategy ds) {
        if (ds == null) {
            throw new IllegalArgumentException("Discount Strategy must be provided. ds cannot be null");
        } else {
            this.ds = ds;
        }
    }
}
