<%-- 
    Document   : Logged_Buyer
    Created on : 21-apr-2016, 14.44.59
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
        <link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/errorManager.js"></script>
        

    </head>
    <body>
        <header>
            <h1>MMT</h1>
            <h2>mercato mezzi trasporto</h2>          
            <nav>
                
               <ul>
                   <li class="man" ><a href="descrizione.jsp">HOME</a></li>
                    <li class="currpag"><a href="Login">Login</a></li>
                    <li class="man"><a class="errorLinkPermission" href="Venditore">Vendi</a></li>
                    <li class="man" ><a href="Cliente">Compra</a></li>
                </ul>
                
            </nav>
        </header>
        <div class="cForm">
            <h2>Area Riservata</h2>
            <h3>Bentornato ${UserCliente.nome} ${UserCliente.cognome}
                <br>
                il tuo saldo è di : ${UserCliente.credito.conto}
            </h3>
        </div>
            <c:if test="${errorType != null}">
            <jsp:include page="../struttura/errorPage.jsp" />
        </c:if>
        <c:if test="${venduto != null && venduto== true }">
            <div class="annuncio">
                Acquisto Effettuato
            </div>    
        </c:if>
    </body>
</html>
