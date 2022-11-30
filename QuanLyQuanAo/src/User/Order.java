package User;

import Product.Product;

import java.time.LocalDate;
import java.util.HashSet;

public class Order {
    protected LocalDate purchaseDate;
    protected String user;
    protected int total;
    public static HashSet<Product> orderDetails = new HashSet<>();

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDat(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Order(LocalDate purchaseDate, String user, int total) {
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.total = total;
    }

    public Order() {
    }
}
