package br.com.infnet.blocojava.appfinanceiro.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.infnet.blocojava.appfinanceiro.business.AbstractBusiness;
import br.com.infnet.blocojava.appfinanceiro.dao.AbstractDao;

public abstract class AbstractService<T extends AbstractBusiness> {
	
	@Autowired
	protected AbstractDao<T> dao;
	
	public List<T> list() {
		// TODO Auto-generated method stub
		return this.dao.list();
	}

	public void create(T newNegocio) {
		// TODO Auto-generated method stub
		this.dao.create(newNegocio);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		this.dao.delete(id);
	}
	
	public List<T> find(Map<String, String[]> searchParams) {
		// TODO Auto-generated method stub
		return this.list();
	}
	
	public T get(int id) 
	{
		return this.dao.get(id);
	}

	public void update(T negocio) {
		// TODO Auto-generated method stub
		
	}

}
