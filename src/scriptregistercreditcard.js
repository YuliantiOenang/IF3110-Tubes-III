
function ceknumber(){
	if (AJAXRegister("cardnumber")){
		
		document.getElementById("validasicardnumber").value="valid";
		return true;
	}else{
		document.getElementById("validasicardnumber").value="tidak valid";
		return false;
	}
}



function ceknamecard(){
	if (AJAXRegister("namecard")){
		document.getElementById("validasinamecard").value="valid";	
		return true;
	}else{
		document.getElementById("validasinamecard").value="tidak valid";
		return false;
	}
}


function cekexpiredate(){
	
	if (AJAXRegister("expiredate")){
		document.getElementById("validasiexpiredate").value="valid";
		return true;
		
	}else{
		document.getElementById("validasiexpiredate").value="tidak valid";
		return false;
	}

}


function cekvalid(){

	if (cekfilledAll() && ceknumber() && ceknamecard() && cekexpiredate()){
		alert("sukses");
		return true;
	}else{
		alert("pastikan data valid");
		return false;
	}



}


function cekfilledAll()
{
	var elem = document.getElementById("registercreditcard").elements;
	var cansubmit = true;
	
	for (var i = 0; i < elem.length; i++) {
        if (elem[i].value.length == 0) cansubmit = false;
    }
	if (cansubmit){
		
        return true;
	}else{
			return false;
	}
    
}