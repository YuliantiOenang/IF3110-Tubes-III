function validation (theForm) {
	var card = {"card_number" : theForm["cardnumber"].value, "card_date" : theForm["expireddate"].value, "card_name" : theForm["namecard"].value};
		
	loginfo = getLoginInfo();
	user = loginfo.user; token = loginfo.id;
	
	data = {"card" : card, "token": token};
		
	var callback = function(response) {
		if (response.status == "error") 
			alert(response.desc) ;
		else{
			alert("Registrasi berhasil");
			
			if(!buying){
				window.location = "index.php";
			}else{
				var callback1 = function(response){
					if(response.status == "ok"){
						alert("Barang sudah terbeli");
						localStorage.removeItem("shoppingbag");
					}else{
						alert("Barang tidak mencukupi");
					}
					
					window.location = "cart.php";
				};
				
				buy(callback1);
			}
		}
	};
	sendRestAjax("PUT", "user/"+user+"/card", data, callback);
}

	
function skip(){
	window.location = "index.php";
}