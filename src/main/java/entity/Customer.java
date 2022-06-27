package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private String email;

	private String fullname;

	private String img;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	private String username;
	
	private String role;
	
	private String status;

	//bi-directional many-to-one association to OrderInfor
	@OneToMany(mappedBy="customer")
	private List<OrderInfor> orderInfors;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderInfor> getOrderInfors() {
		return this.orderInfors;
	}

	public void setOrderInfors(List<OrderInfor> orderInfors) {
		this.orderInfors = orderInfors;
	}

	public OrderInfor addOrderInfor(OrderInfor orderInfor) {
		getOrderInfors().add(orderInfor);
		orderInfor.setCustomer(this);

		return orderInfor;
	}

	public OrderInfor removeOrderInfor(OrderInfor orderInfor) {
		getOrderInfors().remove(orderInfor);
		orderInfor.setCustomer(null);

		return orderInfor;
	}

}