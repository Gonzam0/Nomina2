<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar Nómina</title>
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
    <h1>Mostrar Nómina</h1>
    
     <!-- Mensaje de error -->
    <c:if test="${not empty errorMensaje}">
        <p style="color: red;">${errorMensaje}</p>
    </c:if>

    <!-- Formulario para buscar el salario de un empleado -->
    <form action="ControladorEmpleados" method="post">
        <label for="dni">DNI del Empleado:</label>
        <input type="text" id="dni" name="dni" required>
        
        <!-- Campo oculto para indicar la opción "mostrarNom" al servidor -->
        <input type="hidden" name="opcion" value="mostrarNom">
        
        <!-- Botón para enviar el formulario y buscar el salario -->
        <button type="submit">Buscar Salario</button>
    </form>

    <!-- Tabla para mostrar la información del salario de los empleados -->
    <table border="1">
        <tr>
            <td>DNI</td>
            <td>Sueldo</td>
        </tr>

        <!-- Usamos JSTL forEach para iterar sobre la lista de empleados -->
        <c:forEach var="empleado" items="${empleados}">
            <tr>
                <td>
                    <a
                        href="productos?opcion=mostrarNom&dni=<c:out value="${empleado.dni}"></c:out>">
                        <!-- El enlace con un parámetro "dni" para mostrar el salario -->
                    </a>
                    <c:out value="${empleado.dni}"></c:out>
                    <!-- Muestra el DNI del empleado -->
                </td>
                <td><c:out value="${empleado.sueldo}"></c:out></td>
                <!-- Muestra el sueldo del empleado -->
            </tr>
        </c:forEach>
    </table>

    <!-- Formulario para volver a la página de inicio -->
    <form action="index.jsp">
        <button type="submit" class="volver-boton">Volver a la página de inicio</button>
    </form>
</body>

</html>