<%@ page language="java"
	import="dw2.gamestore.modelo.Usuario"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="css/listalivros.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" 
                       integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" 
                       crossorigin="anonymous">
<title>Biblioteca Online</title>
</head>
<body>
		
	<h1>Bem vindo(a), ${ user.nome }</h1>	
	<h1>Lista de Livros</h1>
	<button>
		<i class="fas fa-shopping-cart"></i>
		<a href="#">Ver Livros Disponiveis</a>
	</button>	
	<c:forEach var="livro" items="${listaLivros}">
	<div class="listaLivros" id="listaLivros">
        <img src="images/livro.png" alt="" class="imagem">
        <ul>
            <li class="texto-label" id="livrosDisponiveis">Nome Livro:
                <span class="text-desc !important"name="nomeLivro">${livro.tituloLivro}</span>
            </li>
            <li class="texto-label" name="edicao" id="edicaoLivro">
                    <span name="edicao">R$: ${livro.edicao}</span>
            </li>
            <li class="texto-label" name="genero" id="generoLivro">
                <span name="genero">${livro.genero}</span>
            </li>
        </ul>
        <c:choose>
			<c:when test="${User.isUserPossuiLivro(produto.id, listaLivrosUsuarios)}">
      				Livro Adiquirido	
  				</c:when>    
		    <c:otherwise>
		        <button class="green-button" name="comprarJogo">
		        	<a href=ControleServlet?comando=EmprestarLivros&idLivro=${livro.id}>Emprestar<i class="fas fa-money-bill-alt"></i></a>
		        </button>
		        <button class="green-button" name="addJogo">
					<a href=ControleServlet?comando=CarrinhoDeLivros&idLivro=${livro.id}>Adicionar ao Conjunto Emprestado<i class="fas fa-cart-plus"></i></a>
				</button>
		    </c:otherwise>								
		</c:choose>        
    </div>
    </c:forEach>
</body>
</html>