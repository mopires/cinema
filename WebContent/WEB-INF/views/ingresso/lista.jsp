<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema Cadastro</title>
</head>
<body>
<c:import url="/WEB-INF/views/principal/menu.jsp"/>
	<br />
	<a href="novoIngresso">Comprar Ingresso</a>
	<br />
	<br />
	<table>
		<tr>
			<th>Id</th>
			<th>Preço</th>
			<th>Usuario</th>
			<th>Filme</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${ingressos}" var="ingresso">
			<tr>
				<td>${ingresso.id}</td>
				<td>${ingresso.preco}</td>
				<td>${ingresso.id_ingresso_usuario}</td>
				<td>${ingresso.id_ingresso_filme}</td>
				<td><a href="mostraIngresso?id=${ingresso.id}" title="Editar">Editar</a></td>
				<td><a href="removeIngresso?id=${ingresso.id}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>