window.addEventListener('load', function() {
	var paybutton = document.getElementsByName('bayar')[0];

	paybutton.onclick = function() {
		var xhr = new XMLHttpRequest();
		xhr.open('POST', '/ruserba/scripts/php/pay.php', true);
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		var postParams = 'username=' + localStorage.getItem('username');
		xhr.send(postParams);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var response = JSON.parse(xhr.responseText);
				if (response['status'] == 'success') {
					window.location.href = '/ruserba';
				}
				else if (response['status'] == 'partial') {
					alert('Beberapa barang tidak mencukupi');
					window.location.reload();
				}
				else if (response['status'] == 'expired') {
					alert('Kartu kredit yang digunakan telah kadaluarsa');
					window.location.href = '/ruserba/registerkartu';
				}
				else {
					window.location.href = '/ruserba/registerkartu';
				}
			}
		}
	}

});