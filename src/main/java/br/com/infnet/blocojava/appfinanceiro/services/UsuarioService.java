package br.com.infnet.blocojava.appfinanceiro.services;

import org.springframework.stereotype.Service;

import br.com.infnet.blocojava.appfinanceiro.business.Usuario;
import br.com.infnet.blocojava.appfinanceiro.dao.UsuarioDao;


@Service
public class UsuarioService extends AbstractService<Usuario>{

	public Usuario getUsuarioByEmailAndPassword(String email, String password)
	{
		UsuarioDao usuarioDao = (UsuarioDao) this.dao;
		
		Usuario byEmailAnsPassword = usuarioDao.getByEmailAndPassword(email, password);
		
		return byEmailAnsPassword;
	}
	
}
