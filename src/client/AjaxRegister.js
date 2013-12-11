	
	
function AJAXRegister(lol){
  var elem2= document.getElementById("cardnumber");  
  var elem = document.getElementById(lol);

    var params = "";
	if (lol=="username"){
		url = "cek_username.php";
	}else if (lol=="email"){
		url="cek_email.php";
	}else if (lol=="cardnumber"){
		url ="cek_cardnumber.php";
	}else if (lol=="namecard"){
		url="cek_namecard.php";
	}else if (lol=="expiredate"){
		url="cek_expiredate.php";
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
	var lolipop = xmlhttp.responseText; 
  
	if (xmlhttp.responseText==true){
		
		return true;
	}else{
		
		return false;
	}
	

	
	
}
