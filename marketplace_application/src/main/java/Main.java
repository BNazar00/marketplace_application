import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean exit = false;
		Products products = new Products();
		Users users = new Users();
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
				case 1 -> users.displayUsers();
				case 2 -> products.displayProducts();
				case 3 -> {
					System.out.println("Enter first name:");
					in.nextLine();
					String firstName = in.nextLine();
					while(firstName.strip().length() == 0){
						System.out.println("You must enter first name in appropriate way.");
						firstName = in.nextLine();
					}
					System.out.println("Enter last name:");
					String lastName = in.nextLine();
					while(firstName.strip().length() == 0){
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
					users.addUser(newUser);
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
					products.addProduct(newProduct);
				}
				case 5 -> {
					OrderManager orderManager = new OrderManager();
					orderManager.start(users, products);
				}
				case 6 -> {
					InfoManager infoManager = new InfoManager();
					infoManager.startUserInfoSearchProcess(users);
				}
				case 7 -> {
					InfoManager infoManager = new InfoManager();
					infoManager.startProductInfoSearchProcess(products);
				}
				case 8 -> {
					DeletingManager deletingManager = new DeletingManager();
					deletingManager.startUserDeleting(users);
				}
				case 9 -> {
					DeletingManager deletingManager = new DeletingManager();
					deletingManager.startProductDeleting(products);
				}
				case 10 -> exit = true;
			}
		}
	}
}