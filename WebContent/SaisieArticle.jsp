<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Un Article</title>
</head>
<body>
<%@include file="header.jsp" %>
	<form method="POST" action="SaveArticle.do">
		<table>
			<tr>
				<td>Titre :</td>
				<td><input type="text" name="titre" /></td>
			</tr>
			<tr>
				<td>Contenu :</td>
				<td><input type="text" name="contenu" /></td>
			</tr>
			<tr>
				<td><button type="submit">Ajouter</button></td>
			</tr>
		</table>
	</form>
</body>
</html>