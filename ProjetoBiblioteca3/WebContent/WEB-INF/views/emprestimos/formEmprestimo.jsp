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
	<form action="/ProjetoBiblioteca3/emprestimos" method="post">
		
		Nome do aluno: <input type="text" name="aluno">
		
		Nome do Livro: <input type="text" name="livro">
		
		Data do emprestimo: <input type="text" name="dataEmprestimo">
		
		Data da devolução: <input type="text" name="dataDevolucao">
		
		<button type="submit">Adicionar</button>
		
	</form>
</body>
</html>