/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





$(document).ready(function (){
    
    $("a.errorForm").click(function (event) {
        event.preventDefault();
        var Homelink= "descrizione.jsp";
        var LoginLink = "Login";
        var ClienteLink = "Cliente";
        var VenditoreLink = "Venditore";
        var destinazioneLink = event.currentTarget.attr('href');
        
        
        $.ajax(
        {
            url: "ErrMan.json",
            data:{
              cmd: "check",
              cat: "link",
              link: destinazioneLink
            },
            dataType: 'json',
            success : function(listaErrori, state){
                if(document.getElementById("error-message")===null){
            
                    var divAlert= document.createElement("div");
        
                    divAlert.setAttribute("id","error-message");
                    divAlert.setAttribute("class","ui-state-error ui-corner-all");
                    divAlert.setAttribute("title","Errore!");
                    var imgSpan = document.createElement("span");
                    imgSpan.setAttribute("class","ui-icon ui-icon-alert");
                    imgSpan.setAttribute("style","float: left; margin-right: .3em;");
                    for(var errore in listaErrori){
                        var pMessage = document.createElement("p");
                        pMessage.appendChild(imgSpan);
                        pMessage.appendChild(document.createTextNode("<strong>" + listaErrori[errore].tipo + ":</strong>" +
                                listaErrori[errore].description));
                        divAlert.appendChild(pMessage);
                    }
                document.body.appendChild(divAlert);
            }
            },
            error : function(data, state){
            }
        });
        
        
        

    });
    $("a.errorLinkAutentication").click(function (event) {
        event.preventDefault();
        /*
        if(document.getElementById("error-message-autentication")===null){
            
                    var divAlert= document.createElement("div");
        
                    divAlert.setAttribute("id","error-message-autentication");
                    //divAlert.setAttribute("class","ui-state-error ui-corner-all");
                    divAlert.setAttribute("title","Errore!");
                    var imgSpan = document.createElement("span");
                    imgSpan.setAttribute("class","ui-icon ui-icon-alert");
                    imgSpan.setAttribute("style","float: left; margin-right: .3em;");
                    var pMessage = document.createElement("p");
                    var strongMessage = document.createElement("strong");
                    strongMessage.appendChild(document.createTextNode("Acesso non eseguito :"));
                    pMessage.appendChild(strongMessage);
                    pMessage.appendChild(imgSpan);
                    pMessage.appendChild(document.createTextNode("devi prima acedere alla tua area riservata")); 
                    divAlert.appendChild(pMessage);
                document.body.appendChild(divAlert);
                $( "#error-message-autentication" ).dialog({
                autoOpen: false,
                closeOnEscape: true,
                dialogClass: "err-aut",
                show: {
                    effect: "blind",
                    duration: 500
                },
                hide: {
                    effect: "blind",
                    duration: 300
                }
            });
                $("#error-message-autentication").dialog('open');
            }*/
        
        //ho sostituito il messaggio di avviso con questo plugin
        $.growl.error({ message: "Devi prima accedere alla tua area riservata" });
    });
    $("a.errorLinkPermission").click(function (event) {
        event.preventDefault();
        /*if(document.getElementById("error-message-permission")===null){
            
                    var divAlert= document.createElement("div");
        
                    divAlert.setAttribute("id","error-message-permission");
                    divAlert.setAttribute("class","error-dialog");
                    divAlert.setAttribute("title","Errore!");
                    var imgSpan = document.createElement("span");
                    imgSpan.setAttribute("class","ui-icon ui-icon-alert");
                    imgSpan.setAttribute("style","float: left; margin-right: .3em;");
                    var pMessage = document.createElement("p");
                    var strongMessage = document.createElement("strong");
                    pMessage.appendChild(imgSpan);
                    strongMessage.appendChild(document.createTextNode("Acesso negato :"));
                    pMessage.appendChild(strongMessage);
                    pMessage.appendChild(document.createTextNode("puoi accedere solo alla tua area")); 
                    divAlert.appendChild(pMessage);
                    
                document.body.appendChild(divAlert);
            }
            $( "#error-message-permission" ).dialog({
                autoOpen: false,
                show: {
                    effect: "blind",
                    duration: 500
                },
                hide: {
                    effect: "explode",
                    duration: 300
                }
            });
            $("#error-message-permission").dialog('open');
            */
           $.growl.error({ message: "Permesso negato , non puoi accedere a questa pagina" });
    });
});