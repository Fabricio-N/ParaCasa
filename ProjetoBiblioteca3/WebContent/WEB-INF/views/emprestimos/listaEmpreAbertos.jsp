<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
tr {
	color: black;
	background-color: white;
}

h1 {
	color: black;
	background-color: white;
	text-align: center;
}
</style>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Emprestimos Abertos:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Livro</th>
				<th>Matrícula</th>
				<th>Data do emprestimo</th>
				<th>Devolução</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos}">
				<tr>
					<td>${emprestimo.livro.titulo}</td>
					<td>${emprestimo.aluno.matricula}</td>
					<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy" /></td>
					<td><a
						href="/ProjetoBiblioteca3/emprestimos/devolucao?id=${emprestimo.id}">devolver</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>