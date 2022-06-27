package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Util.ConnectJPA;
import entity.Category;
import entity.Product;
import entity.Promotion;


public class Product_Dao extends BaseDao<Product>{
	private EntityManager manager;
	private ConnectJPA connectJPA;
	private Product product;
	private List<Product> listProduct;
	
	public Product_Dao() {
		this.manager = connectJPA.getEntityManager();
		this.product = new Product();
		this.listProduct = new ArrayList<>();
	}
	@Override
	public Class<Product> getmodeclass() {

		return Product.class;
	}

	@Override
	public String getdatabase() {

		return Product.class.getSimpleName();
	}
	
	public List<Product>  getAllSelling() {
		String hql = "Select obj from Product obj where obj.status =:statuss";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	
	public List<Product>  getBestSaler() {
		String hql = "Select obj from Product obj where obj.promotion.percent > 0 and obj.status =:statuss";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	public List<Product>  getPriceMax() {
		String hql = "Select obj from Product obj  where obj.status =:statuss ORDER BY obj.price DESC ";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	public List<Product>  getPriceMin() {
		String hql = "Select obj from Product obj where obj.status =:statuss ORDER BY obj.price ASC ";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	public List<Product>  getdateNew() {
		String hql = "Select obj from Product obj where obj.status =:statuss ORDER BY obj.date DESC ";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	public List<Product>  getCategory( Category category) {
		String hql = "Select obj from Product obj where obj.category =:idCategory and obj.status =:statuss";
		TypedQuery<Product> query = manager.createQuery(hql, Product.class);
		query.setParameter("idCategory", category);
		query.setParameter("statuss", "selling");
        this.listProduct = query.getResultList();
	    return this.listProduct;
	}
	
	public Product update_status_Product(Product p) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql="UPDATE Product obj SET obj.status = :status WHERE id =:id";
			Query query=this.manager.createQuery(hql);
			query.setParameter("status", p.getStatus());
			query.setParameter("id", p.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return p;
	}
	
	
	public Product update_status_Amount_Product(Product p) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql="UPDATE Product obj SET obj.amount =:sl  WHERE id =:id";
			Query query=this.manager.createQuery(hql);
			query.setParameter("sl", p.getAmount());
			query.setParameter("id", p.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		return p;
	}
//	
//	UPDATE products p
//	SET p.amount = (SELECT p.amount - o.amount
//	          FROM order_infor o
//	          WHERE  o.status ='Confirm' and p.id = o.id_product)
//	WHERE p.id = 8;
	
	public Product update_Amount_Product(Product p) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql="UPDATE Product p SET p.amount = (SELECT p.amount - o.amount FROM OrderInfor o WHERE  o.status ='Confirm' and p.id = o.product.id) "
					+ " WHERE p.id = :id";
			Query query=this.manager.createQuery(hql);
			query.setParameter("id", p.getId());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		System.out.println(p+"abc");
		return p;
	}
	public Product updateASmount(Product p) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql="UPDATE Product obj SET obj.amount = :sl WHERE id =:id";
			Query query=this.manager.createQuery(hql);
			query.setParameter("id",p.getId());
			query.setParameter("sl",p.getAmount());
			query.executeUpdate();
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
		System.out.println(p+"abc");
		return p;
	}
	

}
