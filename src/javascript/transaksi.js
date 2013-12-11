	function tempBuy(id_brg,qtty){
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				if((parseInt(shopping_bag[id_brg])+parseInt(qtty))<=(parseInt(xmlhttp.responseText))){
						//alert("Barang berhasil ditambahkan ke keranjang.");
						doInCart(1,id_brg,qtty);
				}
				else
						alert("Pembelian tidak bisa dilakukan. Jumlah barang yang tersisa hanya ada "+(parseInt(xmlhttp.responseText)-parseInt(shopping_bag[id_brg]))+" buah.");
			}
		}
		xmlhttp.open("POST","ajaxbeli.php",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("id="+id_brg+"&qtt="+qtty);
	}

	function initialize_bag(){
		if(localStorage.shoppingbag){
			shopping_bag = JSON.parse(localStorage.shoppingbag);
			generateSideBar(shopping_bag);
		}else{
			for(var i=0;i<=sum_item+1;i++){
				shopping_bag[i]=0;
			}
		}
	}

	function generateSideBar(tab_shopping){
		var xmlhttp;
		var content_sb ="<div><span>NO.</span><span  style='margin-left:10px'>nama brg</span><span  style='margin-left:20px'>qtt</span><span  style='margin-left:10px'>price</span></div>";
		var itt =0;
		var total=0;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				isi = JSON.parse(xmlhttp.responseText);
				if(localStorage.wbduser) localStorage.shoppingbag=JSON.stringify(shopping_bag);				
			for(var k=0;k<isi.length;k++){
					itt++;
					total+=isi[k].dibeli*isi[k].harga;
					content_sb += "<div id=k"+isi[k].id+"><span>"+itt+"</span><span  style='margin-left:20px'>"+isi[k].nama+"</span><span  style='margin-left:20px'>"+isi[k].dibeli+"</span><span  style='margin-left:10px'>"+isi[k].harga+"</span><a href='javascript:doInCart(0,"+isi[k].id+",0)'><img src='images/cancel.png' width=15 height=15/></a></div>";	
			}
			content_sb += "<hr/><div><pre>Total     :       Rp "+total+",-</pre></div><input type='button' value='Bayar Transaksi' id='deal' onclick='cekkartu()'>";
				document.getElementById("s_bar").innerHTML=content_sb;
			}else{
				//alert("PIKACHU!");
				//document.getElementById("indikator").innerHTML="<img src='images/loader.gif'><p>Memuat barang-barang yang lain...</p>";
			}
		}
		xmlhttp.open("POST","fillsidebar.php",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("data="+JSON.stringify(tab_shopping));
	}

	function buy(){
		var r=confirm("Anda yakin mau memroses transaksi?");
		if (r==true)
		  {
		var report ="";
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				alert("LOMPAT KE ATAP, TRANSAKSI BERHASIL!");
				document.getElementById("s_bar").innerHTML="Silakan pilih barang belanjaan Anda! :)";
				localStorage.removeItem("shoppingbag");
				initialize_bag();
			}
		}
		xmlhttp.open("POST","buyprocess.php",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("data="+JSON.stringify(shopping_bag)+"&username="+localStorage.wbduser);	
	}
	}

	function doInCart(type,id,qtty){
		if(type==0){//cancel
			shopping_bag[id]=0;
			isi.splice(id,1);
			var elmt = document.getElementById("k"+id);
			elmt.innerHTML ="";
		}else if(type==1)
			shopping_bag[id]+=parseInt(qtty);
		generateSideBar(shopping_bag);
	}
	function cekkartu(){
	var xmlhttp;
	if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			if(xmlhttp.responseText=="error"){
				alert("Gagal mengambil data kartu kredit dari database.");
			}else if(xmlhttp.responseText=="notregistered"){
				window.location="registercardform.php";
			}else{
				buy();
			}
		}
	}
	xmlhttp.open("POST","cekkartukredit.php",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("username="+localStorage.wbduser);
	}
