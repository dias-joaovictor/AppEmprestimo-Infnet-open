package br.com.infnet.blocojava.appfinanceiro.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.reflect.TypeToken;

import br.com.infnet.blocojava.appfinanceiro.business.AbstractBusiness;
import br.com.infnet.blocojava.appfinanceiro.business.Favorecido;
import br.com.infnet.blocojava.appfinanceiro.services.AbstractService;
import br.com.infnet.blocojava.appfinanceiro.utils.ColumnMetadata;



public abstract class AbstractController <T extends AbstractBusiness> {
	
	private static final String LIST_DEFAULT_PATH = "/list.jsp";

	private static final String EDIT_DEFAULT_PATH = "/edit.jsp";
	
	@Autowired
	private AbstractService<T> service;
	
	protected abstract String getTitle();
	
	private String getControllerPath() 
	{
		return this.getClass().getAnnotation(RequestMapping.class).value()[0];
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<T> negocios = this.service.list();
		request.setAttribute("list", negocios);
		
		forwardToList(request, response);
	}
	
	private void forwardToList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String negocioName = this.getTitle();
		request.setAttribute("title", negocioName);
		
		TypeToken<T> typeToken = new TypeToken<T>(this.getClass()) {};
		Class<T> negocioClass = (Class<T>) typeToken.getRawType();
		Map<String, ColumnMetadata> fieldsNames = AbstractBusiness.getFieldsToHeader(negocioClass);
		request.setAttribute("fields", fieldsNames);
		
		String backUrl = request.getContextPath();
		request.setAttribute("back", backUrl);
		
		request.getRequestDispatcher(getListPath()).forward(request, response);
	}
	
	protected String getListPath() {
		return LIST_DEFAULT_PATH;
	}

	@RequestMapping(value = "/", 
					method = RequestMethod.POST, 
					consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void create(
						T newNegocio, 
						HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException 
	{
		 this.service.create(newNegocio);
		 this.list(request, response);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void edit(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException
	{
		
		String negocioName = this.getTitle();
		request.setAttribute("title", negocioName);
		
		TypeToken<T> typeToken = new TypeToken<T>(this.getClass()) {};
		Class<T> negocioClass = (Class<T>) typeToken.getRawType();
		Map<String, ColumnMetadata> fieldsNames = AbstractBusiness.getFieldsToHeader(negocioClass);
		
		request.setAttribute("fields", fieldsNames);
		
		
		String destinyUrl = this.getCompleteControllerPath(request);
		request.setAttribute("destiny", destinyUrl);
		
		request.getRequestDispatcher(getEditPath()).forward(request, response);	
	}

	protected String getEditPath() {
		return EDIT_DEFAULT_PATH;
	}

	private String getCompleteControllerPath(HttpServletRequest request) {
		return String.format("%s/%s/", request.getContextPath(), this.getControllerPath());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void read(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.service.delete(id);
		this.list(request, response);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void read(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException
	{
		Map<String, String[]> searchParams = request.getParameterMap();
		
		List<T> negocios = this.service.find(searchParams);
		
		request.setAttribute("list", negocios);
		
		this.forwardToList(request, response);
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.PUT)
	public void update(@RequestBody T negocio, HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException 
	{
		this.service.update(negocio);
		
		this.list(request, response);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	public void delete (@PathVariable("id") int id, HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException 
	{
		this.service.delete(id);
		
//		this.list(request, response);
	}
	
	public static void main(String[] args) {
		System.out.println(Favorecido.class.getSuperclass().equals(AbstractBusiness.class));
	}
	
	
	public List<T> listarTodos(){
		return this.service.list();
	}
	
}
