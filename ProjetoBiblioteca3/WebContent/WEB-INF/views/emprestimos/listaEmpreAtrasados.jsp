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
	
	<h1>Empretimos em Atraso</h1>


	<table border="2">

		<thead>
			<tr>
				<th>Aluno</th>
				<th>Livro</th>
				<th>Data de empr�stimo</th>
			</tr>

		</thead>

		<tbody>
			<c:forEach var="emprestimo" items="${emprestimos}">
				<tr>
					<td>${emprestimo.aluno.nome }</td>
					<td>${emprestimo.livro.titulo }</td>
					<td>${emprestimo.dataEmprestimo.time }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>