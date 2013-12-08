window.addEventListener('load', function() {
	if (localStorage.getItem('auth_token') === null) {
		window.location.href = '/ruserba/register';
	}

	var inputjumlah = document.getElementsByClassName('inputjumlah');

	for (var i = 0; i < inputjumlah.length; i++) {
		inputjumlah[i].onchange = function () {
			if (this.value * 1 < 0) {
				this.value = 0;
			}
			else if (this.value * 1 > this.max * 1) {
				this.value = this.max;
			}
			var harga = document.getElementById('harga_' + this.name).innerHTML;
			var oldsub = document.getElementById('subtotal_' + this.name).innerHTML;
			var newtotal = document.getElementById('angkatotal').innerHTML - oldsub;
			var newsub = this.value * harga;
			document.getElementById('subtotal_' + this.name).innerHTML = newsub;
			newtotal += newsub;
			document.getElementById('angkatotal').innerHTML = newtotal;
			var barang = document.getElementById('totalbarang').innerHTML - cartcontent[this.name];
			barang += this.value * 1;
			document.getElementById('totalbarang').innerHTML = barang;
			cartcontent[this.name] = this.value * 1;
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/ruserba/scripts/php/updatecart.php', true);
			xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
			var postParams = 'cartcontent=' + JSON.stringify(cartcontent);
			xhr.send(postParams);
		}
	}

});