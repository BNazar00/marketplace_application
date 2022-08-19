package org.bn.service;

import org.bn.entities.Product;
import org.bn.entities.User;

import java.util.List;

public interface ProductService {
	List<Product> getAllProducts();

	void addProduct(Product product);

	void deleteProduct(int productId);
	List<User> getUserList(int productId);

}
