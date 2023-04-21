<%@ page import="ma.mtm.classes.Filiere" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 21277
  Date: 4/5/2023
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="std.css" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"
    />
    <title>Filiere</title>
</head>
<body>
<nav>
    <a href="index.jsp">ENSA</a>
    <ul>
        <li><a href="Student">Students</a></li>
        <li><a href="Filiere">Filiere</a></li>
        <li><a href="https://github.com/Mohamed-Marsou">Creator</a></li>
    </ul>
</nav>
<div class="overLay hidden"></div>
<div class="addNewContainer hidden">
    <p>Add new Filiere</p>
    <form action="#" style="justify-content: center; height: 40%">
        <input type="text" name="Filiere" placeholder="Nom Filiere" />
        <button type="submit">submit</button>
    </form>
</div>
<h1 id="Header">Filiere</h1>
<div class="container">
    <h4 id="addNew"><a href="#">Add new Filiere</a></h4>
    <table class="table table-striped-columns table-hover">
        <thead>
        <tr>
            <th scope="col">Filiere</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <%List<Filiere>fils = (List<Filiere>)request.getAttribute("fils"); %>
        <%for(Filiere fil : fils){%>
        <tr>
            <td><%=fil.getNomFil() %></td>
            <td>
                <a href="${pageContext.request.contextPath}/EditFil/Edit/<%=fil.getIdFil()%>">
                    <span class="material-symbols-outlined"> edit_note </span>
                    Edit</a
                >
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/DeleteStdServlet/<%=fil.getIdFil()%>" onclick="return confirm('Are you sure you want to delete this student?')">
                    <span class="material-symbols-outlined"> delete_sweep </span>
                    Delete</a
                >
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
        crossorigin="anonymous"
></script>
<script src="./std.js" defer></script>
</body>
</html>