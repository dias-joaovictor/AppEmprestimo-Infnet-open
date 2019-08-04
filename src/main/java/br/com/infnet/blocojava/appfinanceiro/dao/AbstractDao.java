package br.com.infnet.blocojava.appfinanceiro.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.reflect.TypeToken;

import br.com.infnet.blocojava.appfinanceiro.business.AbstractBusiness;

public abstract class AbstractDao<T extends AbstractBusiness> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> negocioClass;
	
	public AbstractDao() 
	{
		TypeToken<T> typeToken = new TypeToken<T>(this.getClass()) {};
		this.negocioClass = (Class<T>) typeToken.getRawType();
	}
	
	protected Session getCurrentSession() 
	{
		try 
		{
			return this.sessionFactory.getCurrentSession();
		}
		catch (HibernateException e) 
		{
		    return sessionFactory.openSession();
		}
	}
	
	
	public void create(T negocio) 
	{
		Session currentSession = this.getCurrentSession();
		
		currentSession.save(negocio);
		
		currentSession.flush();
		currentSession.close();
		
	}
	
	public List<T> list()
	{
		Session currentSession = this.getCurrentSession();
		
		List<T> list = currentSession.createCriteria(this.negocioClass).list();
		
		currentSession.flush();
		currentSession.close();
		
		return list;
		
	}

	public T get(int id) {
		// TODO Auto-generated method stub
		Session currentSession = this.getCurrentSession();
		
		T negocio = (T) currentSession.get(this.negocioClass, id);
		
		currentSession.flush();
		currentSession.close();
		
		return negocio;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
		Session currentSession = this.getCurrentSession();
		
		T negocio = this.get(id);
		currentSession.delete(negocio);
		
		currentSession.flush();
		currentSession.close();
	}
	
}
