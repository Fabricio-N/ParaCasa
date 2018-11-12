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
label {
	color: DeepPink;
}
form {
	text-align: center;
}
h1 {
	text-shadow: 0 0 0.5em #00FFFF;
	text-align: center;
	color: white;
	
}
</style>
<body>
	<c:import url="../menu.jsp"></c:import>
	<h1>Adicionar Livro</h1>
	<form action="/ProjetoBiblioteca3/livros" method="post">
		<div>
			<label>
				Título: <input type="text" name="titulo">
		
				Autor: <input type="text" name="autor">
		
				Editora: <input type="text" name="editora">
		
				Ano de Edição: <input type="text" name="anoEdicao">
		
				Ano de publicação: <input type="text" name="anoPublicacao">
		
				<button type="submit">Adicionar</button>
			</label>	
		</div>		
	</form>	
</body>
</html>