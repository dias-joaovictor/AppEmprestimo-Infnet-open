<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="row">
			
			<h4>Login</h4>
			
		</div>
		
		<div class="row">
			<form action="<%=request.getContextPath()%>/auth" method="POST">
				<div class="form-group">
					<label for="email">Email</label>
					<input name="email" id="email" class="form-control" type="text"/>
				</div>
				
				<div class="form-group">
					<label for="password">Senha</label>
					<input name="password" id="password" class="form-control" type="password"/>
				</div>
				
				<button class="btn btn-primary" type="submit" >LOGIN</button>
			</form>
		</div>
		
	</div>
	
</body>
</html>