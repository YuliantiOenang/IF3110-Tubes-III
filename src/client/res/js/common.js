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
if (x==null || x=="" || x==msg_if_blank)
  {
	  alert("Harap diisi, form masih kosong!");
	  return false;
  }
}