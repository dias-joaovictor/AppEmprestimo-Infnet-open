package br.com.infnet.blocojava.appfinanceiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.blocojava.appfinanceiro.business.Pessoal;
import br.com.infnet.blocojava.appfinanceiro.services.PessoalService;

@Controller
@RequestMapping(value = "/pessoais")
public class PessoalController extends EmprestimoController<Pessoal, PessoalService> {

	@Override
	protected String getTitle() {
		return "Pessoais";
	}

}
