<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<section id="add-form">
<form action="${pageContext.request.contextPath}/update-emp" method="POST" enctype="application/x-www-form-urlencoded">
    <label for="nom">Nom :</label><br>
    <input type="text" value="${employee.getLastname()}" id="nom" name="nom" required><br><br>

    <label for="prenom">Prénom :</label><br>
    <input type="text" value="${employee.getName()}" id="prenom" name="prenom" required><br><br>

    <label for="tel">Téléphone :</label><br>
    <input type="tel" value="${employee.getTel()}" id="tel" name="tel" required pattern="[0-9]{10}" placeholder="0612345678"><br><br>

    <label for="email">Email :</label><br>
    <input type="email" value="${employee.getEmail()}" id="email" name="email" required><br><br>

    <label for="poste">Poste :</label><br>
    <input type="text" value="${employee.getPoste()}" id="poste" name="poste" required><br><br>

    <label for="departement">Département :</label><br>
    <input type="text" value="${employee.getDepartment()}" id="departement" name="departement" required><br><br>
    <input hidden value="${employee.getId()}" name="id">
    <input hidden name="_method" value="UPDATE">
    <button type="submit">Ajouter l'employé</button>
</form>
</section>

</body>
</html>
