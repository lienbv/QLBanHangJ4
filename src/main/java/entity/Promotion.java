package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@NamedQuery(name="Promotion.findAll", query="SELECT p FROM Promotion p")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int percent;

	@Column(name="promo_code")
	private String promoCode;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="promotion")
	private List<Product> products;

	public Promotion() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPercent() {
		return this.percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setPromotion(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setPromotion(null);

		return product;
	}

}