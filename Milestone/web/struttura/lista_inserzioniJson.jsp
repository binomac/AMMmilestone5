<%-- 
    Document   : listaInserzioniJquery
    Created on : 14-giu-2016, 15.27.35
    Author     : luca
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="inserzione" items="${listaFiltrata}">
        <json:object>
            <json:property name="titolo" value="${inserzione.nome}"/>
            <json:property name="descrizione" value="${inserzione.descrizione}"/>
            <json:property name="id" value="${inserzione.id}"/>
            <json:property name="prezzo" value="${inserzione.prezzo}"/>
            <json:property name="quantita" value="${inserzione.quantita}"/>
            <json:property name="categoria" value="${inserzione.categoria}"/>
        </json:object>
    </c:forEach>
</json:array>
