<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>Biblioteca</title>
</head>
<body>
	<div class="login-box">
        <div>
            <p>Iniciar Sessão</p>
        </div>
        <form id="loginSenha" class="login-input" name="login-form" method="post" action="ControleServlet">
            <span>E-mail:</span>
            <input type="text" name="email" placeholder="E-mail">
            <span>Password:</span>
			<input type="password" name="password" placeholder="Password">
			<input type="submit" name="comando" value="Logar" />	
		</form>        
	</div>
	<button>
		<a href="http://localhost:8080/Biblioteca/cadastro.jsp">Cadastre-se</a>
	</button>
</body>
</html>