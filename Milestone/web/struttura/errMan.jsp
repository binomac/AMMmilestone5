<%-- 
    Document   : errMan
    Created on : 16-giu-2016, 19.50.00
    Author     : luca
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="errore" items="${ListaErrori}">
        <json:object>
            <json:property name="titolo" value="${errore.header}"/>
            <json:property name="tipo" value="${errore.errorType}"/>
            <json:property name="codice" value="${errore.errorCode}"/>
            <json:property name="descrizione" value="${errore.description}"/>
        </json:object>
    </c:forEach>
</json:array>