function validateUsername($value) {
	var username = document.register.username;
	if (username.value < 5) {
		username.addClass('error');
		username.innerHTML = "Jumlah karakter minimal 5";
	};
}