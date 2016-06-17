<%-- 
    Document   : descrizione
    Created on : 21-apr-2016, 17.08.18
    Author     : luca
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>MMT - mercato mezzi trasporto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content ="commercio online, acquista, vendi, mezzi trasporto">
        <meta name="description" content="sito ufficiale MMT - cagliari,italia">
        <meta name="author" content="Luca Camboni">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="css/jquery-ui.min.css" rel="stylesheet" type="text/css" media="screen" />
        <script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/errorManager.js"></script>
        <script>
            $(function() {
                $( "#menu" ).menu({
                    items: "> :not(.ui-widget-header)"
                });
            });
        </script>
    </head>
<!-------------------------------------------------------------------------------------------------------------------->
    <body>
        <header>
            <h1>MMT</h1>
            <h2>mercato mezzi trasporto</h2>          
            <nav>
                <ul>
                    <li class="currpag"><a href="descrizione.jsp">HOME</a></li>
                    <li class="man"><a href="Login">Login</a></li>
                    <li class="man"><a 
                             <c:choose>
                                <c:when test="${loggedIn == null && loggedIn == false}">
                                    class="errorLinkAutentication"</c:when>
                                <c:when test="${loggedIn != null || loggedIn == true || UserVenditore != null}">
                                    </c:when>
                                <c:when test="${loggedIn != null || loggedIn == true || UserCliente != null}">
                                    class="errorLinkPermission"</c:when>
                            </c:choose>
                            href="Venditore">Vendi</a></li>
                    <li class="man"><a 
                             <c:choose>
                                <c:when test="${loggedIn == null && loggedIn == false}">
                                    class="errorLinkAutentication"</c:when>
                                <c:when test="${loggedIn != null || loggedIn == true || UserCliente != null}">
                                    </c:when>
                                <c:when test="${loggedIn != null || loggedIn == true || UserVenditore != null}">
                                    class="errorLinkPermission"</c:when>
                            </c:choose>
                            href="Cliente">Compra</a></li>
                </ul>
            </nav>
        </header>
        <nav class="colL">
            <h2>Indice</h2>
            <ul id="menu">
                <li class="ui-widget-header">Category 1</li>
                <li>Option 1</li>
                <li>Option 2</li>
                <li>Option 3</li>
                <li class="ui-widget-header">Category 2</li>    
                <li>Option 4</li>
                <li>Option 5</li>
                <li>Option 6</li>
            </ul>
            <ol>
                <li>
                    <a class="man" href="#prodotti">Cosa vendiamo</a> 
                    <ul>
                        <li><a class="sec" href="#strada">veicoli da strada</a> </li>
                        <li><a class="sec" href="#nautica">mezzi nautici </a></li>
                    </ul>
                </li>
                <li>
                    <a class="man" href="#funzionalità">Come si usa</a> 
                    <ul>
                        <li><a class="sec" href="#venditore">venditore</a></li>
                        <li><a class="sec" href="#cliente">cliente </a></li>
                    </ul>
                </li>
            </ol>
        </nav>
        <article>
            <a id="prodotti"></a>
                <h2>Cosa vendiamo</h2>
                <p>questo sistema tratta solo veicoli a motore</p>
            
            <ol>
                <li><a id="strada"></a>
                    <h3>Mezzi da strada</h3>
                    <ul>
                        <li>
                            <h4>auto</h4>
                            <p>dalle auto da corsa ai fuoristrada , dalle auto d'epoca a macchine nuove di fabbrica , puoi trovare tutti il tipo di autovetture che stai cercando</p>
                        </li><li>
                            <h4>moto</h4>
                            <p>ogni tipo di cilindrata e marca,nuove e usate per tutti i gusti : strada , cross , scooter , sportive </p>
                        </li>
                    </ul>
                </li>
                <li><a id="nautica"></a>
                    <h3>Mezzi marini</h3>
                    <ul>
                        <li>
                            <h4>yacht</h4>
                            <p>barche di lunghezza superiore ai 24 metri</p>
                        </li><li>
                            <h4>Barche</h4>
                            <p>tutti gli altri tipi di imbarcazioni</p>
                        </li>
                    </ul>
                </li>
            </ol>
            <a id="funzionalità"></a>
                <h2>Come si usa</h2>
                <p>mette a disposizione un meccanismo di autenticazione con la possibilità di vendere e comprare tramite il tuo credito</p>
                <p>l'E-commerce di <strong>veicoli a motore</strong> fra privati piu bello </p>
            <ol>
                <li><a id="venditore"></a>
                    <h3>Venditore</h3>
                    <p>Il venditore avrà la possibilità di controllare il saldo della moneta virtuale, di 
                        <em>inserire e rimuovere oggetti in vendita</em>.
                    </p>
                </li>
                <li><a id="cliente"></a>
                    <h3>Cliente</h3>
                    <p>Il cliente invece potrà ricaricare il proprio saldo e procedere all’<em>acquisto di uno o più oggetti</em>.</p>
                </li>
            </ol>
        </article>
        <footer>
            <h2>Sito scritto e realizzato da:</h2>
            <h3>Luca Camboni</h3>
        </footer>
    </body>
</html>
