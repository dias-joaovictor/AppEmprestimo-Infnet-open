package br.com.infnet.blocojava.appfinanceiro.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import br.com.infnet.blocojava.appfinanceiro.business.Usuario;



@Repository
public class UsuarioDao extends AbstractDao<Usuario>{
	
	public Usuario getByEmailAndPassword(String email, String password) 
	{
		Session currentSession = this.getCurrentSession();
		
		List users = currentSession.createQuery("from Usuario where email = :email and password = :password ")
		.setString("password", password)
		.setString("email", email)
		.list();
		
		if(users.size() > 0) 
		{
			return (Usuario) users.get(0);
		}
		
		return null;
	}
	
}
