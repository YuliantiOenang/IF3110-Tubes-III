	
	
function AJAXRegister(lol){
	var data=document.getElementById(lol).value;
	url="ValidateRegistrasi";
	
    if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }else{// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST",url,false);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlhttp.send("DataType="+lol+"&Data="+data);  
	if (xmlhttp.responseText.trim()=="betul"){
		return true;
	}else{
		
		return false;
	}
	

	
	
}
