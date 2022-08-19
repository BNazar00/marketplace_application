import java.util.List;
import java.util.Scanner;

public class DeletingManager {
	public void startUserDeleting(Users users) {
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		while (!exit) {
			System.out.println("""
					\nChoose option:
					    1 - Enter buyer id;
					    2 - Exit;
					""");
			int choice = in.nextInt();
			while (!(choice >= 1 && choice <= 2)) {
				System.out.println("Invalid Choice!");
				choice = in.nextInt();
			}
			switch (choice) {
				case 1 -> {
					System.out.println("Enter buyer id:");
					int userId = in.nextInt();
					while (!users.checkId(userId)) {
						System.out.println("Id not found. Please enter again: ");
						userId = in.nextInt();
					}
					User user = users.findUser(userId);
					users.removeUser(user);
					deleteUserInfo(user);
					System.out.println("User deleted!");
				}
				case 2 -> exit = true;
			}
		}
	}

	public void startProductDeleting(Products products) {
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		while (!exit) {
			System.out.println("""
					\nChoose option:
					    1 - Enter product id;
					    2 - Exit;
					""");
			int choice = in.nextInt();
			while (!(choice >= 1 && choice <= 2)) {
				System.out.println("Invalid Choice!");
				choice = in.nextInt();
			}
			switch (choice) {
				case 1 -> {
					System.out.println("Enter buyer id:");
					int productId = in.nextInt();
					while (!products.checkId(productId)) {
						System.out.println("Id not found. Please enter again: ");
						productId = in.nextInt();
					}
					Product product = products.findProduct(productId);
					products.removeProduct(product);
					deleteProductInfo(product);
					System.out.println("Product deleted!");
				}
				case 2 -> exit = true;
			}
		}
	}

	private void deleteUserInfo(User user) {
		List<Product> productList = user.getProductList();
		productList.forEach(product -> product.removeUser(user));
	}

	private void deleteProductInfo(Product product) {
		List<User> userList = product.getUserList();
		userList.forEach(user -> user.removeProduct(product));
	}
}
