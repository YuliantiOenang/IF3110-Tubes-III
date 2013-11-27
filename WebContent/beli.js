/**
 * 
 */
function verBeli(){
				var creditid = document.forms['beli_barang']['creditid'].value;
				var data = "creditid="+creditid;
				var barang_error = document.getElementById("barang_error");
				if(creditid=="asd"){
					window.location="registercreditcard.jsp";
				}
				else{
					if(window.XMLHttpRequest){
						xmlhttp = new XMLHttpRequest();
					}
					else{
						xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
					}
					xmlhttp.onreadystatechange=function(){
						if(xmlhttp.readyState==4&&xmlhttp.status==200){
							barang_error.innerHTML = xmlhttp.responseText;

							if(barang_error.innerHTML==""){
								//Handle SESSION & LOCAL STORAGE
								window.location="shoppingbag.jsp";
							}
						}
					};
					xmlhttp.open("POST","beli",true);
					xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xmlhttp.send(data);
				}
}