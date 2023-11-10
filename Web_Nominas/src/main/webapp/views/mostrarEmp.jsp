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
    <h1>Mostrar Empleados</h1>

    <!-- Tabla para mostrar la información de los empleados -->
    <table>
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años Trabajados</th>
        </tr>

        <!-- Usamos JSTL forEach para iterar sobre la lista de empleados -->
        <c:if test="${not empty empleados}">
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td><c:out value="${empleado.nombre}"></c:out></td>
                <!-- Muestra el nombre del empleado -->
                <td><c:out value="${empleado.dni}"></c:out></td>
                <!-- Muestra el DNI del empleado -->
                <td><c:out value="${empleado.sexo}"></c:out></td>
                <!-- Muestra el sexo del empleado -->
                <td><c:out value="${empleado.categoria}"></c:out></td>
                <!-- Muestra la categoría laboral del empleado -->
                <td><c:out value="${empleado.anyos}"></c:out></td>
                <!-- Muestra los años trabajados del empleado -->
            </tr>
        </c:forEach>
        </c:if>
    </table>

    <!-- Formulario para volver a la página de inicio -->
    <form action="index.jsp">
        <button type="submit" class="volver-boton">Volver a la página de inicio</button>
    </form>
</body>

</html>
