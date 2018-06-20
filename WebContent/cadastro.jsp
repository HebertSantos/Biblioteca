<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="css/cadastro-usuario.css">
<title>Game Store</title>
</head>
<body>
	${mensagemErro}
	<div class="informacoes-box">
        <div>
            <p>Novo Usuario</p>
        </div>
        <form method="post" action="ControleServlet" id="informacoes-usuario" class="cadastro-usuario-form">
            <span>Nome:</span>
			<input type="text" name="nome" placeholder="Nome" />
			<br>
			<span>E-mail:</span>
			<input type="text" name="email" placeholder="E-mail" />
			<br>
			<span>Password:</span>
			<input type="password" name="password" placeholder="Password" />
			<br>
			<span>Digite o password novamente:</span>
			<input type="password" name="password2" placeholder="Digite a senha novamente" />
			<br>		
			<input type="hidden" name="comando" value="CadastrarUsuario" />
			<input type="submit" value="Cadastrar" />
		</form>
        <div>
            <span>
                <a href="http://localhost:8080/GameStore/login.jsp">Voltar para o Login</a>                
            </span>
        </div>
    </div>
	
</body>
</html>