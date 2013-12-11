
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
		var elem = document.getElementById("register").elements;
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
		if (cekfilledAll() && cekusername() && cekNamaDuaKata() && cekEmail() && ceknohp() && cekPassword() && cekCPassword()){
			document.getElementById("submitbutton").removeAttribute("disabled");
		
		}
		else{
			document.getElementById("submitbutton").setAttribute("disabled");
		}	
        
    }
 

    function cekusername()
    {
		var pass = document.getElementById("password").value;
		var user = document.getElementById("username").value;
		if (user.length>4 && pass!=user && AJAXRegister("username") ){
			document.getElementById("validasiusername").value="valid";
			return true;
		}
		else{
			document.getElementById("validasiusername").value="tidak valid";
			return false;
		}
        
    }
	
    function cekEmail()
    {
		var reg = /^[A-Za-z0-9](([_\.\-]?[a-zA-Z0-9]+)*)@([A-Za-z0-9]+)(([\.\-]?[a-zA-Z0-9]+)*)\.([A-Za-z]{2,})$/;
		var elem = document.getElementById("email").value;
		var pass = document.getElementById("password").value;
		if (reg.test(elem) && pass!=elem && AJAXRegister("email")){
			document.getElementById("validasiemail").value="valid";
			return true;
		}
		else{
			document.getElementById("validasiemail").value="tidak valid";
			return false;
		}
		
        
    }
 