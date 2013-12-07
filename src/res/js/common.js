function checkclear(what){
	if(!what._haschanged){
		what.value=''
	};
	what._haschanged=true;
}

function checkempty(what, msg_if_empty) {
	if(what.value=='') {
		what.value= msg_if_empty;
		what._haschanged=false;
	};
}

function validateForm(form_name, properties, msg_if_blank)
{
var x=document.forms[form_name][properties].value;
var kat = document.getElementById("search-kategori").value;
var har1 = document.getElementById("search-harga1").value;
var har2 = document.getElementById("search-harga2").value;

if ((x==null || x=="" || x==msg_if_blank)&&(kat=="%")&&(har1=="-1" || har2=="999999999"))
  {
	  alert("Harap diisi, input tidak valid!");
	  return false;
  }
}