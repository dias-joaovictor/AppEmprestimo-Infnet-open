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

	<div class="container">
		
		<div class="row">
			<h4><%=request.getSession().getAttribute("logged") %></h4>
			
			<hr>
			
			<h3>AppFinanceiro</h3>
		</div>
		
		<div class="row">
		
<%-- 			<a href="<%=request.getContextPath()%>/contas/" class="btn btn-default col-md-6 col-sm-6 col-xs-6">CONTAS</a> --%>
			
			<a href="<%=request.getContextPath()%>/contas/" class="btn btn-default col-md-6 col-sm-6 col-xs-6" >CONTAS</a>

			<a href="<%=request.getContextPath()%>/favorecidos/" class="btn btn-default col-md-6 col-sm-6 col-xs-6">FAVORECIDOS</a>
		
		</div>


		<div class="row">
		
			
			<a href="<%=request.getContextPath()%>/penhores/" class="btn btn-default col-md-4 col-sm-4 col-xs-4">PENHORES</a>
			
			<a href="<%=request.getContextPath()%>/pessoais/" class="btn btn-default col-md-4 col-sm-4 col-xs-4">PESSOAIS</a>
			
			<a href="<%=request.getContextPath()%>/refinanciamentos_imoveis/" class="btn btn-default col-md-4 col-sm-4 col-xs-4">REFINANCIANAMENTO DE IMÓVEIS</a>
		
		</div>
		
	</div>

</body>
</html>
