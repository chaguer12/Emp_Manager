<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>EmpManager</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

<div class="container">
    <!-- Form Section -->
    <section id="add-form">
        <h1 class="title">Welcome back admin !</h1>
        <form action="/add-employee" method="POST" enctype="application/x-www-form-urlencoded">
            <label for="nom">Nom :</label><br>
            <input type="text" id="nom" name="nom" required><br><br>

            <label for="prenom">Prénom :</label><br>
            <input type="text" id="prenom" name="prenom" required><br><br>

            <label for="tel">Téléphone :</label><br>
            <input type="tel" id="tel" name="tel" required pattern="[0-9]{10}" placeholder="0612345678"><br><br>

            <label for="email">Email :</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="poste">Poste :</label><br>
            <input type="text" id="poste" name="poste" required><br><br>

            <label for="departement">Département :</label><br>
            <input type="text" id="departement" name="departement" required><br><br>

            <button type="submit">Ajouter l'employé</button>
        </form>
    </section>

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
                    <td>${employee.nom}</td>
                    <td>${employee.prenom}</td>
                    <td>${employee.tel}</td>
                    <td>${employee.email}</td>
                    <td>${employee.poste}</td>
                    <td>${employee.departement}</td>
                    <td><button onclick="deleteEmployee(${employee.id})">Supprimer</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>

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
