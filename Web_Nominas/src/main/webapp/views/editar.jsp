<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Empleado</title>
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
.volver-boton, .volver-atras {
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

div, button {
	margin-bottom: 10px;
}

</style>
</head>
<body>
    <!-- Encabezado de la página -->
    <h1>Editar Empleado</h1>

    <!-- Formulario para editar los detalles del empleado -->
    <form action="${pageContext.request.contextPath}/ControladorEmpleados" method="post">
    	<input type="hidden" name="dni" value="${param.dni}">
    	<input type="hidden" name="opcion" value="editar">
        <div>
            <label for="nombre">Nombre:</label> 
            <input type="text" id="nombre" name="nombre" value="${empleado.nombre}" required>
            <!-- Muestra el nombre del empleado y lo establece  -->
        </div>
        <div>
            <label for="sexo">Sexo:</label> 
            <input type="text" id="sexo" name="sexo" value="${empleado.sexo}" required>
            <!-- Muestra el sexo del empleado y lo establece -->
        </div>
        <div>
            <label for="categoria">Categoría:</label> 
            <input type="number" id="categoria" name="categoria" value="${empleado.categoria}" required>
            <!-- Muestra la categoría laboral del empleado y lo establece -->
        </div>
        <div>
            <label for="anyos">Años Trabajados:</label> 
            <input type="number" id="anyos" name="anyos" value="${empleado.anyos}" required>
            <!-- Muestra los años trabajados del empleado y lo establece -->
        </div>
        <button type="submit" class="volver-boton">Guardar Cambios</button>
        <!-- Proporciona un botón para guardar los cambios realizados en la edición del empleado -->
    </form>

    <!-- Formulario para volver a la página de inicio -->
    <form action="../index.jsp">
    	<input type="hidden" name="dni" value="${param.dni}">
        <button type="submit" class="volver-boton">Volver a la página de inicio</button>
    </form>
</body>

</html>