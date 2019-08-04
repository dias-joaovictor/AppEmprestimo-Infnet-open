package br.com.infnet.blocojava.appfinanceiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.blocojava.appfinanceiro.business.Penhor;
import br.com.infnet.blocojava.appfinanceiro.services.PenhorService;

@Controller
@RequestMapping(value = "/penhores")
public class PenhorController extends EmprestimoController<Penhor, PenhorService> {

	
	
	
	
	
	
	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return "Penhores";
	}

}
