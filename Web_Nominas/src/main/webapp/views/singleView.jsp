<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa</title>
</head>
<body>
	 <!-- Incluir el encabezado -->
    <%@include file="/views/header.jsp" %>
    
   <c:choose>
        <c:when test="${empty content}">
            <%@ include file="/index.jsp" %>
        </c:when>
        <c:otherwise>
            <jsp:include page="${content}" />
        </c:otherwise>
    </c:choose>
    
    <!-- Incluir el pie de página -->
    <%@include file="/views/footer.jsp" %>
</body>
</html>