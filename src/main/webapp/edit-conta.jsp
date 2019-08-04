<%@page import="br.com.infnet.blocojava.appfinanceiro.business.Favorecido"%>
<%@page import="br.com.infnet.blocojava.appfinanceiro.dao.ContaDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.infnet.blocojava.appfinanceiro.business.AbstractBusiness"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.infnet.blocojava.appfinanceiro.utils.ColumnMetadata"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AppFinanceiro</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/scripts/edit.js"></script>
</head>
<body>

	<%
		String title = (String) request.getAttribute("title");
		Map<String, ColumnMetadata> fields = (Map<String, ColumnMetadata>) request.getAttribute("fields");
		String destiny = (String) request.getAttribute("destiny");
		List<Favorecido> favorecidos = (List<Favorecido>)request.getAttribute("favorecidoList");
	%>
	
	<div class="container">
		<h4><%=request.getSession().getAttribute("logged") %></h4>
		
		<hr>
		
		<h3><%=title%></h3>
		
		<div class="row">
			<a href="<%=destiny%>" class="btn btn-primary">Voltar</a>
		</div>
		
		<form action="<%=destiny%>" method="POST">
			<% for(String fieldName: fields.keySet()) { %>
				
				<% ColumnMetadata fieldData = fields.get(fieldName); %>
				<div class="form-group">
			 	<%
	    		if(!fieldData.getTitle().equalsIgnoreCase("favorecido"))
	    		{
	    		%>
			      <label for="<%=fieldName %>"><%=fieldData.getTitle()%>:</label>
			      
			     
			      
			    	<%
			    		if(fieldData.getType().equals(String.class))
			    		{
			    			%>
		    					<input type="text" class="form-control" id="<%=fieldName %>" name="<%=fieldName%>">
	    					<%	
			    		}else if(fieldData.getType().equals(Date.class)){
			    			%>
	    						<input type="date" class="form-control" id="<%=fieldName %>" name="<%=fieldName%>">
    						<%
			    		}else if(fieldData.getType().equals(Boolean.class)){
			    			%>
							  <select class="form-control" id="<%=fieldName%>" name="<%=fieldName%>">
							    <option disabled>Escolha ...</option>
							    <option value=1>Sim</option>
							    <option value=0>Não</option>
							  </select>
    						<%
			    		}
			    		else if(fieldData.getType().isPrimitive())
			    		{
			    			
			    			%>
	    						<input type="number" class="form-control" id="<%=fieldName %>" name="<%=fieldName%>">
    						<%
			    		}
			    	%> 
			    	
			    	<%
		    		}
		    		%> 
			      
			    </div>
			
			<% } %>
			
			
			<div class="form-group">
			    <label for="listaFavorecidosSelect">Favorecidos</label>
			    <select class="form-control" id="favorecidoId" name="favorecidoId">
			      <% for(Favorecido favorecido: favorecidos) { %>
						<option value="<%=favorecido.getId()%>" id="favorecidoId" name="favorecidoId"><%=favorecido.getNome()%></option>  
					<% } %>
				</select>
			</div>
			
			<button type="submit">SALVAR</button>
		</form>
	</div>
</body>
</html>