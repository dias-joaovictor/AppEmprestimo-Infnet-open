package br.com.infnet.blocojava.appfinanceiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.infnet.blocojava.appfinanceiro.business.Favorecido;

@Controller
@RequestMapping(value = "/favorecidos")
public class FavorecidoController extends AbstractController<Favorecido> {

	@Override
	protected String getTitle() {
		// TODO Auto-generated method stub
		return "Favorecidos";
	}

}
