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

	<h1>Lista de Emprestimos:</h1>

	<table border="2">
		<thead>
			<tr>
				<th>Nome do aluno</th>
				<th>Nome do Livro</th>
				<th>Data de empréstimo</th>
				<th>Data de devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos }">
				<tr>
					<td>${emprestimo.aluno.nome }</td>
					<td>${emprestimo.livro.titulo }</td>
					<td>${emprestimo.dataEmprestimo.time }</td>
					<td>${emprestimo.dataDevolucao.time }</td>
					<td><a href="/ProjetoBiblioteca3/emprestimos/remover?id=${emprestimo.id}">Remover</a></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>