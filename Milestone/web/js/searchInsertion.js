/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    $("#ricercaAuto").keyup(function(){
         // Preleva il valore
        var text = $("#ricercaAuto").val();
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              cat: "Auto",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaAuto(data);
            },
            error : function(data, state){
            }
        });
        function aggiornaListaAuto(listaFiltrata){
            // Cancella la lista
            $("#auto").empty();
            if(listaFiltrata.lenght !== 0){
            //Headers
            var trHeader = document.createElement("tr");
            var thNome = document.createElement("th");
            thNome.appendChild(document.createTextNode("Nome"));
            var thFoto = document.createElement("th");
            thFoto.setAttribute("class","foto");
            thFoto.appendChild(document.createTextNode("foto"));
            var thDisponibilita = document.createElement("th");
            thDisponibilita.appendChild(document.createTextNode("Disponibilità"));
            var thPrezzo = document.createElement("th");
            thPrezzo.appendChild(document.createTextNode("Prezzo"));
            var thAzione = document.createElement("th");
            thAzione.appendChild(document.createTextNode("Visualizza"));
            trHeader.appendChild(thNome);
            trHeader.appendChild(thFoto);
            trHeader.appendChild(thDisponibilita);
            trHeader.appendChild(thPrezzo);
            trHeader.appendChild(thAzione);
             $("#auto").append(trHeader);
            
            // Per ogni inserzione trovata nel database
            var counter=0;
            for(var inserzione in listaFiltrata){
                var newtr= document.createElement("tr");
                if((counter % 2) === 1) newtr.setAttribute("class","d"); 
                else newtr.setAttribute("class","p");
            var tdNome = document.createElement("td");
            tdNome.appendChild(document.createTextNode(listaFiltrata[inserzione].titolo));
            var tdFoto = document.createElement("td");
            tdFoto.setAttribute("class","foto");
            tdFoto.appendChild(document.createTextNode("foto"));
            var tdDisponibilita = document.createElement("td");
            tdDisponibilita.appendChild(document.createTextNode(listaFiltrata[inserzione].quantita));
            var tdPrezzo = document.createElement("td");
            tdPrezzo.appendChild(document.createTextNode(listaFiltrata[inserzione].prezzo));
            var tdAzione = document.createElement("td");
            tdAzione.setAttribute("class","cart");
            var link = document.createElement("a");
            link.setAttribute("href","Cliente?cmd=view&id="+
                    listaFiltrata[inserzione].id);
            link.appendChild(document.createTextNode("Visualizza"));
            tdAzione.appendChild(link);
            newtr.appendChild(tdNome);
            newtr.appendChild(tdFoto);
            newtr.appendChild(tdDisponibilita);
            newtr.appendChild(tdPrezzo);
            newtr.appendChild(tdAzione);
            $("#auto").append(newtr);
            counter++;
                
            }
        }else {
            var newtr= document.createElement("tr");
            newtr.appendChild(document.createTextNode("Nessun risultato"));
        }
        }

    });
    $("#ricercaMoto").keyup(function(){
         // Preleva il valore
        var text = $("#ricercaMoto").val();
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              cat: "Moto",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaMoto(data);
            },
            error : function(data, state){
            }
        });
        function aggiornaListaMoto(listaFiltrata){
            // Cancella la lista
            $("#moto").empty();
            //Headers
            var trHeader = document.createElement("tr");
            var thNome = document.createElement("th");
            thNome.appendChild(document.createTextNode("Nome"));
            var thFoto = document.createElement("th");
            thFoto.setAttribute("class","foto");
            thFoto.appendChild(document.createTextNode("foto"));
            var thDisponibilita = document.createElement("th");
            thDisponibilita.appendChild(document.createTextNode("Disponibilità"));
            var thPrezzo = document.createElement("th");
            thPrezzo.appendChild(document.createTextNode("Prezzo"));
            var thAzione = document.createElement("th");
            thAzione.appendChild(document.createTextNode("Visualizza"));
            trHeader.appendChild(thNome);
            trHeader.appendChild(thFoto);
            trHeader.appendChild(thDisponibilita);
            trHeader.appendChild(thPrezzo);
            trHeader.appendChild(thAzione);
             $("#moto").append(trHeader);
            
            // Per ogni inserzione trovata nel database
            var counter=0;
            for(var inserzione in listaFiltrata){
                var newtr= document.createElement("tr");
                if((counter % 2) === 1) newtr.setAttribute("class","d"); 
                else newtr.setAttribute("class","p");
            var tdNome = document.createElement("td");
            tdNome.appendChild(document.createTextNode(listaFiltrata[inserzione].titolo));
            var tdFoto = document.createElement("td");
            tdFoto.setAttribute("class","foto");
            tdFoto.appendChild(document.createTextNode("foto"));
            var tdDisponibilita = document.createElement("td");
            tdDisponibilita.appendChild(document.createTextNode(listaFiltrata[inserzione].quantita));
            var tdPrezzo = document.createElement("td");
            tdPrezzo.appendChild(document.createTextNode(listaFiltrata[inserzione].prezzo));
            var tdAzione = document.createElement("td");
            tdAzione.setAttribute("class","cart");
            var link = document.createElement("a");
            link.setAttribute("href","Cliente?cmd=view&id="+
                    listaFiltrata[inserzione].id);
            link.appendChild(document.createTextNode("Visualizza"));
            tdAzione.appendChild(link);
            newtr.appendChild(tdNome);
            newtr.appendChild(tdFoto);
            newtr.appendChild(tdDisponibilita);
            newtr.appendChild(tdPrezzo);
            newtr.appendChild(tdAzione);
            $("#moto").append(newtr);
            counter++;
                
            }
        }

    });
    $("#ricercaYatch").keyup(function(){
         // Preleva il valore
        var text = $("#ricercaYatch").val();
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              cat: "Yatch",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaYatch(data);
            },
            error : function(data, state){
            }
        });
        function aggiornaListaYatch(listaFiltrata){
            // Cancella la lista
            $("#yatch").empty();
            //Headers
            var trHeader = document.createElement("tr");
            var thNome = document.createElement("th");
            thNome.appendChild(document.createTextNode("Nome"));
            var thFoto = document.createElement("th");
            thFoto.setAttribute("class","foto");
            thFoto.appendChild(document.createTextNode("foto"));
            var thDisponibilita = document.createElement("th");
            thDisponibilita.appendChild(document.createTextNode("Disponibilità"));
            var thPrezzo = document.createElement("th");
            thPrezzo.appendChild(document.createTextNode("Prezzo"));
            var thAzione = document.createElement("th");
            thAzione.appendChild(document.createTextNode("Visualizza"));
            trHeader.appendChild(thNome);
            trHeader.appendChild(thFoto);
            trHeader.appendChild(thDisponibilita);
            trHeader.appendChild(thPrezzo);
            trHeader.appendChild(thAzione);
             $("#yatch").append(trHeader);
            
            // Per ogni inserzione trovata nel database
            var counter=0;
            for(var inserzione in listaFiltrata){
                var newtr= document.createElement("tr");
                if((counter % 2) === 1) newtr.setAttribute("class","d"); 
                else newtr.setAttribute("class","p");
            var tdNome = document.createElement("td");
            tdNome.appendChild(document.createTextNode(listaFiltrata[inserzione].titolo));
            var tdFoto = document.createElement("td");
            tdFoto.setAttribute("class","foto");
            tdFoto.appendChild(document.createTextNode("foto"));
            var tdDisponibilita = document.createElement("td");
            tdDisponibilita.appendChild(document.createTextNode(listaFiltrata[inserzione].quantita));
            var tdPrezzo = document.createElement("td");
            tdPrezzo.appendChild(document.createTextNode(listaFiltrata[inserzione].prezzo));
            var tdAzione = document.createElement("td");
            tdAzione.setAttribute("class","cart");
            var link = document.createElement("a");
            link.setAttribute("href","Cliente?cmd=view&id="+
                    listaFiltrata[inserzione].id);
            link.appendChild(document.createTextNode("Visualizza"));
            tdAzione.appendChild(link);
            newtr.appendChild(tdNome);
            newtr.appendChild(tdFoto);
            newtr.appendChild(tdDisponibilita);
            newtr.appendChild(tdPrezzo);
            newtr.appendChild(tdAzione);
            $("#yatch").append(newtr);
            counter++;
                
            }
        }

    });
    $("#ricercaBarche").keyup(function(){
         // Preleva il valore
        var text = $("#ricercaBarche").val();
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              cat: "Barche",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaBarche(data);
            },
            error : function(data, state){
            }
        });
        function aggiornaListaBarche(listaFiltrata){
            // Cancella la lista
            $("#barche").empty();
            //Headers
            var trHeader = document.createElement("tr");
            var thNome = document.createElement("th");
            thNome.appendChild(document.createTextNode("Nome"));
            var thFoto = document.createElement("th");
            thFoto.setAttribute("class","foto");
            thFoto.appendChild(document.createTextNode("foto"));
            var thDisponibilita = document.createElement("th");
            thDisponibilita.appendChild(document.createTextNode("Disponibilità"));
            var thPrezzo = document.createElement("th");
            thPrezzo.appendChild(document.createTextNode("Prezzo"));
            var thAzione = document.createElement("th");
            thAzione.appendChild(document.createTextNode("Visualizza"));
            trHeader.appendChild(thNome);
            trHeader.appendChild(thFoto);
            trHeader.appendChild(thDisponibilita);
            trHeader.appendChild(thPrezzo);
            trHeader.appendChild(thAzione);
             $("#barche").append(trHeader);
            
            // Per ogni inserzione trovata nel database
            var counter=0;
            for(var inserzione in listaFiltrata){
                var newtr= document.createElement("tr");
                if((counter % 2) === 1) newtr.setAttribute("class","d"); 
                else newtr.setAttribute("class","p");
            var tdNome = document.createElement("td");
            tdNome.appendChild(document.createTextNode(listaFiltrata[inserzione].titolo));
            var tdFoto = document.createElement("td");
            tdFoto.setAttribute("class","foto");
            tdFoto.appendChild(document.createTextNode("foto"));
            var tdDisponibilita = document.createElement("td");
            tdDisponibilita.appendChild(document.createTextNode(listaFiltrata[inserzione].quantita));
            var tdPrezzo = document.createElement("td");
            tdPrezzo.appendChild(document.createTextNode(listaFiltrata[inserzione].prezzo));
            var tdAzione = document.createElement("td");
            tdAzione.setAttribute("class","cart");
            var link = document.createElement("a");
            link.setAttribute("href","Cliente?cmd=view&id="+
                    listaFiltrata[inserzione].id);
            link.appendChild(document.createTextNode("Visualizza"));
            tdAzione.appendChild(link);
            newtr.appendChild(tdNome);
            newtr.appendChild(tdFoto);
            newtr.appendChild(tdDisponibilita);
            newtr.appendChild(tdPrezzo);
            newtr.appendChild(tdAzione);
            $("#barche").append(newtr);
            counter++;
                
            }
        }

    });
});
