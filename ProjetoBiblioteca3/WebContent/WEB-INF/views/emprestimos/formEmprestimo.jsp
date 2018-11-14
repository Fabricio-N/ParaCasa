<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #33cc33;
    color: green;
    padding: 15px 10px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 1px;
    background-color: #f2f2f2;
    padding: 20px;
    width: 290px;
    margin: auto;
}

h1 {
	text-align: center;
	color: #ccffff;
	
}
h1 {text-shadow: 0 0 0.2em #000000}
</style>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Adicionar Emprestimo</h1>
	<div>
	<form action="/ProjetoBiblioteca3/emprestimos" method="post">
		<h2>
			Alunos <select name="aluno.id">
				<c:forEach var="aluno" items="${alunos }">
					<option value="${aluno.id }">${aluno.nome }</option>
				</c:forEach>
			</select>
		</h2>

		<h2>
			Livros <select name="livro.id">
				<c:forEach var="livro" items="${livros }">
					<option value="${livro.id }">${livro.titulo }</option>
				</c:forEach>
			</select>
		</h2>
		<button type="submit">Adicionar</button>
	</form>
	</div>
</body>
</html>
