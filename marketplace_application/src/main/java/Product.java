import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {
	private static int uniqueIdGenerator = 0;
	private final int id;
	private final int price;
	private final String name;
	private final List<User> userList;

	public Product(String name, int price) {
		userList = new ArrayList<>();
		uniqueIdGenerator++;
		id = uniqueIdGenerator;
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public int getId() {
		return id;
	}

	public List<User> getUserList() {
		return userList;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name='" + name + '\'' + ", price=" + price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return id == product.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void addUser(User buyer) {
		userList.add(buyer);
	}

	public void removeUser(User buyer) {
		userList.remove(buyer);
	}

	public void displayUsers() {
		userList.forEach(System.out::println);
	}
}
