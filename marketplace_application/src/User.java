import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	private static int uniqueIdGenerator = 0;
	private final int id;
	private final String firstName, lastName;
	private int amountOfMoney;
	private List<Product> productList;

	public User(String firstName, String lastName, int amountOfMoney) {
		productList = new ArrayList<>();
		uniqueIdGenerator++;
		id = uniqueIdGenerator;
		this.amountOfMoney = amountOfMoney;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", amountOfMoney='" + amountOfMoney + '\'';
	}

	public int getId() {
		return id;
	}

	public int getAmountOfMoney() {
		return amountOfMoney;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void buyProduct(Product product) {
		amountOfMoney -= product.getPrice();
		productList.add(product);
	}

	public void removeProduct(Product product) {
		productList.remove(product);
	}

	public void displayBoughtProducts() {
		productList.forEach(System.out::println);
	}

}
