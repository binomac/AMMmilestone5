<%-- 
    Document   : venditore
    Created on : 24-apr-2016, 15.49.47
    Author     : luca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>MMT - Vendi</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="MMT - venditore">
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
                    <li><a class="man" href="Login">Login</a></li>
                    <li class="currpag"><a href="Venditore">Vendi</a></li>
                    <li><a class="man" href="Cliente">Compra</a></li>
                </ul>
                
            </nav>
        </header>
        <div class="cForm">
            <h2>Vendi prodotto</h2>
            <h3>Crea inserzione</h3>
            <form method="post" action="Venditore">
                <fieldset>
                    <legend>Informazioni prodotto</legend>
                    <c:if test="${(action != null ) && (action eq 'new')}">
                        <label for="category">categoria:</label>
                    <select name="categoria" id="category">
                        <option value="Auto">Auto</option>
                        <option value="Moto">Moto</option>
                        <option value="Yatch">Yatch</option>
                        <option value="Barche">Barche</option>
                    </select>
                    <br/>
                    </c:if>
                    
                    <label for="name">Nome oggetto:</label>
                    <input type="text" name="nome" id="name" value="${inserzione.nome}" />
                    <br/>
                    <label for="urlimg">URL immagine descrittiva:</label>
                    <input type="text" name="foto" id="urlimg" value="fiat500.jpg"/>
                    <br/>
                    <label for="descr">Descrizione prodotto:</label>
                    <textarea name="descrizione" id="descr" rows="4" cols="20" ><c:if test="${(action != null ) && (action eq 'mod')}">${inserzione.descrizione}</c:if>
                        <c:if test="${(action != null ) && (action eq 'new')}">Inserire qui la descrizione</c:if>
                    </textarea>
                    <br/>
                    <label for="price">Prezzo:</label>
                    <input type="text" name="prezzo" id="price" 
                    <c:if test="${(action != null ) && (action eq 'new')}">value="0.00"</c:if>
                    <c:if test="${(action != null ) && (action eq 'mod')}">value="${inserzione.prezzo}"</c:if>
                    />
                           
                    <br/>
                    <label for="quantity">quantità:</label>
                    <input type="number" name="quantita" id="quantity" 
                           <c:if test="${(action != null ) && (action eq 'new')}">value="1" </c:if>
                           <c:if test="${(action != null ) && (action eq 'mod')}">value="${inserzione.quantita}"</c:if>
                    />
                           
                    <br/>
                    <c:if test="${(action != null ) && (action eq 'new')}"><input type="hidden" name="cmd" value="inserimento"/></c:if>
                    <c:if test="${(action != null ) && (action eq 'mod')}">
                        <input type="hidden" name="cmd" value="modifica"/><input type="hidden" name="id" value="${inserzione.id}"/></c:if>
                    <input type="submit" name="submit" 
                    <c:if test="${(action != null ) && (action eq 'new')}">value="Vendi"</c:if> 
                    <c:if test="${(action != null ) && (action eq 'mod')}">value="Modifica"</c:if>
                    class="sbutton"/>
                </fieldset>
            </form>
        </div>
        <c:if test="${errorType != null}">
            <jsp:include page="/struttura/errorPage.jsp" />
        </c:if>
    </body>
</html>

