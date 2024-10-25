<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
<%@include file="header.jsp" %>
			<h1 class="panel-heading">Confirmation</h1>
			<label>ID:</label>
			<label>${article.id}</label><br>

			<label>Titre:</label>
			<label>${article.titre}</label><br>

			<label>Contenu:</label>
			<label>${article.contenu}</label><br>
</body>
</html>