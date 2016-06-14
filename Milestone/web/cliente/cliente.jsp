<%-- 
    Document   : cliente
    Created on : 24-apr-2016, 16.49.27
    Author     : luca
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MMT - Acquista</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="MMT - Compra">
        <meta name="author" content="Luca Camboni">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
        <script type="text/javascript" src="js/searchInsertion.js"></script>

    </head>
    <body>
        <header>
            <h1>MMT</h1>
            <h2>mercato mezzi trasporto</h2> 
            <nav>
                
                <ul>
                    <li><a class="man" href="descrizione.jsp">HOME</a></li>
                    <li><a class="man" href="Login">Login</a></li>
                    <li><a class="man" href="Venditore">Vendi</a></li>
                    <li class="currpag"><a href="Cliente">Compra</a></li>
                </ul>
                
            </nav>
        </header>
        <nav class="colL">
            <h2>Indice</h2>
            <ol>
                <li>
                    <a class="man" href="#strada">Veicoli da strada</a> 
                    <ul>
                        <li><a class="sec" href="#auto">Auto</a></li>
                        <li><a class="sec" href="#moto">Moto</a></li>
                    </ul>
                </li>
                <li>
                    <a class="man" href="#nautica">Mezzi nautici</a> 
                    <ul>
                        <li><a class="sec" href="#yathc">Yathc</a></li>
                        <li><a class="sec" href="#barche">Barche</a></li>
                    </ul>
                </li>
            </ol>
            
        </nav>
        <article>
            <h2>Il mercato</h2>
            <section><a id="strada">
                <h3>veicoli da strada</h3>
            </a>
                
                
                    <h4>Auto</h4>
                
                <!-- Tasto Ricerca -->
                <form>
                <label for="ricerca">Barra di ricerca</label>
                <input type="text" id="ricercaAuto"/>
                </form>
                <table id="auto">
                <tr>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <th>Visualizza</th>
                </tr>
                <c:set var="counter" value="0"/>
                <c:forEach var="itemsVendita" items="${listaAuto}">
                    
                    <c:choose>
                        <c:when test="${counter == 0}"><tr class="p"><c:set var="counter" value="1"/></c:when>
                        <c:when test="${counter == 1}"><tr class="d"><c:set var="counter" value="0"/></c:when>
                    </c:choose>
                    
                        <td>${itemsVendita.nome}</td>
                        <td><img title="${itemsVendita.nome}" alt="${itemsVendita.nome}" src="/WebApplication1/M3/img/${itemsVendita.URL}" width="80" height="80"></td>
                        <td>
                            <c:if test="${itemsVendita.quantita > 0}">disponibile</c:if>
                            <c:if test="${itemsVendita.quantita < 1}">venduto!</c:if>
                        </td>
                        <td>${itemsVendita.prezzo} €</td>
                        <td class="cart"><a href="Cliente?cmd=view&id=${itemsVendita.id}">Visualizza</a></td>
                    </tr>
                </c:forEach>
                </table> 
                
                
                
                    <h4>Moto</h4>
                
                <label for="ricerca">Barra di ricerca</label>
                <input type="text" id="ricercaMoto" size="15"/>
                    <table id="moto">
                <tr>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <th>Modifica</th>
                </tr>
                <c:forEach var="itemsVendita" items="${listaMoto}">
                    <c:choose>
                        <c:when test="${counter == 0}"><tr class="p"><c:set var="counter" value="1"/></c:when>
                        <c:when test="${counter == 1}"><tr class="d"><c:set var="counter" value="0"/></c:when>
                    </c:choose>
                        <td>${itemsVendita.nome}</td>
                        <td><img title="${itemsVendita.nome}" alt="${itemsVendita.nome}" src="/WebApplication1/M3/img/${itemsVendita.URL}" width="80" height="80"></td>
                        <td>
                            <c:if test="${itemsVendita.quantita > 0}">disponibile</c:if>
                            <c:if test="${itemsVendita.quantita < 1}">venduto!</c:if>
                        </td>
                        <td>${itemsVendita.prezzo} €</td>
                        <td class="cart"><a href="Cliente?cmd=view&id=${itemsVendita.id}">Visualizza</a></td>
                    </tr>
                </c:forEach>
            </table> 
            </section>
            <section>
                
                    <h3>Mezzi nautici</h3>
                
                <label for="ricerca">Barra di ricerca</label>
                <input type="text" id="ricercaYatch" size="15"/>
                
                    <h4>Yathc</h4>
                
                <table id="yatch">
                <tr>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <th>Modifica</th>
                </tr>
                <c:forEach var="itemsVendita" items="${listaYatch}">
                    <c:choose>
                        <c:when test="${counter == 0}"><tr class="p"><c:set var="counter" value="1"/></c:when>
                        <c:when test="${counter == 1}"><tr class="d"><c:set var="counter" value="0"/></c:when>
                    </c:choose>
                        <td>${itemsVendita.nome}</td>
                        <td><img title="${itemsVendita.nome}" alt="${itemsVendita.nome}" src="/WebApplication1/M3/img/${itemsVendita.URL}" width="80" height="80"></td>
                        <td>
                            <c:if test="${itemsVendita.quantita > 0}">disponibile</c:if>
                            <c:if test="${itemsVendita.quantita < 1}">venduto!</c:if>
                        </td>
                        <td>${itemsVendita.prezzo} €</td>
                        <td class="cart"><a href="Cliente?cmd=view&id=${itemsVendita.id}"">Visualizza</a></td>
                    </tr>
                </c:forEach>
            </table> 
                    
                
                    <h4>Barche</h4>
                
                <label for="ricerca">Barra di ricerca</label>
                <input type="text" id="ricercaBarche" size="15"/>
                    <table id="barche">
                <tr>
                    <th>Nome</th>
                    <th class="foto">Foto</th>
                    <th>Disponibilità</th>
                    <th>Prezzo</th>
                    <th>Modifica</th>
                </tr>
                <c:forEach var="itemsVendita" items="${listaBarche}">
                    
                   <c:choose>
                        <c:when test="${counter == 0}"><tr class="p"><c:set var="counter" value="1"/></c:when>
                        <c:when test="${counter == 1}"><tr class="d"><c:set var="counter" value="0"/></c:when>
                    </c:choose>
                        <td>${itemsVendita.nome}</td>
                        <td><img title="${itemsVendita.nome}" alt="${itemsVendita.nome}" src="/WebApplication1/M3/img/${itemsVendita.URL}" width="80" height="80"></td>
                        <td>
                            <c:if test="${itemsVendita.quantita > 0}">disponibile</c:if>
                            <c:if test="${itemsVendita.quantita < 1}">venduto!</c:if>
                        </td>
                        <td>${itemsVendita.prezzo} €</td>
                        <td class="cart"><a href="Cliente?cmd=view&id=${itemsVendita.id}"">Visualizza</a></td>
                    </tr>
                </c:forEach>
            </table> 
            </section>
        </article>
   </body>
</html>
 
