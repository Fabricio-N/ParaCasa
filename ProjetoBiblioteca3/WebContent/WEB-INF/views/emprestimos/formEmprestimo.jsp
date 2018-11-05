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
	<h1>Adicionar Emprestimo</h1>


	<select name="aluno.id">
		<c:forEach var="aluno" items="${alunos }">
			<option value="${aluno.id }">${aluno.nome }</option>
		</c:forEach>
	</select>

	<button type="submit">Adicionar</button>


</body>
</html>