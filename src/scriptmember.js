
    function cekNamaDuaKata() {
        var pass = document.getElementById("namalengkap").value;
		for (var i = 0;i<pass.length;i++){
			
			if (pass.charAt(i)==' '){
				if (i-1>=0 && i+1<pass.length){
					document.getElementById("validasinamalengkap").value="valid";
					return true;
				}
			}
		}
		document.getElementById("validasinamalengkap").value="tidak valid";
		return false;
    }


    function cekCPassword() {
        var pass1 = document.getElementById("password").value;
        var pass2 = document.getElementById("cpassword").value;
        if (pass1 != pass2 || pass2.length<8) {
            document.getElementById("validasiCpassword").value="tidak valid";
			return false;
		}
        else {
           document.getElementById("validasiCpassword").value="valid";
			return true;
        }
    }




    function cekPassword() {
        var pass1 = document.getElementById("password").value;
        var pass2 = document.getElementById("cpassword").value;
		var user = document.getElementById("username").value;
		var em = document.getElementById("email").value;
        if (pass1.length>7 && pass1!=user && pass1!=em) {
            document.getElementById("validasipassword").value="valid";
			return true;
		}
        else {
			
           document.getElementById("validasipassword").value="tidak valid";
			return false;
        }
    }



    function ceknohp() {
        var pass = document.getElementById("nohp").value;
		var reg = /[0-9]+[0-9]*/
		 document.getElementById("validasinohp").value="valid";
        if (reg.test(pass)) {
            document.getElementById("validasinohp").value="valid";
			return true;
		}
        else {
           document.getElementById("validasinohp").value="tidak valid";
			return false;
        }
    }



    function cekfilledAll()
    {
		var elem = document.getElementById("profile").elements;
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
 


    function cekvalidAll()
    {
		if (cekfilledAll() && cekNamaDuaKata() && ceknohp() && cekPassword() && cekCPassword()){
			document.getElementById("submitbutton").removeAttribute("disabled");
		
		}
		else{
			document.getElementById("submitbutton").setAttribute("disabled");
		}	
        
    }
 

function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}


function cekChangeData(){
		
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	
	var email = document.getElementById("email").value;
	var namalengkap= document.getElementById("namalengkap").value;

	var nohp= document.getElementById("nohp").value;
	

	var provinsi = document.getElementById("provinsi").value;

	var kotakabupaten = document.getElementById("kotakabupaten").value;
	
	var alamat = document.getElementById("alamat").value;
	var kodepos = document.getElementById("kodepos").value;
	
	
	var iusername = document.getElementById("iusername").value;	
	var ipassword = document.getElementById("ipassword").value;
	var iemail = document.getElementById("iemail").value;
	var inamalengkap= document.getElementById("inamalengkap").value;
	var inohp= document.getElementById("inohp").value;
	
	
	var iprovinsi = document.getElementById("iprovinsi").value;
	var ikotakabupaten = document.getElementById("ikotakabupaten").value;
	
	var ialamat = document.getElementById("ialamat").value;
	
	var ikodepos = document.getElementById("ikodepos").value;


	if (iusername==username && ipassword==password && iemail==email && inamalengkap==namalengkap && inohp==nohp && iprovinsi==provinsi && ikotakabupaten==kotakabupaten && ialamat==alamat && ikodepos==kodepos){
		alert("Tidak ada perubahan pada data");
		return false;
		
	}else{
		alert("Sukses");
		sleep(1);
		return true;
		
	}
	
}

