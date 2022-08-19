package org.bn.service;

import org.bn.entities.Product;
import org.bn.entities.User;

import java.util.List;

public interface UserService {
	List<User> getAllUsers();

	void addUser(User user);

	void buyProduct(int userId, int productId) throws ArithmeticException;

	void deleteUser(int userId);
	List<Product> getProductList(int userId);

}
