<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    background-color: #4CAF50;
    color: white;
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
    align-items: center;
}
</style>
<body>
<c:import url="../menu.jsp"></c:import>

<h3>Adicionar Aluno</h3>

<div>
  <form action="/ProjetoBiblioteca3/livros">
    <label for="fname">Nome</label>
    <input type="text" id="fname" name="nome" >

    <label for="lname">Matricula</label>
    <input type="text" id="lname" name="matricula" >
    
    <label for="lname">CPF</label>
    <input type="text" id="lname" name="cpf" >
    
    <label for="lname">Endereço</label>
    <input type="text" id="lname" name="endereco" >
    
    <label for="lname">Data de Nascimento</label>
    <input type="text" id="lname" name="dataNascimento" >

   
  
  
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>