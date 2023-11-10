<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>
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
</style>
</head>
<body>
	<!-- Encabezado de la página -->
	<h1>Editar Empleados</h1>

	<!-- Mensaje de error -->
<c:if test="${not empty errorMensaje}">
    <p style="color: red;">${errorMensaje}</p>
</c:if>


	<!-- Formulario para filtrar por DNI -->
	<form action="ControladorEmpleados" method="post">
		<label for="dni">DNI del Empleado:</label> <input type="text" id="dni"
			name="dni" required> <input type="hidden" name="opcion"
			value="filtrarPorDni">
		<button type="submit" class="volver-boton">Buscar Empleado
			por DNI</button>
	</form>


	<!-- Tabla para mostrar la información de los empleados -->
	<table>
		<tr>
			<!-- Encabezados de la tabla -->
			<th>DNI</th>
			<th>Nombre</th>
			<th>Sexo</th>
			<th>Categoría</th>
			<th>Años Trabajados</th>
			<th>Modificar</th>
		</tr>
		<!-- Utiliza un bucle forEach para iterar a través de los empleados proporcionados por el objeto "empleados" -->
		<c:forEach var="empleado" items="${empleados}" varStatus="status">
			<!-- Comprueba si el nombre y el DNI del empleado coinciden con los valores filtrados -->
			<c:if test="${empty param.nombre or empleado.nombre eq param.nombre}">
				<c:if test="${empty param.dni or empleado.dni eq param.dni}">
					<tr>
						<!-- Cada empleado se muestra en una fila de la tabla -->
						<td><c:out value="${empleado.dni}"></c:out></td>
						<!-- Muestra el DNI del empleado -->
						<td><c:out value="${empleado.nombre}"></c:out></td>
						<!-- Muestra el nombre del empleado -->
						<td><c:out value="${empleado.sexo}"></c:out></td>
						<!-- Muestra el sexo del empleado -->
						<td><c:out value="${empleado.categoria}"></c:out></td>
						<!-- Muestra la categoría laboral del empleado -->
						<td><c:out value="${empleado.anyos}"></c:out></td>
						<!-- Muestra los años trabajados del empleado -->
						<td><a href="views/editar.jsp?dni=${empleado.dni}">Editar</a></td>
						<!-- Proporciona un enlace para editar este empleado -->
					</tr>
				</c:if>
			</c:if>
		</c:forEach>

	</table>

	<!-- Formulario para volver a la página de inicio -->
	<form action="index.jsp">
		<button type="submit" class="volver-boton">Volver a la página
			de inicio</button>
	</form>
</body>
</html>