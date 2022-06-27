package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Util.ConnectJPA;
import Util.EncryptUtil;
import entity.Customer;
import entity.OrderInfor;

public class Customer_Dao extends BaseDao<Customer> {
	private EntityManager manager;
	private ConnectJPA connectJPA;
	private Customer cust;
	private List<Customer> listcustomer;

	public Customer_Dao() {
		this.manager = ConnectJPA.getEntityManager();
		this.cust = new Customer();
		this.listcustomer = new ArrayList<>();

	}

	@Override
	public Class<Customer> getmodeclass() {
		// TODO Auto-generated method stub
		return Customer.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Customer.class.getSimpleName();
	}

	// login
	public Customer login(String username, String password) {
		try {
			String hql = "SELECT obj FROM Customer obj where obj.username= :userName";
			TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
			query.setParameter("userName", username);
			this.listcustomer = query.getResultList();
			for (Customer customer : this.listcustomer) {
				if (EncryptUtil.checkPass(password, customer.getPassword())) {
					System.out.println(customer + "cus");
					return customer;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Customer LoginUserName(String username) {

		String hql = "SELECT obj FROM Customer obj WHERE obj.username =:userName";
		TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
		query.setParameter("userName", username);
		this.cust = query.getSingleResult();
		System.out.println(this.cust + "cust");
		return this.cust;
	}

	public Customer checkUserName(String username) {
		try {
			String hql = "SELECT obj FROM Customer obj WHERE obj.username =:userName";
			TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
			query.setParameter("userName", username);
			this.cust = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return this.cust;
	}

	public Customer checkPhoneNumber(String phone) {

		try {
			String hql = "SELECT obj FROM Customer obj WHERE obj.phoneNumber =:phonenumber";
			TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
			query.setParameter("phonenumber", phone);
			this.cust = query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			return null;
		}
		return this.cust;
	}

	public Customer updateProfile(Customer customer) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql = "UPDATE Customer obj SET obj.address = :diachi, obj.email =:mail , obj.fullname =:fullname, obj.img =:img, obj.phoneNumber =:phone WHERE id =:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("diachi", customer.getAddress());
			query.setParameter("mail", customer.getEmail());
			query.setParameter("fullname", customer.getFullname());
			query.setParameter("img", customer.getImg());
			query.setParameter("phone", customer.getPhoneNumber());
			query.setParameter("id", customer.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return customer;

	}

	public Customer ChangePass(Customer customer) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql = "UPDATE Customer obj SET obj.password = :pass where id =:id";
			Query query = this.manager.createQuery(hql);
			String hash = EncryptUtil.hashPassword(customer.getPassword());
			query.setParameter("pass", hash);
			query.setParameter("id", customer.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return customer;

	}

	public List<Customer> finduserbysdt(Customer k, String phone) {
		try {
			String hql = "SELECT k FROM Customer k WHERE k.phoneNumber =:number_phone and k.id !=:user";
			TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
			query.setParameter("number_phone", phone);
			query.setParameter("user", k.getId());
			return this.listcustomer = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Customer> finduser_Status(String status, String role) {
		String hql = "SELECT k FROM Customer k WHERE k.status =:status and k.role =:role";
		TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
		query.setParameter("status", status);
		query.setParameter("role", role);
		this.listcustomer = query.getResultList();
		return this.listcustomer;
	}

	public List<Customer> findEmail(String username, String email) {
		try {
			String hql = "SELECT obj FROM Customer obj WHERE obj.username= :userName and obj.email =:mail";
			TypedQuery<Customer> query = manager.createQuery(hql, Customer.class);
			query.setParameter("userName", username);
			query.setParameter("mail", email);
			this.listcustomer = query.getResultList();
			for (Customer list : this.listcustomer) {
				if (username.equals(list.getUsername()) && email.equals(list.getEmail())) {
					return this.listcustomer;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Customer updateToStatus(Customer cus) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql = "UPDATE Customer obj SET obj.status = :status WHERE id =:id";
			Query query = this.manager.createQuery(hql);
			query.setParameter("status", cus.getStatus());
			query.setParameter("id", cus.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return cus;

	}
	
}
