<%-- 
    Document   : inserzione
    Created on : 24-apr-2016, 19.49.09
    Author     : luca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MMT - inserzione</title>
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
        <div class="container">
        <table class="singleRow">
                <thead>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <c:if test="${UserCliente != null}"><th>Compra</th></c:if>
                    <c:if test="${UserVenditore != null}"><th>Modifica</th></c:if>
                </thead>
                <tbody>
                   <tr class="d">
                        <td>${inserzione.nome}</td>
                        <td><img title="${inserzione.nome}" alt="${inserzione.nome}" src="/WebApplication1/M3/img/${inserzione.URL}" width="80" height="80"></td>
                        <td>
                            <c:if test="${inserzione.quantita > 0}">disponibile</c:if>
                            <c:if test="${inserzione.quantita < 1}">non disponibile</c:if>
                        </td>
                        <td>${inserzione.prezzo} €</td>
                        <c:if test="${UserCliente != null && inserzione.quantita > 0}">
                            <td class="cart"><a href="Cliente?cmd=buy&id=${inserzione.id}">Conferma</a></td>
                        </c:if>
                        <c:if test="${UserCliente != null && inserzione.quantita < 1}"><td></td></c:if>
                        <c:if test="${UserVenditore != null}"><td>
                                <a href="Venditore?cmd=modifica&id=${inserzione.id}">Modifica</a>
                                <a href="Venditore?cmd=cancella&id=${inserzione.id}">Cancella</a>
                            </td></c:if>
                        
                    </tr>
                    
                </tbody>
             
            </table> 
        <p>${inserzione.descrizione}<p>
        </div>
                        
        
                        
        <c:if test="${errorType != null }">
            <jsp:include page="struttura/errorPage.jsp" />
        </c:if>
        <c:if test="${creato != null && creato== true }">
            <div class="annuncio">
                Inserzione creata
            </div>    
        </c:if>
    </body>
                        
</html>
