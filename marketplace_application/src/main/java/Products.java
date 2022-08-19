import java.util.ArrayList;
import java.util.List;

public class Products {
	private List<Product> productList;

	public Products() {
		productList = new ArrayList<>();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public void displayProducts() {
/*		productList.sort(new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getId() - p2.getId();
			}
		});*/
		productList.forEach(product -> System.out.println(product.toString()));
	}

	public boolean checkId(int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Product findProduct(int id) {
		for (Product product : productList) {
			if (product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	public void removeProduct(Product product) {
		productList.remove(product);
	}
}
