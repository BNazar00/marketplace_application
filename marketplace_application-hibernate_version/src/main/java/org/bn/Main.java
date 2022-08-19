package org.bn;

import org.bn.entities.Product;
import org.bn.entities.User;
import org.bn.service.ProductService;
import org.bn.service.ProductServiceImpl;
import org.bn.service.UserService;
import org.bn.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		UserService userService = new UserServiceImpl();
		ProductService productService = new ProductServiceImpl();
		while (!exit) {
			System.out.println("""
					\nChoose option:
					    1 - Show all users;
					    2 - Show all products;
					    3 - Add user;
					    4 - Add product;
					    5 - Create an order;
					    6 - Show list of user products;
					    7 - Show list of users that bought product;
					    8 - Delete user;
					    9 - Delete product;
					    10 - Exit;
					""");
			int choice = in.nextInt();
			while (!(choice >= 1 && choice <= 10)) {
				System.out.println("Invalid Choice!");
				choice = in.nextInt();
			}
			switch (choice) {
				case 1 -> {
					for (User user : userService.getAllUsers()) {
						System.out.println(user);
					}
				}
				case 2 -> {
					for (Product product : productService.getAllProducts()) {
						System.out.println(product);
					}
				}
				case 3 -> {
					System.out.println("Enter first name:");
					in.nextLine();
					String firstName = in.nextLine();
					while (firstName.strip().length() == 0) {
						System.out.println("You must enter first name in appropriate way.");
						firstName = in.nextLine();
					}
					System.out.println("Enter last name:");
					String lastName = in.nextLine();
					while (firstName.strip().length() == 0) {
						System.out.println("You must enter first name in appropriate way.");
						firstName = in.nextLine();
					}
					System.out.println("Enter amount of money:");
					int moneys = in.nextInt();
					while (moneys < 0) {
						System.out.println("Amount of money should be a non negative integer. Please enter again: ");
						moneys = in.nextInt();
					}
					User newUser = new User(firstName.trim(), lastName.trim(), moneys);
					userService.addUser(newUser);
				}
				case 4 -> {
					System.out.println("Enter product name:  ");
					in.nextLine();
					String productName = in.nextLine();
					System.out.println("Enter price: ");
					int price = in.nextInt();
					while (price < 0) {
						System.out.println("Price should be a non negative integer. Please enter again: ");
						price = in.nextInt();
					}
					Product newProduct = new Product(productName.trim(), price);
					productService.addProduct(newProduct);
				}
				case 5 -> {
					System.out.println("Enter buyer id:");
					int userId = in.nextInt();
					System.out.println("Enter product id:");
					int productId = in.nextInt();
					userService.buyProduct(userId, productId);
				}
				case 6 -> {
					System.out.println("Enter user id:");
					int userId = in.nextInt();
					for (Product product : userService.getProductList(userId)) {
						System.out.println(product);
					}
				}
				case 7 -> {
					System.out.println("Enter product id:");
					int userId = in.nextInt();
					for (User user : productService.getUserList(userId)) {
						System.out.println(user);
					}
				}
				case 8 -> {
					System.out.println("Enter user id:");
					int userId = in.nextInt();
					userService.deleteUser(userId);
				}
				case 9 -> {
					System.out.println("Enter product id:");
					int productId = in.nextInt();
					productService.deleteProduct(productId);
				}
				case 10 -> exit = true;
			}
		}
	}
}
