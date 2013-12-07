// DEPENDENCIES: transaction.js
var page = 0; var loadable = true; var loading = false;

document.addEventListener('scroll', function (event) {
	if (document.body.scrollHeight == document.body.scrollTop + window.innerHeight) {
		nextPage()
	}
});

function changeSortBy(sortcat){
	sortby = sortcat;
	refreshCategoryPage();
}

function changeOrder(ord){
	order = ord;
	refreshCategoryPage();
}

function refreshCategoryPage(){
	document.getElementById("cattable").innerHTML = "";
	loadable = true;
	page = -1;
	
	nextPage();
}

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
	var data = {"action": "category", "cat": category, "page": page, "sort": sortby, "order": order};
	
	
	var callback = function(response){
		loading = false;
		
		if(response.status == "ok"){
			var cattable = document.getElementById("cattable");
		
			for (var i = 0; i < response.barang.length; i++){
				var item = response.barang[i];
				
				var row = createRow(item.id, item.nama, item.harga, item.deskripsi);
				cattable.innerHTML += row;
			}
			
			clearInfo();
		}else{
			loadable = false;
			setInfo("semua barang sudah ditampilkan");
		}
	};
	
	loading = true;
	
	sendAjax(data, "category.php", callback);
}

function createRow(id, nama, harga, deskripsi){
	var s = '<div class="row rowbarang">';
	s+='<div class="cell33 imgcell" ><img class="imgbarang" src="image/' + id + '.jpg" /></div>';
	s+='<div class="cell66"><div class="table">';
	s+='<div class="row title"><a href="barang.php?id=' + id + '" />' + nama + '</a></div>';
	s+='<div class="row">Rp. ' + formatCurrency(harga) + '</div>';
	s+='<div class="row">' + deskripsi + '</div>';
	s+='<div class="row"><input type="button" value="Tambahkan ke Keranjang" class="main-button-small" onclick="addCart(' + id + ')" /></div>';
	s+='</div></div></div>';
	
	return s;
}
