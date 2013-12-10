//var REST_URL = "http://localhost/IF3110-Tubes-III/src/service/rest/";
var REST_URL = "http://loghorizon.ap01.aws.af.cm/rest/";

function loadBase64Image(formid, callback){
	var files = document.getElementById(formid).files;
	if (files.length > 0){
		var file = files[0];

		var reader = new FileReader();

		reader.onload = function(e){
			if(callback!=null) callback(e.target.result);
		};

		reader.readAsDataURL(file);
	}
}

function sendRestAjax(method, resource, data, callback){
	target = REST_URL + resource;
	var request = new XMLHttpRequest();
	
	request.onload = function(){
		if (callback !== null){
			var response;
			try{
				response = JSON.parse(this.responseText);
			}catch(err){
				response = {"status" : "error", "desc" : "Parse Error", "raw" : this.responseText};
			}
			
			callback(response);
		}			
	}
	
	if (method == "GET"){
		request.open(method, target + jsonToUriEncoded(data), true);
		request.send();
	}else{
		request.open(method, target, true);
		request.send(JSON.stringify(data));
	}
}

function jsonToUriEncoded(obj) {
	// tidak bisa untuk json dengan nested object / array

	var parts = [];
	for (var key in obj) {
		if (obj.hasOwnProperty(key)) {
			if (typeof obj[key] === 'object')
				parts.push(encodeURIComponent(key) + '=' + encodeURIComponent(JSON.stringify(obj[key])));
			else
				parts.push(encodeURIComponent(key) + '=' + encodeURIComponent(obj[key]));
		}
	}
	return "?" + parts.join('&');
}

function sendAjax(data, target, callback){
	/* mengirim ajax ke target
	 * data = data yg mau dikirim, bentuknya json
	 * target = alamat
	 * callback = fungsi yg dipanggil kalo udah dibales. format fungsinya:
	 * 			  function callback(response), dengan response adalah balasan dari server
	 * 			  dalam bentuk json	
	 */
	  
	var request = new XMLHttpRequest();
	request.open("POST", target, true);
	request.onload = function(){
		if (callback!=null){
			try{
				callback(JSON.parse(this.responseText));
			}catch(err){
				callback({"status":"error", "details": err, "raw": this.responseText});
			}
			
		}
	}
	
	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	request.send("ajax=" + JSON.stringify(data));
}