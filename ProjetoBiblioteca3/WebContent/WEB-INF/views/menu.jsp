<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

body {
	margin: 0px;
	background-image:
		url("http://xdesktopwallpapers.com/wp-content/uploads/2012/07/Red%20Digital%20Layers.jpg?type=download");
	background-repeat: no-repeat;
	background-size: 1600px 800px;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: LightCoral;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 140px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>

<ul>

<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Home</a>
		<div class="dropdown-content">
			<a href="/ProjetoBiblioteca3/">Home</a> 
		</div></li>

	

	<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Aluno</a>
		<div class="dropdown-content">
			<a href="/ProjetoBiblioteca3/alunos/form">Adicionar alunos</a> <a
				href="/ProjetoBiblioteca3/alunos/">Listar aluno</a>
		</div></li>


	<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Livro</a>
		<div class="dropdown-content">
			<a href="/ProjetoBiblioteca3/livros/form">Adicionar livro</a> <a
				href="/ProjetoBiblioteca3/livros">Listar livros</a>
		</div></li>

	<li class="dropdown"><a href="javascript:void(0)" class="dropbtn">Emprestimo</a>
		<div class="dropdown-content">
			<a href="/ProjetoBiblioteca3/emprestimos/form">Adicionar
				emprestimo</a> <a href="/ProjetoBiblioteca3/emprestimos">Listar
				Emprestimo</a> <a href="/ProjetoBiblioteca3/emprestimos/abertos">Emprestimos
				Abertos</a> <a href="/ProjetoBiblioteca3/emprestimos/atrasados">Emprestimos
				Atrasados</a>
		</div></li>
</ul>


</body>
</html>