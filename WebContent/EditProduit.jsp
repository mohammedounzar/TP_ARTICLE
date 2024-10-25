<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>Mise à jour d'un article</h1>
				<form action="UpdateArticle.do" method="POST">
				<label class="control-label">ID</label>
				<input type="text" name="id" class="form-control" value="${article.id}" required/><br>
				<span></span>

				<label class="control-label">Titre</label>
				<input type="text" name="titre" value="${article.titre}" required/><br>
				<span></span>

				<label class="control-label">Contenu</label>
				<input type="text" name="contenu" class="form-control" value="${article.contenu}" required/><br>
				<span></span>

				<button type="submit">Mettre à jour</button>
				</form>

</body>
</html>