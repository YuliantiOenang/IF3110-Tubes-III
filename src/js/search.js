document.addEventListener('scroll', function (event) {
	if (document.body.scrollHeight == document.body.scrollTop + window.innerHeight) {
		nextPage()
	}
});


function setInfo(info){
	infobottom = document.getElementById("infobottom");
	infobottom.classList.add("backgrey");
	infobottom.innerHTML = info;
}

function clearInfo(){
	infobottom = document.getElementById("infobottom");
	infobottom.classList.remove("backgrey");
	infobottom.innerHTML = "";
}

function nextPage(){
	if (loading || !loadable) return;
	
	setInfo("<img class='loading' src='image/loading.gif' /> loading...");
	
	page++;
	var data = {"action": "search", "q": entry, "page": page};
	
	
	var callback = function(response){
		loading = false;
		
		if(response.status == "ok"){
			var cattable = document.getElementById("cattable");
		
			for (var i = 0; i < response.barang.length; i++){
				var item = response.barang[i];
				
				var row = createRow(item.id, item.nama, item.kategori, item.harga, item.deskripsi);
				cattable.innerHTML += row;
			}
			
			clearInfo();
		}else{
			loadable = false;
			setInfo("no more match");
		}
	};
	
	loading = true;
	
	sendAjax(data, "search.php", callback);
}

function createRow(id, nama, kategori, harga, deskripsi){
	var s = '<div class="row rowbarang">';
	s+='<div class="cell33 imgcell" ><img class="imgbarang" src="image/' + id + '.jpg" /></div>';
	s+='<div class="cell66"><div class="table">';
	s+='<div class="row title"><a href="barang.php?id=' + id + '" />' + nama + '</a></div>';
	s+='<div class="row">Kategori: <a href="category.php?cat='+ kategori +'">' + kategori + '</a></div>';
	s+='<div class="row">Rp. ' + formatCurrency(harga) + '</div>';
	s+='<div class="row">' + deskripsi + '</div>';
	s+='<div class="row"><input type="button" value="Tambahkan ke Keranjang" class="main-button-small" onclick="addCart(' + id + ')" /></div>';
	s+='</div></div></div>';
	
	return s;
}