window.addEventListener('load', function() {
	if (localStorage.getItem('auth_token') === null) {
		window.location.href = '/ruserba/register';
	}

	var nokartu = document.getElementsByName('nokartu')[0];
	var namakartu = document.getElementsByName('namakartu')[0];
	var expiry = document.getElementsByName('expiry')[0];
	
	nokartu.focus();

	expiry.min = new Date().toISOString().split('T')[0];

	document.getElementById('formregisterkartu').onsubmit = function() {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/ruserba/scripts/php/registerkartu.php', true);
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var postParams = 'username=' + localStorage.getItem('username');
		postParams += '&nokartu=' + nokartu.value;
		postParams += '&nama=' + namakartu.value;
		postParams += '&kadaluarsa=' + expiry.value;
		xhr.send(postParams);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var response = JSON.parse(xhr.responseText);
				if (response['status'] == 'success') {
					window.location.href = '/ruserba';
				}
			}
		}
		return false;
	};
	
});