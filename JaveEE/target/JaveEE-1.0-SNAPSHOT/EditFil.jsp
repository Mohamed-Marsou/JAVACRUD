<%@ page import="ma.mtm.classes.Filiere" %>
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
<%Filiere fil = (Filiere) request.getAttribute("fil");%>
<div class="form-container">
  <div class="form-box">
    <h2>Edit Student</h2>
    <form method="post" action="${pageContext.request.contextPath}/EditFil/Edit/<%=fil.getIdFil()%>">
      <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" class="form-control" id="nom" value="<%=fil.getNomFil()%>" name="nom">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <a href="${pageContext.request.contextPath}/Filiere">>>>go back </a>
  </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/js/bootstrap.bundle.min.js" integrity="sha512-T0c0GoeRg9NNxDWYEPUDuvvEaHWLwSwq3HyNK5E5G5vFv31xMSxQ9UM1yhrY8yv+TNLgJpKzryL1CZ0T6J8ag==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>

