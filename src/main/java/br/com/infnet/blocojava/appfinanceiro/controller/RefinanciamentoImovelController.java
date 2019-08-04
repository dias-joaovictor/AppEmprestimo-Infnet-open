package br.com.infnet.blocojava.appfinanceiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.blocojava.appfinanceiro.business.RefinanciamentoImovel;
import br.com.infnet.blocojava.appfinanceiro.services.RefinancionamentoService;

@Controller
@RequestMapping(value = "/refinanciamentos_imoveis")
public class RefinanciamentoImovelController extends EmprestimoController<RefinanciamentoImovel, RefinancionamentoService>{

	@Override
	protected String getTitle() {
		return "Refinanciamento Imóvel";
	}

}
