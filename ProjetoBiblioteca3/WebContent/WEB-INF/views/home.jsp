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

h1 {
	text-shadow: 0 0 0.5em #00FFFF;
	text-align: center;
	color: white;
 }

div {
    width: 500px;
    height: 50px;
    background-color: #20B2AA;
    font-weight: bold;
    position: relative;
    -webkit-animation: mymove 8s infinite;
    animation: mymove 8s infinite;
    color: white;
   text-align: center;
   font-size: 50px;
}
#div1 {-webkit-animation-timing-function: Bem Vindo;}

@-webkit-keyframes mymove {
    from {left: 0px;}
    to {left: 800px;}
}

@keyframes mymove {
    from {left: 0px;}
    to {left: 800px;}
}

</style>
<body>
	<c:import url="menu.jsp"></c:import>
	<h1>Biblioteca Fabricio e Emanuelly</h1>
	<div id="div1">Bem Vindo</div>
</body>
</html>