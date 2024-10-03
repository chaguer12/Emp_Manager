<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<!-- Employee List Section -->
<section id="employee-list">
    <h2>Liste des employés</h2>
    <input type="text" id="search" placeholder="Rechercher un employé..."><br><br>

    <table>
        <thead>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Téléphone</th>
            <th>Email</th>
            <th>Poste</th>
            <th>Département</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody id="employee-table">

        <%-- Dynamic employee rows will be inserted here --%>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.getName()}</td>
                <td>${employee.getLastname()}</td>
                <td>${employee.getTel()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getPoste()}</td>
                <td>${employee.getDepartment()}</td>

                <td><button onclick="deleteEmployee(${employee.getId()})">Supprimer</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
<script>
    // Search functionality
    document.getElementById("search").addEventListener("input", function() {
        const searchTerm = this.value.toLowerCase();
        const rows = document.querySelectorAll("#employee-table tr");

        rows.forEach(row => {
            const nom = row.children[0].textContent.toLowerCase();
            const prenom = row.children[1].textContent.toLowerCase();
            row.style.display = nom.includes(searchTerm) || prenom.includes(searchTerm) ? '' : 'none';
        });
    });

    // Delete functionality
    function deleteEmployee(id) {
        if (confirm("Êtes-vous sûr de vouloir supprimer cet employé?")) {
            window.location.href = "/delete-employee?id=" + id;
        }
    }
</script>
</body>
</html>
