package User;

import Admin.Admin;
import Extend.Account;
import Product.Product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class User extends Account {
    public static HashSet<Product> cart = new HashSet<>();
    public static HashSet<Order> orders = new HashSet<>();
    public static HashSet<String> feedbacks = new HashSet<>();
    public User(String username, String password) {
        super(username, password);
    }

    public User() {
    }

    @Override
    public int login(String un, String pw) {
        Iterator<User> it = Admin.users.iterator();
        while (it.hasNext()) {
            User user = it.next();
            if (un.equals(user.username) && pw.equals(user.password)) {
                return 1;
            }
        }
        return -1;
    }

    public void showProduct() {
        Iterator<Product> it = Admin.products.iterator();
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

    // Sign Up
    public void signUp(Scanner sc) {
        User user = new User();
        System.out.print("Enter your username: ");
        user.setUsername(sc.nextLine());
        System.out.print("Enter your password: ");
        user.setPassword(sc.nextLine());
        System.out.println("Successful registration!");
        Admin.users.add(user);
    }

    // Show Cart
    public void showCart() {
        Iterator<Product> it = cart.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Item's name: " + product.getName());
            System.out.println("Price's item: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("----------------------------------------------------------------");
        }
    }

    // Add item to cart
    public void addItemToCart(Scanner sc) {
        System.out.print("Enter the product ID that you want to add to your cart: ");
        int choice = Integer.parseInt(sc.nextLine());
        Iterator<Product> it = Admin.products.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            if (index == choice) {
                product.setQuantity(1);
                cart.add(product);
                System.out.println("Add to cart successfully!");
                System.out.println("----------------------------------------------------------------");
                return;
            }
            index++;
        }
    }

    // Update cart
    public void updateCart(Scanner sc) {
        System.out.print("Enter a code to update the item: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<Product> it = cart.iterator();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                cart.remove(product);
                System.out.print("Enter the quantity you want to purchase: ");
                product.setQuantity(Integer.parseInt(sc.nextLine()));
                cart.add(product);
                System.out.println("Update successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }

    // Remove item from cart
    public void deleteCart(Scanner sc) {
        System.out.print("Enter a code to remove item from cart: ");
        int index = Integer.parseInt(sc.nextLine());
        Iterator<Product> it = cart.iterator();
        int i = 0;
        while (it.hasNext()) {
            Product product = it.next();
            i++;
            if (i == index) {
                cart.remove(product);
                System.out.println("Delete successfully!");
                System.out.println("----------------------------------------------------------------");
                break;
            }
        }
    }

    // Payment
    public void payment(String username) {
        Order order = new Order();
        order.orderDetails.addAll(cart);
        order.setUser(username);
        order.setPurchaseDat(java.time.LocalDate.now());
        order.setTotal(getTotal());
        Admin.orders.add(order);
        cart.clear();
        System.out.println("Successful ordering!");
        System.out.println("----------------------------------------------------------------");
    }
    // Show Order
    public void showOrder() {
        Order order = new Order();
        for (Order element : Admin.orders) {
            // Implementing for loop
            order = element;
        }
        System.out.println("Order{" +
                "purchaseDate=" + order.getPurchaseDate().toString() +
                ", user=" + order.getUser() +
                ", total=" + order.getTotal() +
                '}');
        showOrderDetails();
    }
    int getTotal() {
        int total = 0;
        Iterator<Product> it = Order.orderDetails.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
    // Show Order Details
    public void showOrderDetails() {
        Iterator<Product> it = Order.orderDetails.iterator();
        int index = 1;
        while (it.hasNext()) {
            Product product = it.next();
            System.out.println("Index: " + index++);
            System.out.println("Item's name: " + product.getName());
            System.out.println("Price's item: " + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("----------------------------------------------------------------");
        }
    }
    // Feedback
    public void sendFeeback(Scanner sc) {
        System.out.print("Write feedback about the item: ");
        String feedback = sc.nextLine();
        feedbacks.add(feedback);
        System.out.println("Successful response!");
    }
}
