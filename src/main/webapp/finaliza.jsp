<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AppFinanceiro</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String titulo = (String) request.getAttribute("titulo");
		String mensagem = (String) request.getAttribute("mensagem");
		String controller = (String) request.getAttribute("controller");
	%>

	<div class="container">
<h2><%=controller%></h2>
		<form action="<%=controller%>" method="get">

			<div class="container">
				<h2><%=titulo%></h2>
				<div class="alert alert-success">
					<strong>Sucesso!</strong>
					<%=mensagem%>
				</div>

				<button type="submit" class="btn btn-default" name="tela"
					value="<%=titulo%>">Voltar</button>
			</div>

		</form>
	</div>

</body>
</html>