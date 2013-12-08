// AJAX Script for Shop
// 26 November 2013
// @version 1.0.1

function $(id) { return document.getElementById(id); }
function get(elem) { return parseFloat($(elem).innerHTML) || 0; }

function onAddToCart(strUrl, id) {
        var self = this;
        if (window.XMLHttpRequest) { // jika menggunakan browser selain IE
            self.xmlHttpRequest = new XMLHttpRequest();
        } else if (window.ActiveXObject) { // jika menggunakan browser IE
            self.xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
        self.xmlHttpRequest.open('POST', strUrl, true); // URL tempat POST akan di-directkan
        self.xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        self.xmlHttpRequest.onreadystatechange = function() {
            if (self.xmlHttpRequest.readyState == 4) { // Menunggu sampai POST selesai dilakukan
                var str = self.xmlHttpRequest.responseText;
                
                var m = str.indexOf("Redirect");
                if (m != -1) {
                     window.location.replace(self.xmlHttpRequest.responseText.substring(m + 10));
                    exit();
                }
                
                var n = str.indexOf("Success");

                alert(self.xmlHttpRequest.responseText);
                if (n != -1) {
                   var newValue = get('jumlah_barang_' + id) * 1 - parseInt(document.getElementById('qty_' + id).value);
                   document.getElementById('jumlah_barang_' + id).innerHTML = newValue;
                   document.getElementById('qty_' + id).value = 0;
                   document.getElementById('deskripsi_tambahan').value = "";
                }
                
            }
        };

        var submitValue = true;
        var params;
        if (document.getElementById('deskripsi_tambahan').value.trim() != "") {
            params = "submit=" + submitValue + "&id_barang=" + id + "&qty=" + document.getElementById('qty_' + id).value
                    + "&deskripsi_tambahan=" + document.getElementById('deskripsi_tambahan').value.trim();    
        } else {
            params = "submit=" + submitValue + "&id_barang=" + id + "&qty=" + document.getElementById('qty_' + id).value;    
        }               

        self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
}

function onUpdateCart(strUrl, id) {
        var self = this;
            
        if (window.XMLHttpRequest) { // jika menggunakan browser selain IE
            self.xmlHttpRequest = new XMLHttpRequest();
        } else if (window.ActiveXObject) { // jika menggunakan browser IE
            self.xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }
        self.xmlHttpRequest.open('POST', strUrl, true); // URL tempat POST akan di-directkan
        self.xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        self.xmlHttpRequest.onreadystatechange = function() {
            if (self.xmlHttpRequest.readyState == 4) { // Menunggu sampai POST selesai dilakukan
                var str = self.xmlHttpRequest.responseText;
                
                var m = str.indexOf("Redirect");
                if (m != -1) {
                    window.location.replace(self.xmlHttpRequest.responseText.substring(m + 10));
                    exit();
                }
                
                var n = str.indexOf("Success");
                
                if (n != -1) {
                	var differences = parseInt(self.xmlHttpRequest.responseText.substring(n + 9));
                	
                	var newValue1 = get('harga_' + id) * 1 + differences; // update single price
                	var newValue2 = get('total_harga') * 1 + differences; // update total_harga
                	
                    document.getElementById('harga_' + id).innerHTML = newValue1;
                    document.getElementById('total_harga').innerHTML = newValue2;
                } else {
                   	 var o = str.indexOf("Failure");
                     alert(self.xmlHttpRequest.responseText);
                     // revert back
                     document.getElementById("qty_" + id).value = parseInt(self.xmlHttpRequest.responseText.substring(o + 88));
                }
                
            }
        };
        
        var submitValue = true;
        var params = "submit=" + submitValue + "&id=" + id + "&qty=" + document.getElementById('qty_' + id).value;                  

        self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
}