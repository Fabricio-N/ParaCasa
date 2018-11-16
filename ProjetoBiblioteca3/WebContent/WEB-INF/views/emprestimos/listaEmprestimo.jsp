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

	<h1>Lista de Emprestimos:</h1>

	<table border="10" align="center">
		<thead>
			<tr>
				<th>Nome do aluno</th>
				<th>Nome do Livro</th>
				<th>Data de empr�stimo</th>
				<th>Data de Devolu��o
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos }">
				<tr>
					<td>${emprestimo.aluno.nome }</td>
					<td>${emprestimo.livro.titulo }</td>
					<td><fmt:formatDate value="${emprestimo.dataEmprestimo.time}" pattern="dd/MM/yyyy" /></td>
					<td><fmt:formatDate value="${emprestimo.dataDevolucao.time}" pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>