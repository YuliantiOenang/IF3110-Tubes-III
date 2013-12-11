/**
 * 
 */

var active = false;
var ids = null;
var cat = null;
var name = null;
var pri = null;
var desc = null;
var total = null;

function editbarang(id) {
	if (!active) {
		active = true;
		ids = id;
		cat = document.getElementById("cat"+id).innerHTML;
		name = document.getElementById("name"+id).innerHTML;
		pri = document.getElementById("pri"+id).innerHTML;
		desc = document.getElementById("desc"+id).innerHTML;
		total = document.getElementById("total"+id).innerHTML;
		var c = "<select name=\"category\" id=\"category\">";
		var categories = new Array("Ladies Dress", "Ladies Shoes", "Men Shirt", "Men Shoes", "Men Hat");
		for (var i = 0; i < 5; i++) {
			if (cat == categories[i]) {
				c += "<option value=\"" + (parseInt(i)+parseInt(1)) +"\" selected>"+ categories[i] +"</option>";
			} else {
				c += "<option value=\"" + (parseInt(i)+parseInt(1)) +"\">"+ categories[i] +"</option>";
			}
		}
		c += "</select>";
		document.getElementById("cat"+id).innerHTML = c;
		document.getElementById("name"+id).innerHTML = "<input id=\"name\" name=\"name\" type=\"text\" value=\"" + document.getElementById("name"+id).innerHTML + "\" required/>";
		document.getElementById("pri"+id).innerHTML = "<input id=\"price\" name=\"price\" type=\"number\" value=\"" + document.getElementById("pri"+id).innerHTML + "\" required/>";
		document.getElementById("desc"+id).innerHTML = "<textarea id=\"description\" name=\"description\" required>" + document.getElementById("desc"+id).innerHTML + "</textarea>";
		document.getElementById("total"+id).innerHTML = "<input id=\"amount\" name=\"amount\" type=\"number\" value=\"" + document.getElementById("total"+id).innerHTML + "\" required/>";
		document.getElementById("edit"+id).innerHTML = "<button onclick=\"feditbarang(" + id + ")\">proceed</button><button onclick=\"ceditbarang(" + id + ")\">cancel</button>";
	}
}

function feditbarang(id) {
	if (document.getElementById("name").value != "" && document.getElementById("price").value != "" && document.getElementById("description").value != "" && document.getElementById("amount").value != "") {
		var doc = document.getElementById("category");
		var param = "action=update" + "&id=" + id + "&category=" + doc.options[doc.selectedIndex].value + "&name=" + document.getElementById("name").value + "&price=" + document.getElementById("price").value + "&description=" + document.getElementById("description").value + "&amount=" + document.getElementById("amount").value;
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("POST", "admin", true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText.search("success") >= 0) {
					document.getElementById("cat"+id).innerHTML = doc.options[doc.selectedIndex].text;
					document.getElementById("name"+id).innerHTML = document.getElementById("name").value;
					document.getElementById("pri"+id).innerHTML = document.getElementById("price").value;
					document.getElementById("desc"+id).innerHTML = document.getElementById("description").value;
					document.getElementById("total"+id).innerHTML = document.getElementById("amount").value;
					document.getElementById("edit"+id).innerHTML = "<button onclick=\"editbarang(" + id + ")\">edit</button>";
					active = false;
					ids = null;
					cat = null;
					name = null;
					pri = null;
					desc = null;
					total = null;
				}
			}
		};
		xmlhttp.send(param);
	}
}

function ceditbarang(id) {
	document.getElementById("cat"+id).innerHTML = cat;
	document.getElementById("name"+id).innerHTML = name;
	document.getElementById("pri"+id).innerHTML = pri;
	document.getElementById("desc"+id).innerHTML = desc;
	document.getElementById("total"+id).innerHTML = total;
	document.getElementById("edit"+id).innerHTML = "<button onclick=\"editbarang(" + id + ")\">edit</button>";
	active = false;
	ids = null;
	cat = null;
	name = null;
	pri = null;
	desc = null;
	total = null;
}

function confirmdelete(name) {
	return confirm("are you sure to delete " + name + "?");
}