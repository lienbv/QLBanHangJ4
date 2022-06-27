package entity;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="detail_bill")
@NamedQuery(name="DetailBill.findAll", query="SELECT d FROM DetailBill d")
public class DetailBill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int amount;

	@Column(name="into_money")
	private int intoMoney;

	@ManyToOne
	@JoinColumn(name="id_order_infor")
	private OrderInfor order;


	public DetailBill() {
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

	public int getIntoMoney() {
		return this.intoMoney;
	}

	public void setIntoMoney(int intoMoney) {
		this.intoMoney = intoMoney;
	}

	public OrderInfor getOrder() {
		return order;
	}

	public void setOrder(OrderInfor order) {
		this.order = order;
	}


}