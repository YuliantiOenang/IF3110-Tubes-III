// DEPENDENCIES: transaction.js
var page = 0; var loadable = true; var loading = false;	var listcheck = [];

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

function deleteBarangDetail(category, id){
	if (!confirm("Anda yakin ingin melakukan penghapusan?"))
		return;
	data = { "ids" : [id], "token" : getLoginInfo().id};
	
	callback = function (response) {
		if (response.status=="ok"){
			alert ("Barang (barang-barang) berhasil dihapus)!");
			window.location = "admin_barang.php?cat="+category;
		} else {
			alert (response.desc);
		}
	}

	sendRestAjax("DELETE", "barang", data , callback);	
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
	s+='<div class="cell33 imgcell" ><img class="imgbarang" src="' + IMGURL + id + '.jpg" /></div>';
	s+='<div class="cell66"><div class="table">';
	s+='<div class="row title"><a href="admin_detail_barang.php?id=' + id + '" />' + nama + '</a></div>';
	s+='<div class="row">Rp. ' + formatCurrency(harga) + '</div>';
	s+='<div class="row">' + deskripsi + '</div>';
	s+='<div class="rowtools"><input type="checkbox" name="'+ id +'" id="'+ id +'">'; 
	s+='<a href="edit_barang.php?id='+ id +'"><img src=image/Edit.jpg id="edit"></a>';
	s+='<input type="image" src=image/Delete.png id="delete" onclick="">';
	s+='</div></div></div>';
	s+='</div>';
	s+='</div></div></div>';
	
	return s;
}
