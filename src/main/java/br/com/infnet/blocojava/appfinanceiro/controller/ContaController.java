package br.com.infnet.blocojava.appfinanceiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.infnet.blocojava.appfinanceiro.business.Conta;
import br.com.infnet.blocojava.appfinanceiro.business.Favorecido;
import br.com.infnet.blocojava.appfinanceiro.services.ContaService;
import br.com.infnet.blocojava.appfinanceiro.services.FavorecidoService;

@Controller
@RequestMapping(value = "/contas")
public class ContaController extends AbstractController<Conta> {

	@Autowired
	private FavorecidoService favorecidoService;

	@Autowired
	private ContaService contaService;

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return "Contas";
	}

	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("favorecidoList", this.favorecidoService.list());
		super.edit(request, response);
	}

	@Override
	public void create(Conta newNegocio, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Favorecido favorecido = favorecidoService.get(newNegocio.getFavorecidoId());
		newNegocio.setFavorecido(favorecido);
		this.contaService.create(newNegocio);
		this.list(request, response);
	}

	@Override
	protected String getEditPath() {
		return "/edit-conta.jsp";
	}
	
	@Override
	protected String getListPath() {
		return "/list-conta.jsp";
	}

}
