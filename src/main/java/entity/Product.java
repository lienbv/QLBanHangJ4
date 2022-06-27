package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int amount;

	private String color;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String description;

	private String img1;

	private String img2;

	private String name;

	private double price;

	private String size;
	private String status;

	// bi-directional many-to-one association to Cart
	@OneToMany(mappedBy = "product")
	private List<Cart> carts;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	// bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name = "id_promotion")
	private Promotion promotion;

	public Product() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double giaPromotion() {
		double pricePromotion = (double) this.price * (100 - this.promotion.getPercent());

		return pricePromotion;

	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setProduct(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setProduct(null);

		return cart;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	@OneToMany(mappedBy="product")
	private List<OrderInfor> orderInfors;

	public List<OrderInfor> getOrderInfors() {
		return this.orderInfors;
	}

	public void setOrderInfors(List<OrderInfor> orderInfors) {
		this.orderInfors = orderInfors;
	}

	public OrderInfor addOrderInfor(OrderInfor orderInfor) {
		getOrderInfors().add(orderInfor);
		orderInfor.setProduct(this);

		return orderInfor;
	}

	public OrderInfor removeOrderInfor(OrderInfor orderInfor) {
		getOrderInfors().remove(orderInfor);
		orderInfor.setProduct(null);

		return orderInfor;
	}

	
	


}