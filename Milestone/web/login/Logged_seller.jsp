<%-- 
    Document   : Form_Logged
    Created on : 21-apr-2016, 14.37.12
    Author     : luca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>MMT - Account page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="MMT - login">
        <meta name="author" content="Luca Camboni">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
        <header>
            <h1>MMT</h1>
            <h2>mercato mezzi trasporto</h2>          
            <nav>
                
               <ul>
                   <li><a class="man" href="descrizione.jsp">HOME</a></li>
                    <li class="currpag"><a href="Login">Login</a></li>
                    <li><a class="man" href="Venditore">Vendi</a></li>
                    <li><a class="man" href="Cliente">Compra</a></li>
                </ul>
                
            </nav>
        </header>
        <div class="cForm">
            <h2>Area Riservata</h2>
            <h3>Bentornato ${UserVenditore.nome} ${UserVenditore.cognome}
                <br>
                il tuo saldo è di : ${UserVenditore.credito.conto}
                <br/>il tuo id è : ${UserVenditore.id}
            </h3>
            <h3>Le tue inserzioni:</h3>
            <table>
                <tr>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <th>Modifica</th>
                </tr>
                <c:set var="counter" value="0"/>
                <c:forEach var="itemsVendita" items="${UserVenditore.inserzioniAperte}">
                    <c:choose>
                        <c:when test="${counter == 0}"><tr class="p"><c:set var="counter" value="1"/></c:when>
                        <c:when test="${counter == 1}"><tr class="d"><c:set var="counter" value="0"/></c:when>
                    </c:choose>
                        <td>${itemsVendita.nome}</td>
                        <td><img title="${itemsVendita.nome}" alt="${itemsVendita.nome}" src="M3/img/${itemsVendita.URL}" width="80" height="80"></td>
                        <td><c:if test="${itemsVendita.quantita > 0}">disponibile</c:if></td>
                        <td>${itemsVendita.prezzo} €</td>
                        <td class="cart"><a href="Venditore?cmd=view&id=${itemsVendita.id}">Visualizza</a></td>
                    </tr>
                </c:forEach>
            </table> 
        </div>
        <c:if test="${errorType != null }">
            <jsp:include page="../struttura/errorPage.jsp" />
        </c:if>
                
                      
    </body>
</html>
