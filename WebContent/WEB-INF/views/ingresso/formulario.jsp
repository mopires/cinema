<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
<br />
	
	Compra ingresso <br /><br />
	
				<form action="adicionaIngresso" method="post">
							
	<label for="Preco">Preco</label>  
	<input type="text" name="preco" value="${ingresso.preco}" ><br />
	<label for="Usuario">Usuario</label>  
	<input type="text" name="id_ingresso_usuario" value="${ingresso.id_ingresso_usuario}" ><br />
	<label for="Filme">Filme</label>  
	<input type="text" name="id_ingresso_filme" value="${ingresso.id_ingresso_filme}" ><br />
				<input type="submit" value="Criar">
		
	</form>
</body>
</html>