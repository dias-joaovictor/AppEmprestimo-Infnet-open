package br.com.infnet.blocojava.appfinanceiro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.infnet.blocojava.appfinanceiro.business.Usuario;
import br.com.infnet.blocojava.appfinanceiro.services.UsuarioService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/")
	public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getSession().getAttribute("logged") != null) 
		{
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}else 
		{
			request.setAttribute("error", "Usuário ou senha incorreta");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	
	@RequestMapping("/auth")
	public void autenticar(@RequestParam String email, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Usuario usuarioByEmail = this.usuarioService.getUsuarioByEmailAndPassword(email, password);
		
		if(usuarioByEmail != null) 
		{
			request.getSession().setAttribute("logged", usuarioByEmail);
			
			request.getRequestDispatcher("main.jsp").forward(request, response);
			
		}
		else 
		{
			
			response.sendRedirect( request.getContextPath() + "/");
			
			request.setAttribute("error", "Usuário ou senha incorreta");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	} 
	
}
