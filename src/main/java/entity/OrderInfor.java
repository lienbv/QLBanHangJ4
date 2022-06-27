package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_infor database table.
 * 
 */
@Entity
@Table(name="order_infor")
@NamedQuery(name="OrderInfor.findAll", query="SELECT o FROM OrderInfor o")
public class OrderInfor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String description;

	private String status;
	
	private double total;
	
	private int amount;

	//bi-directional many-to-one association to Cart
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="id_customer")
	private Customer customer;

	@OneToMany(mappedBy="order")
	private List<DetailBill> detaibill;
	
	
	public OrderInfor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}
	
	public double totalAll() {
		return this.total * this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<DetailBill> getBils() {
		return this.detaibill;
	}

	public void setBils(List<DetailBill> bils) {
		this.detaibill = bils;
	}

	public DetailBill addBil(DetailBill bil) {
		getBils().add(bil);
		bil.setOrder(this);

		return bil;
	}

	public DetailBill removeBil(DetailBill bil) {
		getBils().remove(bil);
		bil.setOrder(null);

		return bil;
	}

	public OrderInfor(Date date, String description, String status, double total, int amount, Product product,
			Customer customer) {
		super();
		this.date = date;
		this.description = description;
		this.status = status;
		this.total = total;
		this.amount = amount;
		this.product = product;
		this.customer = customer;
	}


	

}