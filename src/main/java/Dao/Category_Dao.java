package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Util.ConnectJPA;
import entity.Category;
import entity.Customer;

public class Category_Dao extends BaseDao<Category>{
	private EntityManager manager;
	private ConnectJPA connectJPA;
	private List<Category> lstCategory;
	
	public Category_Dao() {
		this.manager = ConnectJPA.getEntityManager();
		this.lstCategory = new ArrayList<Category>();
	}
	@Override
	public Class<Category> getmodeclass() {
		// TODO Auto-generated method stub
		return Category.class;
	}

	@Override
	public String getdatabase() {
		// TODO Auto-generated method stub
		return Category.class.getSimpleName();
	}
 public List<Category> getAll_status(){
	 String hql ="Select obj from Category obj Where obj.status =:status";
	 TypedQuery<Category> query = this.manager.createQuery(hql, getmodeclass());
	 query.setParameter("status", "selling");
	 this.lstCategory = query.getResultList();
	 return this.lstCategory;
 }
	public Category updateToStatus(Category cus) {
		try {
			this.manager.getTransaction().begin();
			this.manager.flush();
			this.manager.clear();
			String hql = "UPDATE Category obj SET obj.status = :status WHERE id =:id";
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
