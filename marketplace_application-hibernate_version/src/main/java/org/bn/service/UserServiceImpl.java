package org.bn.service;

import org.bn.dao.UserDAO;
import org.bn.dao.UserDAOImpl;
import org.bn.entities.Product;
import org.bn.entities.User;

import java.util.List;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public void buyProduct(int userId, int productId) throws ArithmeticException {
		userDAO.buyProduct(userId, productId);
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

	@Override
	public List<Product> getProductList(int userId) {
		return userDAO.getProductList(userId);
	}
}
