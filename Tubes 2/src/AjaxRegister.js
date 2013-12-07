	
	
function AJAXRegister(lol){
  var elem2= document.getElementById("cardnumber");  
  var elem = document.getElementById(lol);

    var params = "";
	if (lol=="rusername"){
		url = "UsernameValidationServlet";
	}else if (lol=="email"){
		url="EmailValidationServlet";
	}else if (lol=="cardnumber"){
		url ="CardNumberValidationServlet";
	}else if (lol=="namecard"){
		url="NameCardValidationServlet";
	}else if (lol=="expiredate"){
		url="ExpireDateValidationServlet";
	}
   
        if (elem.tagName == "SELECT"){
            params += elem.name + "=" +     encodeURIComponent(elem.options[elem.selectedIndex].value) + "&";
        }else{
			if (lol=="namecard" || lol=="expiredate"){
			
				params += elem.name + "=" + encodeURIComponent(elem.value) + "&" + elem2.name + "=" + encodeURIComponent(elem2.value) + "&";
			}else{
				params += elem.name + "=" + encodeURIComponent(elem.value);
			}
        }
    
	
    if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }else{// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST",url,false);
	
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xmlhttp.send(params);
	
	if (xmlhttp.responseText=='true'){
		
		return true;
	}else{
		
		return false;
	}
	

	
	
}
