package org.bn.dao;

import org.bn.entities.Product;
import org.bn.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	SessionFactory sessionFactory;

	public ProductDAOImpl() {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
	}
	@Override
	public List<Product> getAllProducts() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<Product> productList = session.createQuery("from Product", Product.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return productList;
	}

	@Override
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.persist(product);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(session.get(Product.class, productId));

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<User> getUserList(int productId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<User> result = session.get(Product.class, productId).getUserList();

		session.getTransaction().commit();
		session.close();

		return result;
	}
}
