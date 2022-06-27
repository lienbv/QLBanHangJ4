package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Util.ConnectJPA;

abstract public class BaseDao<T>{
	abstract public Class<T> getmodeclass();
	abstract public String getdatabase();
	private EntityManager manager;
	private ConnectJPA connectJPA;
	public BaseDao() {
		this.manager = ConnectJPA.getEntityManager();

	}
	public T insert(T t) throws Exception{
		try {
			this.manager.getTransaction().begin();
			this.manager.persist(t);
			this.manager.flush();
			this.manager.getTransaction().commit();
			return t;
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			throw e;
		}
	}
	public T update(T t) throws Exception{
		try {
			this.manager.getTransaction().begin();
			this.manager.merge(t);
			this.manager.getTransaction().commit();
			return t;
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			throw e;
		}

	}
	public T findbyid(int id) {
		T t=this.manager.find(getmodeclass(), id);
		return t;
	}
	public void delete(int id) throws Exception{
		try {
			T t = findbyid(id);
			this.manager.getTransaction().begin();
			this.manager.remove(t);
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			this.manager.getTransaction().rollback();
			throw e;
		}
		
		
	}
	public List<T> getAll(){
		String hql="from "+getdatabase();
		TypedQuery<T> query=this.manager.createQuery(hql,getmodeclass());
		List<T> lst=query.getResultList();
		return lst;
	}
}


