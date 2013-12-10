var listcheck = [];

document.addEventListener('scroll', function (event) {
	if (document.body.scrollHeight == document.body.scrollTop + window.innerHeight) {
		nextPage()
	}
});

	
function checkedToList(id){
	if (document.getElementById(id).checked==true) {
		listcheck.push(id);
	} else {
		var index = listcheck.indexOf(id);
		if (index > -1) {
			array.splice(index, 1);
		}
	}
}

function deleteBarang(id){
	if (!confirm("Anda yakin ingin melakukan penghapusan?"))
		return;
	data = { "ids" : [id], "token" : getLoginInfo().id};
	
	callback = function (response) {
		if (response.status=="ok"){
			alert ("Barang (barang-barang) berhasil dihapus)!");
			window.location.reload();
		} else {
			alert (response.desc);
		}
	}

	sendRestAjax("DELETE", "barang", data , callback);
	
}

function deleteBulkBarang(){
	if (!confirm("Anda yakin ingin melakukan penghapusan?"))
			return;
	data = { "ids" : listcheck, "token" : getLoginInfo().id};
	
	callback = function (response) {
		if (response.status=="ok"){
			alert ("Barang (barang-barang) berhasil dihapus)!");
			window.location.reload();
		} else {
			alert (response.desc);
		}
	}
	
	sendRestAjax("DELETE", "barang", data , callback);
	
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
	var data = {"action": "search", "q": entry, "page": page};
	
	
	var callback = function(response){
		loading = false;
		
		if(response.status == "ok"){
			var cattable = document.getElementById("cattable");
		
			for (var i = 0; i < response.barang.length; i++){
				var item = response.barang[i];
				
				var row = createRow(item.id, item.nama, item.kategori, item.jumlah_beli, item.harga, item.deskripsi);
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

function createRow(id, nama, kategori, jml, harga, deskripsi){
	var s = '<div class="row rowbarang">';
	s+='<div class="cell33 imgcell" ><img class="imgbarang" src="' + IMGURL + id + '.jpg" /></div>';
	s+='<div class="cell66"><div class="table">';
	s+='<div class="row title"><a href="admin_detail_barang.php?id=' + id + '" />' + nama + '</a></div>';
	s+='<div class="row">Kategori: <a href="admin_barang.php?cat='+ kategori +'">' + kategori + '</a></div>';
	s+='<div class="row">Rp. ' + formatCurrency(harga) + '</div>';
	s+='<div class="row">Dibeli '+ jml +' kali</div>';
	s+='<div class="row">' + deskripsi + '</div>';
	s+='<div class="rowtools"><input type="checkbox" name="'+ id +'" id="'+ id +'" onclick=checkedToList('+ id +')>'; 
	s+='<a href="edit_barang.php?id='+ id +'"><img src=image/Edit.jpg id="edit"></a>';
	s+='<input type="image" src=image/Delete.png id="delete" onclick="deleteBarang('+ id +')">';
	s+='</div>';
	s+='</div></div></div>';
	
	return s;
}