package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cart database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	public Cart() {
	}


	public Cart(int amount, Product product) {
		super();
		this.amount = amount;
		this.product = product;
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	 public double total() {
			return this.amount * (this.product.getPrice());
	    	
	    }
	    public double totalAll() {
	    	double sum=0;
	    	return sum+=this.total();
	    }
	    public double totalPromotion() {
	    	double promotion = total() * (100 - this.getProduct().getPromotion().getPercent());
	    	return promotion;
	    }
	    public int amountAdd() {
	    	return amount++;
	    }
	

}