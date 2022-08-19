package org.bn.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "amount_of_money")
	private int amountOfMoney;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
				fetch = FetchType.EAGER)
	@JoinTable(
			name = "product_list",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> productList;

	public User() {
	}

	public User(String firstName, String lastName, int amountOfMoney) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.amountOfMoney = amountOfMoney;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(int amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public void addProductToProductList(Product product) throws ArithmeticException {
		if (getAmountOfMoney() < product.getPrice())
			throw new ArithmeticException("Not enough money!");
		else
			amountOfMoney -= product.getPrice();

		if (productList == null)
			productList = new ArrayList<>();

		productList.add(product);
	}

	public List<Product> getProductList() {
		return productList;
	}

	@Override
	public String toString() {
		return "id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", amountOfMoney=" + amountOfMoney;
	}
}
