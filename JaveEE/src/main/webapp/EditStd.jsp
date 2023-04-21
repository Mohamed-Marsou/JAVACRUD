<%@ page import="ma.mtm.classes.Student" %>
<%@ page import="ma.mtm.classes.Filiere" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 21277
  Date: 4/21/2023
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Student Information Form</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css" integrity="sha512-4Lg8hrlpzNjJF91O+XlW2dOLNsJaTjV7QYJssHEuB7vmFe97t1u3qzf/iXtPnZt/Fs4RV+4g4C4M/cNTvByeJw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
    body {
      background-color: #F0F2F5;
      font-family: Arial, sans-serif;
    }

    .form-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .form-box {
      width: 400px;
      background-color: #FFFFFF;
      border-radius: 5px;
      box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
      padding: 30px;
    }

    .form-box h2 {
      margin-top: 0;
      margin-bottom: 20px;
      font-size: 24px;
      font-weight: bold;
      text-align: center;
    }

    .form-group label {
      font-weight: bold;
    }

    .form-group input,
    .form-group select {
      border-radius: 0;
      border-color: #CCCCCC;
    }

    .form-group input:focus,
    .form-group select:focus {
      box-shadow: none;
      border-color: #3E82F7;
    }

    .btn-primary {
      background-color: #3E82F7;
      border-color: #3E82F7;
    }

    .btn-primary:hover {
      background-color: #2964C9;
      border-color: #2964C9;
    }

    .btn-primary:focus {
      box-shadow: none;
    }
  </style>
</head>
<body>
<%Student std = (Student) request.getAttribute("std");%>
<%List<Filiere>fils = (List<Filiere>)request.getAttribute("fils"); %>
<div class="form-container">
  <div class="form-box">
    <h2>Edit Student</h2>
    <form method="post" action="${pageContext.request.contextPath}/EditStd/Edit/<%=std.getIdEtu()%>">
      <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" class="form-control" id="nom" value="<%=std.getNom()%>" name="nom">
      </div>
      <div class="form-group">
        <label for="prenom">Prenom:</label>
        <input type="text" class="form-control" id="prenom" value="<%=std.getPrenom()%>"name="prenom">
      </div>
      <div class="form-group">
        <label for="sexe">Sexe:</label>
        <select class="form-control" id="sexe" name="sexe">
          <option ><%=std.getSexe()%></option>
          <option ><%=std.getSexe().equals("FEMALE") ? "MALE":"FEMALE"%></option>
        </select>
      </div>
      <div class="form-group">
        <label for="Fil">Filiere :</label>
        <select class="form-control" id="Fil" name="Fil">
          <option><%=std.getFiliere()%></option>
          <% for (Filiere fil : fils) { %>
          <% if (!fil.getNomFil().equals(std.getFiliere())) { %>
          <option><%=fil.getNomFil()%></option>
          <% }  %>
          <% }  %>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="${pageContext.request.contextPath}/Student">>>>go back </a>
  </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/js/bootstrap.bundle.min.js" integrity="sha512-T0c0GoeRg9NNxDWYEPUDuvvEaHWLwSwq3HyNK5E5G5vFv31xMSxQ9UM1yhrY8yv+TNLgJpKzryL1CZ0T6J8ag==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>

