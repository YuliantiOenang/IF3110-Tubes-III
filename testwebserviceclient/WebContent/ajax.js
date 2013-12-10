var xmlhttp;
function initAjax() {
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
}

function sendGet(url,cfunc)
{
	initAjax();
	xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				cfunc();
			}
		};
	xmlhttp.open("GET",url,false);
	xmlhttp.send();
}

function sendQuery(url,cfunc)
{
	var newUrl = "Receiver?url=http://tubeswbd.ap01.aws.af.cm/test?query=" + url;
	initAjax();
	xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				cfunc();
			}
		};
	xmlhttp.open("GET",newUrl,false);
	xmlhttp.send();
}

function sendForm(url,cfunc,form) {
	var formdata='?';
	var len = form.length;
	for (var i=0;i<len;i++) {
		if (form.elements[i].type != 'submit') {
			formdata += form.elements[i].name + "=" + form.elements[i].value;
		}
		if (i < len-1) 
			formdata+="&";
	}
	initAjax();
	xmlhttp.onreadystatechange=function()
		{
			if (xmlhttp.readyState==4 && xmlhttp.status==200) {
				cfunc();
			}
		};
	xmlhttp.open("GET",url+formdata,true);
	//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send();
}