<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa</title>
<style>
  body {
    text-align: center;
    background-color: #f0f0f0;
    font-family: Arial, sans-serif;
  }

  h1 {
    margin-top: 20px;
  }

  table {
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    border: solid black;
  }

  td {
    padding: 10px;
  }

  a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
  }

  a:hover {
    color: #0078d4;
  }
</style>
</head>
<body>
	 <!-- Incluir el encabezado -->
    <jsp:include page="/views/header.jsp" />
    
  <div>
        <h1>Menú de opciones de Nóminas</h1>
        <table style="margin: 0 auto;">
            <tr>
                <td><a href="ControladorEmpleados?opcion=crearEmp"> Crear Empleado </a></td>
            </tr>
            <tr>
                <td><a href="ControladorEmpleados?opcion=mostrarEmp"> Mostrar los Empleados </a></td>
            </tr>
            <tr>
                <td><a href="ControladorEmpleados?opcion=editarEmp"> Editar un Empleado </a></td>
            </tr>
            <tr>
                <td><a href="ControladorEmpleados?opcion=mostrarNom"> Mostrar Nóminas </a></td>
            </tr>
        </table>
    </div>
  
   <!-- Incluir el pie de página -->
    <jsp:include page="/views/footer.jsp" />
</body>
</html>
