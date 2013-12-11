function createObject() 
{
	var request_type;
	var browser = navigator.appName;
	
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
	request_type=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	request_type=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	return request_type;
}

var http = createObject();
