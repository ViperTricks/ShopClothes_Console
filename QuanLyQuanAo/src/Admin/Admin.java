package Admin;

import Extend.Account;
import Product.Product;
import User.User;
import User.Order;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends Account {
    public static HashSet<Product> products = new HashSet<Product>();
    public static HashSet<User> users = new HashSet<User>();
    public static HashSet<Order> orders = new HashSet<>();
    public Admin(String username, String password) {
        super(username, password);
    }

    public Admin() {
        this.username = "admin";
        this.password = "admin123";
        products.add(new Product("T-shirt ", 250000,40));
        products.add(new Product("shirt ", 150000, 30));
        products.add(new Product("trouser ", 200000, 50));
        users.add(new User("toan", "toan123"));
        users.add(new User("dat", "dat123"));
        users.add(new User("quang", "quang123"));
    }

    @Override
    public int login(String un, String pw) {
        if (un.equals(this.username) && pw.equals(this.password)) {
            return 0;
        }
        return -1;
    }
    // Add product
    public void addProduct(Scanner sc) {
        Product product = new Product();
        System.out.print("Enter a new item name: ");
        product.setName(sc.nextLine());
        System.out.print("Enter item price: ");
        product.setPrice(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter the remaining quantity in stock: ");
        product.setQuantityInStock(Integer.parseInt(sc.nextLine()));
        products.add(product);
        System.out.println("Add a successful item!");
    }
    // Show product
    public void showProduct() {
        Iterator<Product> it =products.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Item's name: " + product.getName());
            System.out.println("Price's name: " + product.getPrice());
            System.out.println("The remaining quantity in stock: " + product.getQuantityInStock());
            System.out.println("----------------------------------------------------------------");
        }
    }
    // Update product
    public void updateProduct(Scanner sc) {
        System.out.print("Enter a code to update the item: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<Product> it = products.iterator();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                products.remove(product);
                System.out.print("Update item name: ");
                product.setName(sc.nextLine());
                System.out.print("Update item price: ");
                product.setPrice(Integer.parseInt(sc.nextLine()));
                System.out.print("Update the quantity in stock: ");
                product.setQuantityInStock(Integer.parseInt(sc.nextLine()));
                products.add(product);
                System.out.println("Update successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }
    // Delete product
    public void deleteProduct(Scanner sc) {
        System.out.print("Enter a code to remove the item: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<Product> it = products.iterator();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                products.remove(product);
                System.out.println("Delete successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }
    // Show users
    public void showUser() {
        Iterator<User> it = users.iterator();
        int index = 1;
        while (it.hasNext()) {
            User user = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Account: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("----------------------------------------------------------------");
        }
    }
    // Delete users
    public void deleteUser(Scanner sc) {
        System.out.print("Enter a code to remove the user: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {
            User user = it.next();
            i++;
            if (i == index) {
                products.remove(user);
                System.out.println("Delete successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }
    //Show Order
    public void showOrder() {
        Order order = new Order();
        if (orders.isEmpty()) {
            System.out.println("No orders!");
            return;
        }
        for (Order element : orders) {
            // Implementing for loop
            order = element;
        }
        System.out.println("Order{" +
                "purchaseDate=" + order.getPurchaseDate().toString() +
                ", user=" + order.getUser() +
                ", total=" + order.getTotal() +
                '}');
        new User().showOrderDetails();
    }
    // Delete Order
    public void deleteOrder(Scanner sc){
        System.out.print("Enter a code to delete an order: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<Order> it = orders.iterator();
        int i = 0;
        while (it.hasNext()) {
            Order order = it.next();
            i++;
            if (i == index) {
                orders.remove(order);
                System.out.println("Deleted the order successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }
    // Show Feedback
    public void showFeedback() {
        Iterator<String> it = User.feedbacks.iterator();
        int index = 1;
        while (it.hasNext()) {
            System.out.println("Index: " + index++);
            System.out.println(it.next());
            System.out.println("----------------------------------------------------------------");
        }
    }
    // Delete Feedback
    public void deleteFeedback(Scanner sc){
        System.out.print("Enter a code to delete a feedback: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<String> it = User.feedbacks.iterator();
        int i = 0;
        while (it.hasNext()) {
            String feedback = it.next();
            i++;
            if (i == index) {
                User.feedbacks.remove(feedback);
                System.out.println("Deleted the feedback successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }
}
