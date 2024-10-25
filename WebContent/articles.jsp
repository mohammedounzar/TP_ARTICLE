<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
<%@include file="header.jsp" %>
	<form method="GET" action="chercher.do">
		<label>Mot Clé</label> <input type="text" name="motCle"
			value="${model.motCle}" />
		<button type="submit" class="btn btn-primary">Chercher</button>
	</form>
	<hr>
	<h2>Les articles disponibles</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>Titre</th>
			<th>Contenu</th>
		</tr>
		<c:forEach items="${model.articles}" var="a">
			<tr>
				<td>${a.id}</td>
				<td>${a.titre}</td>
				<td>${a.contenu}</td>
				<td><a onClick="return confirm('Etes-vous sure?')"
					href="Supprimer.do?id=${a.id}">Supprimer</a></td>
				<td><a href="Edit.do?id=${a.id}">Mettre à jour</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>