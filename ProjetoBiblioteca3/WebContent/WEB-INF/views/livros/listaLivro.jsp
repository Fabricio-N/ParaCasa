<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de livros:</h1>

	<table border="2">
		<thead>
			<tr>
				<th>Titulo</th>
				<th>Autor</th>
				<th>Editora</th>
				<th>Ano de edi��o</th>
				<th>Ano de publica��o</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="livro" items="${livros }">
				<tr>
					<td>${livro.titulo }</td>
					<td>${livro.autor }</td>
					<td>${livro.editora }</td>
					<td>${livro.anoEdicao }</td>
					<td>${livro.anoPublicacao }</td>
					<td><a
						href="/ProjetoBiblioteca3/livros/remover?id=${livro.id}">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>