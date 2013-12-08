var xmlhttpCredit;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
	xmlhttpCredit=new XMLHttpRequest();
} else {// code for IE6, IE5
	xmlhttpCredit=new ActiveXObject("Microsoft.XMLHTTP");
}
function credit(URL) {	
	var parameters = "credit_number=" + encodeURI(document.getElementById("card_number").value) + "&name_of_card=" + encodeURI(document.getElementById("name_of_card").value);
	xmlhttpCredit.open("GET",URL+"/api/checkCredit?"+parameters,true);
	xmlhttpCredit.send();
	console.log(parameters);
	xmlhttpCredit.onreadystatechange=function() {
		if (xmlhttpCredit.readyState==4 && xmlhttpCredit.status==200) {
			console.log(xmlhttpCredit.responseText);
			var data = JSON.parse(xmlhttpCredit.responseText);
			if (data.success) {
				document.getElementById('form_credit').submit();
			} else {
				alert(data.error);
			}
		}
	}
}
