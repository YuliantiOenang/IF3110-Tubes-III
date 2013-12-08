
function AJAXPost(){
	
    var elem = document.getElementById("login").elements;
    var params = "";
    url = document.getElementById("login").action;
	
	
    for(var i = 0; i < elem.length; i++){
        if (elem[i].tagName == "SELECT"){
            params += elem[i].name + "=" +     encodeURIComponent(elem[i].options[elem[i].selectedIndex].value) + "&";
        }else{
            params += elem[i].name + "=" + encodeURIComponent(elem[i].value) + "&";
        }
    } 
	
    if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }else{// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
	
    xmlhttp.open("POST",url,false);
	
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlhttp.setRequestHeader("Content-length", params.length);
    xmlhttp.setRequestHeader("Connection", "close");
	xmlhttp.send(params);
	
	return xmlhttp.responseText;

	
	
}
