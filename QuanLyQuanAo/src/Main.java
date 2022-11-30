import Admin.Admin;
import User.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        User user = new User();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.print("Sign up or Login: ");
            int Choice = Integer.parseInt(sc.nextLine());
            if (Choice == 1) {
                user.signUp(sc);
            }
            else {
                while (true) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Enter your username: ");
                    String un = sc.nextLine();
                    System.out.print("Enter your password: ");
                    String pw = sc.nextLine();
                    if (admin.login(un, pw) == 0) {
                        adminRule(admin, sc);
                    }
                    else if (user.login(un, pw) == 1) {
                        user.setUsername(un);
                        user.setPassword(pw);
                        userRule(un, user, sc);
                    }
                    else {
                        System.out.println("No account exists!");
                    }
                }
            }
        }
    }
    // Admin Rule
    private static void adminRule(Admin admin, Scanner sc) {
        System.out.println("Welcome to " + admin.getUsername());
        while (true) {
            System.out.println("0. Log out");
            System.out.println("1. See item list");
            System.out.println("2. Add a new item");
            System.out.println("3. Update item");
            System.out.println("4. Delete item");
            System.out.println("5. See user list");
            System.out.println("6. Delete user");
            System.out.println("7. See order list");
            System.out.println("8. Delete order");
            System.out.println("9. See feedback list");
            System.out.println("10. Delete feedback");
            System.out.print("Enter your choice: ");
            int choice;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    return;
                case 1:
                    admin.showProduct();
                    break;
                case 2:
                    admin.addProduct(sc);
                    break;
                case 3:
                    admin.updateProduct(sc);
                    break;
                case 4:
                    admin.deleteProduct(sc);
                    break;
                case 5:
                    admin.showUser();
                    break;
                case 6:
                    admin.deleteUser(sc);
                    break;
                case 7:
                    admin.showOrder();
                    break;
                case 8:
                    admin.deleteOrder(sc);
                    break;
                case 9:
                    admin.showFeedback();
                    break;
                case 10:
                    admin.deleteFeedback(sc);
                    break;
            }
        }
    }
    // User Rule
    private static void userRule(String un, User user, Scanner sc) {
        System.out.println("Welcome to " + un + " ^^");
        System.out.println("----------------------------------------------------------------");
        while (true) {
            System.out.println("0. Log out");
            System.out.println("1. See item");
            System.out.println("2. Add item to cart");
            System.out.println("3. See cart");
            System.out.println("4. Update cart");
            System.out.println("5. Delete item from cart");
            System.out.println("6. Payment");
            System.out.println("7. See order");
            System.out.println("8. Feedback");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    return;
                case 1:
                    user.showProduct();
                    break;
                case 2:
                    user.addItemToCart(sc);
                    break;
                case 3:
                    user.showCart();
                    break;
                case 4:
                    user.updateCart(sc);
                    break;
                case 5:
                    user.deleteCart(sc);
                    break;
                case 6:
                    user.payment(user.getUsername());
                    break;
                case 7:
                    user.showOrder();
                    break;
                case 8:
                    user.sendFeeback(sc);
                    break;
            }
        }
    }
}

