window.addEventListener('load', function() {
	var belibutton = document.getElementsByClassName('beli');	
	
	for(var i=0; i<belibutton.length; i++) {
		belibutton[i].onclick = function() {
			if (localStorage.getItem('auth_token') != null) {
				var idbarang = this.name;
				var xhr = new XMLHttpRequest();
				xhr.open('POST', '/ruserba/scripts/php/addtocart.php', true);
				xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
				var postParams = 'id=' + idbarang;
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
				window.location.href = '/ruserba/register';
			}
			return false;
		}
	}
	
	
});