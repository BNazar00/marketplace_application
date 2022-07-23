import java.util.Scanner;

public class InfoManager {
	public void startUserInfoSearchProcess(Users users) {
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
					user.displayBoughtProducts();
				}
				case 2 -> exit = true;
			}
		}
	}
	public void startProductInfoSearchProcess(Products products) {
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
					System.out.println("Enter product id:");
					int productId = in.nextInt();
					while (!products.checkId(productId)) {
						System.out.println("Id not found. Please enter again: ");
						productId = in.nextInt();
					}
					Product product = products.findProduct(productId);
					product.displayUsers();
				}
				case 2 -> exit = true;
			}
		}
	}
}
