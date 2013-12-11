function registrationchk()
{
	var usernamee = document.getElementById("userid");	
	var fullname = document.getElementById("fullname");	
	var password = document.getElementById("passwordd");	
	var password2 = document.getElementById("confirmpassword");
	var email = document.getElementById("email");
	var alamat = document.getElementById("alamat");
	var nohp = document.getElementById("nohp");	
	var provinsi = document.getElementById("provinsi");
	var kabupaten = document.getElementById("kabupaten");	
	var num1 = 7;
	var num2 = 4;
	if (usernamee.value.length <= num2)
	{
		alert (" Username minimal 5 karakter\n");	
		return false;
	}
	else if (password.value.length <= num1)
	{
		alert ("Password minimal 8 karakter\n");	
		return false;
	}
	else if (password2.value != password.value)
	{
		alert("Konfirmasi password tidak sama dengan password\n");
		return false;
	}
	else
	return true;
	
}