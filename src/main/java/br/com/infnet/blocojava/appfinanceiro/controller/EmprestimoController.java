package br.com.infnet.blocojava.appfinanceiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.infnet.blocojava.appfinanceiro.business.Conta;
import br.com.infnet.blocojava.appfinanceiro.business.Emprestimo;
import br.com.infnet.blocojava.appfinanceiro.services.AbstractService;
import br.com.infnet.blocojava.appfinanceiro.services.ContaService;

public abstract class EmprestimoController<T extends Emprestimo, S extends AbstractService<T>> extends AbstractController<T> {


	private static final String PATH_EDIT_EMPRESTIMO_JSP = "/edit-emprestimo.jsp";

	private static final String PATH_LIST_EMPRESTIMO_JSP = "/list-emprestimo.jsp";

	@Autowired
	protected ContaService contaService;
	
	@Autowired
	protected S emprestimoService;
	
	
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contaList", this.contaService.list());
		super.edit(request, response);
	}

	@Override
	public void create(T newNegocio, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Conta conta = contaService.get(newNegocio.getContaId());
		newNegocio.setConta(conta);
		this.emprestimoService.create(newNegocio);
		this.list(request, response);
	}
	
	
	@Override
	protected String getListPath() {
		return PATH_LIST_EMPRESTIMO_JSP;
	}
	
	@Override
	protected String getEditPath() {
		return PATH_EDIT_EMPRESTIMO_JSP;
	}

	
	

}
