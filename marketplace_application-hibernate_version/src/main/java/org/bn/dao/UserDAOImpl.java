package org.bn.dao;

import org.bn.entities.Product;
import org.bn.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserDAOImpl implements UserDAO {
	SessionFactory sessionFactory;

	public UserDAOImpl() {
		sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		List<User> userList = session.createQuery("from User", User.class).getResultList();

		session.getTransaction().commit();
		session.close();

		return userList;
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.persist(user);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void buyProduct(int userId, int productId) throws ArithmeticException {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		User targetUser = session.get(User.class, userId);
		Product targetProduct = session.get(Product.class, productId);
		targetUser.addProductToProductList(targetProduct);

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		session.delete(session.get(User.class, userId));

		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Product> getProductList(int userId) {
		List<Product> result;

		try (Session session = sessionFactory.getCurrentSession()) {
			session.beginTransaction();
			result = session.get(User.class, userId).getProductList();
			session.getTransaction().commit();
		}

		return result;

	}
}
