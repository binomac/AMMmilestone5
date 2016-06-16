/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function (){
    $("#not").click(function (event) {
        event.preventDefault();
        var divAlert= document.createElement("div");
        divAlert.setAttribute("id","dialog-message");
        divAlert.setAttribute("class","ui-state-error ui-corner-all ui-dialog-content ui-widget-content");
        divAlert.setAttribute("title","Errore !");
        var imgSpan = document.createElement("span");
        imgSpan.setAttribute("class","ui-icon ui-icon-alert");
        imgSpan.setAttribute("style","float: left; margin-right: .3em;");
        var pMessage = document.createElement("p");
        pMessage.appendChild(imgSpan);
        pMessage.appendChild(document.createTextNode("Sei un cliente , non puoi accedere alla sezione venditore"));
        
        divAlert.appendChild(pMessage);
        document.body.appendChild(divAlert);
    });
});