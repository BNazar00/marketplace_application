package org.bn.dao;

import org.bn.entities.Product;
import org.bn.entities.User;

import java.util.List;

public interface ProductDAO {
	List<Product> getAllProducts();

	void addProduct(Product product);

	void deleteProduct(int productId);

	List<User> getUserList(int productId);
}
