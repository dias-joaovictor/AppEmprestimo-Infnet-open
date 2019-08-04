
<%@page import="br.com.infnet.blocojava.appfinanceiro.business.AbstractBusiness"%>
<%@page import="br.com.infnet.blocojava.appfinanceiro.utils.ColumnMetadata"%>
<%@page import="java.util.Map"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>AppFinanceiro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <script src="<%=request.getContextPath()%>/resources/scripts/list.js"></script>
  
</head>
<body>
	
	<%
		String title = (String) request.getAttribute("title");
		Map<String, ColumnMetadata> fields = (Map<String, ColumnMetadata>) request.getAttribute("fields");
		List<AbstractBusiness> list = (List<AbstractBusiness>) request.getAttribute("list");
		
		String currentUrl = (String) request.getAttribute("javax.servlet.forward.request_uri");
		String back = (String) request.getAttribute("back");
	%>
	
	<script>
		
		currentUrl = '<%=currentUrl%>';
	
	</script>
	
	<div class="container">
		
		<h4><%=request.getSession().getAttribute("logged") %></h4>
		
		<hr>
		
		<h3><%=title%></h3>
		
		<div class="row">
			<a href="<%=currentUrl + "add"%>" class="btn btn-primary">Adicionar</a>
			<a href="<%=back%>" class="btn btn-primary">Voltar</a>
		</div>
		
		<div class="row">
			<table class="table table-striped">
				<thead>
					<tr>
						<% for(ColumnMetadata field : fields.values()) { %>
						
							<th><%=field.getTitle()%></th>
						
						<% } %>
					</tr>
				</thead>
				<tbody>
					
				<% if(list != null) { %>
					<% for (AbstractBusiness negocio: list){ %>
						<tr>
							<%for(String field: fields.keySet() ) { %>
								<td>
									<%= negocio.getFieldValue(field) == null ? "" :  negocio.getFieldValue(field)%>
								</td>
							<% } %>
							
							<td> <button id="<%=negocio.getId()%>" class="btn btn-danger btn-xs delete">X</button> </td>
							
						</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>
		</div>

	</div>
	
	
</body>
</html>