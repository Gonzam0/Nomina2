<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Empleado</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	text-align: center;
}

h1 {
	margin: 20px 0;
}

table {
	border-collapse: collapse;
	width: 80%;
	margin: 20px auto;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #333;
	color: #fff;
}

a {
	text-decoration: none;
	color: #0078d4;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}

/* Estilo para el botón */
.volver-boton {
	background-color: #3498db; /* Color de fondo */
	color: #fff; /* Color del texto */
	padding: 10px 20px; /* Relleno interior del botón */
	border: none; /* Borde del botón */
	border-radius: 5px; /* Bordes redondeados */
	cursor: pointer; /* Cambiar el cursor al pasar por encima */
}

/* Estilo para cambiar el cursor al pasar por encima del enlace */
.volver-boton:hover {
	background-color: #1e87d5;
	/* Cambiar el color de fondo al pasar por encima */
}

button {
	margin-bottom: 10px;
	margin-top: 10px;
}

body {
	text-align: center;
	background-color: #f0f0f0;
	font-family: Arial, sans-serif;
}

table {
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	border: 1px solid #000;
	/* Añade un borde sólido alrededor de la tabla */
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	/* Añade una sombra suave a la tabla */
}

td {
	padding: 10px;
	text-decoration: none;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Crear Empleado</h1>
	
	<!-- Mensaje de éxito -->
    <c:if test="${not empty mensaje}">
        <p style="color: green;">${mensaje}</p>
    </c:if>

	<form action="ControladorEmpleados" method="post">
		<input type="hidden" name="opcion" value="guardarEmp">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" size="50"></td>
			</tr>
			<tr>
				<td>Dni:</td>
				<td><input type="text" name="dni" size="50"></td>
			</tr>
			<tr>
				<td>Sexo:</td>
				<td><input type="text" name="sexo" size="50"></td>
			</tr>
			<tr>
				<td>Categoria:</td>
				<td><input type="text" name="categoria" size="50"></td>
			</tr>
			<tr>
				<td>Años:</td>
				<td><input type="text" name="anyos" size="50"></td>
			</tr>
		</table>
		<button type="submit" class="volver-boton" value="Guardar">Guardar Cambios</button>
	</form>

	<form action="index.jsp">
		<button type="submit" class="volver-boton">Volver a la página de inicio</button>
	</form>
</body>
</html>