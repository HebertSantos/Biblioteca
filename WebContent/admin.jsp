<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" 
                       integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" 
                       crossorigin="anonymous">
<title>Game Store</title>
</head>
<body>
	<h1>Dashboard</h1>
	<h2>Bem vindo(a), ${ user.nome }</h2>
	<form method="post" action="ControleServlet">
		<!-- TO-DO CSS Customizado -->
		<span>Nome do Livro:</span>
		<input type="text" name="nomeLivro" placeholder="Nome do Livro" />
		<br>
		<span>Edição:</span>
		<input type="text" name="edicao" placeholder="Edicao" />
		<br>
		<span>Genero:</span>
		<input type="text" name="genero" placeholder="Genero" />		
		<input type="hidden" name="comando" value="CadastrarLivro" />
		<input type="submit" value="Cadastrar" />		
	</form>
	
	<h1>Lista de Livros Disponiveis</h1>
	<table border=1>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>Edicao</td>
			<td>Genero</td>
		</tr>
		<c:forEach var="livro" items="${listaLivros}">
		<tr>
			<td>${livro.id}</td>
			<td>${livro.nomeLivro}</td>
			<td>${livro.edicao}</td>
			<td>${livro.genero}</td>
			<td>
				<a href="http://localhost:8080/Biblioteca/login.jsp"><i class="far fa-edit" style="color:lightblue;text-shadow:2px 2px 4px"></i></a>
			</td>			
		</tr>
		</c:forEach>
	</table>
</body>
</html>