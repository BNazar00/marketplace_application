import java.util.Scanner;

public class OrderManager {
	public void start(Users users, Products products) {
		boolean exit = false;
		int productId = -1;
		int userId = -1;
		Scanner in = new Scanner(System.in);
		while (!exit) {
			System.out.println("""
					\nChoose option:
					    1 - Enter buyer id;
					    2 - Enter product id;
					    3 - Exit/create order;
					""");
			int choice = in.nextInt();
			while (choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Invalid Choice!");
				choice = in.nextInt();
			}
			switch (choice) {
				case 1 -> {
					System.out.println("Enter buyer id:");
					userId = in.nextInt();
					while (!users.checkId(userId)) {
						System.out.println("Id not found. Please enter again: ");
						userId = in.nextInt();
					}
				}
				case 2 -> {
					System.out.println("Enter product id:");
					productId = in.nextInt();
					while (!products.checkId(productId)) {
						System.out.println("Id not found. Please enter again: ");
						productId = in.nextInt();
					}
				}
				case 3 -> {
					exit = true;
					if (userId == -1) {
						System.out.println("You didn't input the buyer id.");
						if (productId == -1) {
							System.out.println("You didn't input the product id.");
						}
						System.out.println("Order canceled!");
						break;
					}
					if (productId == -1) {
						System.out.println("You didn't input the product id.");
						System.out.println("Order canceled!");
						break;
					}
					User user = users.findUser(userId);
					Product product = products.findProduct(productId);
					if (user.getAmountOfMoney() < product.getPrice()) {
						System.out.println("User haven't enough money");
						System.out.println("Order canceled!");
						break;
					}

					user.buyProduct(product);
					product.addUser(user);

					System.out.println("Order created!");

				}
			}
		}
	}
}
