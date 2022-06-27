package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Util.ConnectJPA;
import entity.Customer;
import entity.OrderInfor;

public class Order_Infor_Dao extends BaseDao<OrderInfor> {
	private EntityManager manager;
	private ConnectJPA connectJPA;
	private List<OrderInfor> listOrder;

	public Order_Infor_Dao() {
		this.manager = ConnectJPA.getEntityManager();
		this.listOrder = new ArrayList<OrderInfor>();
	}

	@Override
	public Class<OrderInfor> getmodeclass() {
		// TODO Auto-generated method stub
		return OrderInfor.class;
	}

	@Override
	public String getdatabase() {

		return OrderInfor.class.getSimpleName();
	}

	public List<OrderInfor> showWaiting(String status) {
		String hql = "Select obj from OrderInfor obj where obj.status = :status";
		TypedQuery<OrderInfor> query = this.manager.createQuery(hql, getmodeclass());
		query.setParameter("status", status);
		this.listOrder = query.getResultList();
		return listOrder;
	}
//SELECT DISTINCT o.id_customer, c.fullname, c.address, c.email, o.date, c.phone_number, o.amount, o.total FROM order_infor o JOIN customer  c WHERE o.id_customer = c.id and o.status ="Waiting"
	public List<Object[]> list_Customer_Waiting() {

		TypedQuery<Object[]> query = this.manager.createQuery(
				"SELECT DISTINCT o.customer.id, o.customer.fullname, o.customer.address, o.customer.email, o.date, o.customer.phoneNumber, o.amount, o.total FROM OrderInfor o JOIN o.customer c WHERE o.customer.id = c.id and o.status =:statuss GROUP BY o.customer.id",
				Object[].class);
		query.setParameter("statuss", "Waiting");
		List<Object[]> lst = query.getResultList();
        System.out.println(lst +"asdfghj");
		return lst;

	}
	//SELECT COUNT(DISTINCT o.id_customer )FROM order_infor o join customer c WHERE o.id_customer = c.id; 
	public int count() {
		try {
			String qery = "SELECT COUNT(DISTINCT o.customer.id ) FROM OrderInfor o join o.customer c WHERE o.customer.id = c.id";
			Query sql = manager.createQuery(qery);
			return ((Long) sql.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

	public List<OrderInfor> list_Product_Customer_Waiting(Customer cus , String status) {

		String hql = "Select obj from OrderInfor obj where obj.on  = :status and obj.customer.id =:id";
		TypedQuery<OrderInfor> query = this.manager.createQuery(hql, getmodeclass());
		query.setParameter("status",status );
		query.setParameter("id",cus.getId());
		this.listOrder = query.getResultList();
		System.out.println(this.listOrder);
		return listOrder;

	}

	public List<OrderInfor> showConfirm() {
		String hql = "Select obj from OrderInfor obj where obj.status = :status";
		TypedQuery<OrderInfor> query = this.manager.createQuery(hql, getmodeclass());
		query.setParameter("status", "Confirm");
		this.listOrder = query.getResultList();
		return listOrder;

	}

	public OrderInfor updateToCancel(OrderInfor order) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql = "UPDATE OrderInfor obj SET obj.status = :status WHERE id =:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("status", order.getStatus());
			query.setParameter("id", order.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return order;

	}
	/*
	 * public OrderInfor updateToConfirm(OrderInfor order) { try {
	 * this.manager.getTransaction().begin(); this.manager.flush();
	 * this.manager.clear(); String
	 * hql="UPDATE OrderInfor obj SET obj.status = :status WHERE id =:id"; Query
	 * query=this.manager.createQuery(hql); query.setParameter("status",
	 * order.getStatus()); query.setParameter("id", order.getId());
	 * query.executeUpdate(); this.manager.getTransaction().commit(); }catch
	 * (Exception e) { e.printStackTrace();
	 * this.manager.getTransaction().rollback(); } return order;
	 * 
	 * }
	 */

}
