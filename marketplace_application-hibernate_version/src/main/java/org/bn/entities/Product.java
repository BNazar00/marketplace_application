package org.bn.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private int price;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
			fetch = FetchType.EAGER)
	@JoinTable(
			name = "product_list",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> userList;

	public Product() {
	}

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void addUserToBuyerList(User user) throws ArithmeticException {
		if (user.getAmountOfMoney() < price)
			throw new ArithmeticException("Not enough money!");
		else
			user.setAmountOfMoney(user.getAmountOfMoney() - price);

		if (userList == null)
			userList = new ArrayList<>();

		userList.add(user);
	}

	@Override
	public String toString() {
		return "id=" + id +
				", name='" + name + '\'' +
				", price=" + price;
	}
}
