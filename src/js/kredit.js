function validation (theForm) {
		var loginfo = getLoginInfo();
		var data = {"cardnumber" : theForm["cardnumber"].value, "expireddate" : theForm["expireddate"].value, "namecard" : theForm["namecard"].value, "id": loginfo.id};
		var callback = function(response) {
			if (response.status == "error") 
				alert(response.raw) ;
			else{
				
				
				alert("Registrasi berhasil");
				
				if(!buying){
					window.location = "index.php";
				}else{
					var callback = function(response){
						if(response.status == "ok"){
							alert("Barang sudah terbeli");
							localStorage.removeItem("shoppingbag");
							window.location = "cart.php";
						}else{
							alert("Barang tidak mencukupi");
						}
					};
					
					commit_buy(callback);
				}
			}
		};
		sendAjax(data, "submit_kredit.php", callback);
	}
	
	function skip(){
		window.location = "index.php";
	}