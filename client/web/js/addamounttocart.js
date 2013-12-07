window.addEventListener('load', function() {
	var inputjumlah = document.getElementsByClassName('inputjumlah')[0];
	var belibutton = document.getElementsByClassName('beli')[0];
	
	belibutton.onclick = function() {
		if (localStorage.getItem('auth_token') != null) {
			if (inputjumlah.value * 1 > 0 && inputjumlah.value * 1 <= inputjumlah.max * 1) {
				var xhr = new XMLHttpRequest();
				xhr.open('POST', '/ruserba/UpdateCartServlet', true);
				xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
				var postParams = 'idbarang=' + this.name +'&count='+inputjumlah.value;
				xhr.send(postParams);
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {
						document.write(xhr.responseText);
						var response = JSON.parse(xhr.responseText);
						if (response['status'] == 'success') {
							window.location.reload();
						}
					}
				}
			}
			else {
				alert('Barang yang tersedia tidak mencukupi');
			}
		}
		else {
			window.location.href = '/ruserba/register';
		}
		return false;
	}
	
});