<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Gestion Produits</title>
</head>

<body>

<h1>Gestion des Produits</h1>

<!-- FORM ADD / UPDATE -->
<form action="${produitEdit != null ? 'updateProduit' : 'addProduct'}" method="post">

    <input type="hidden" name="idProduit" value="${produitEdit.idProduit}" />

    Nom: <input type="text" name="nom" value="${produitEdit.nom}" /><br/>
    Description: <input type="text" name="description" value="${produitEdit.description}" /><br/>
    Prix: <input type="text" name="prix" value="${produitEdit.prix}" /><br/>

    <input type="submit" value="${produitEdit != null ? 'Modifier' : 'Ajouter'}"/>

</form>

<hr/>

<!-- TABLE -->
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Description</th>
        <th>Prix</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${listeProduit}" var="p">
        <tr>
            <td>${p.idProduit}</td>
            <td>${p.nom}</td>
            <td>${p.description}</td>
            <td>${p.prix}</td>
            <td>
                <a href="deleteProduit?id=${p.idProduit}">Delete</a>
                <a href="editProduit?id=${p.idProduit}">Edit</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>