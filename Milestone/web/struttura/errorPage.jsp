<%-- 
    Document   : errorPage
    Created on : 27-apr-2016, 14.01.55
    Author     : luca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="error">
    
        <h1>! Errore !</h1>
            <h2>
            <c:choose>
                <c:when test="${errorType == 'inserimentoInserzione'}" >
                    L'inserzione ha riscontrato problemi;
                    <h3>
                    <c:choose>
                        
                        <c:when test="${errorCode == 0}" >
                            Errore nella creazione dell'inserzione
                        </c:when>
                        <c:when test="${errorCode == 1}">
                            Il nome non è stato impostato correttamente
                        </c:when>
                        <c:when test="${errorCode == 2}">
                             La quantità non è stata impostata correttamente
                        </c:when>
                        <c:when test="${errorCode == 3}">
                             Il prezzo non è stato impostato correttamente
                        </c:when>
                        <c:when test="${errorCode == 4}">
                             L'immagine non è stata impostata correttamente
                        </c:when>
                        
                    </c:choose>
                    </h3>
                </c:when>
                <c:when test="${errorType == 'wrongUser'}">
                    Non puoi accedere a questa sezione
                    <h3>
                    <c:choose>
                        
                        <c:when test="${errorCode == 1}">
                            Sei un venditore , non puoi accedere alla sezione cliente
                        </c:when>
                        <c:when test="${errorCode == 2}">
                            Sei un cliente , non puoi accedere alla sezione venditore
                        </c:when>
                        
                    </c:choose>
                    </h3>
                </c:when>
                <c:when test="${errorType == 'transazione'}">
                    Errore durante l'acquisto
                    <h3>
                    <c:choose>
                        <c:when test="${errorCode == 1}">
                            Il tuo credito non è suficente per completare la transazione
                        </c:when>
                        <c:when test="${errorCode == 2}">
                            L'inserzione richiesta non esiste
                        </c:when>
                    </c:choose>
                    </h3>
                </c:when>   
                <c:when test="${errorType == 'notLogged'}">
                        Devi prima accedere alla tua area riservata per visitare questa pagina
                </c:when>
                <c:when test="${errorType == 'autenticazione'}">
                    Account non registrato nel server
                </c:when>
            </c:choose>
        
    </h2>
</div>
