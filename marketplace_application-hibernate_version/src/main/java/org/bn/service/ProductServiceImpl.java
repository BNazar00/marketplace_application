package org.bn.service;

import org.bn.dao.ProductDAO;
import org.bn.dao.ProductDAOImpl;
import org.bn.entities.Product;
import org.bn.entities.User;

import java.util.List;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;

	public ProductServiceImpl() {
		productDAO = new ProductDAOImpl();
	}

	@Override
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

	@Override
	public List<User> getUserList(int productId) {
		return productDAO.getUserList(productId);
	}

}
