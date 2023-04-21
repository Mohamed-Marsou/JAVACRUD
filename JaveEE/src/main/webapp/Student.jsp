<%@ page import="java.util.List" %>
<%@ page import="ma.mtm.classes.Student" %>
<%@ page import="ma.mtm.classes.Filiere" %><%--
  Created by IntelliJ IDEA.
  User: 21277
  Date: 4/5/2023
  Time: 4:09 PM
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
    <script src="./std.js" defer></script>
    <title>Students</title>
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
<%List<Filiere>fils = (List<Filiere>)request.getAttribute("fils"); %>

<div class="overLay hidden"></div>
<div class="addNewContainer hidden">
    <p>Add new Student</p>
    <form action="${pageContext.request.contextPath}/Student" method="post">
        <input type="text" name="fname" placeholder="First name" />
        <input type="text" name="lname" placeholder="Last name" />
        <select name="sex" id="sex">
            <option>Male</option>
            <option>Female</option>
        </select>
        <select name="fil" id="fil">
            <%for(Filiere fil : fils){%>
            <option><%=fil.getNomFil()%></option>
            <%}%>
        </select>
        <button type="submit">submit</button>
    </form>
</div>
<h1 id="Header">Students</h1>
<div class="container">
    <%List<Student> stds = (List<Student>)request.getAttribute("stds") ;%>
    <h4 id="addNew"><a href="#">Add new Student</a></h4>
    <table class="table table-striped-columns table-hover">
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prénom</th>
            <th scope="col">sexe</th>
            <th scope="col">Filiere</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <%for(Student std : stds){%>
        <tr>
            <td><%=std.getNom()%></td>
            <td><%=std.getPrenom()%></td>
            <td><%=std.getSexe()%></td>
            <td><%=std.getFiliere()%></td>
            <td>
                <a href="${pageContext.request.contextPath}/EditStd/Edit/<%=std.getIdEtu()%>">
                    <span class="material-symbols-outlined"> edit_note </span>
                    Edit</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/DeleteStdServlet/<%=std.getIdEtu()%>" onclick="return confirm('Are you sure you want to delete this student?')">
                    <span class="material-symbols-outlined"> delete_sweep </span>
                    Delete</a>
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
</body>
</html>

