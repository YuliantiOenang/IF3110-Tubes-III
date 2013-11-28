// AJAX Script for Credit Card
// Dongkol Ampas Bro - 28 October 2013
// @version 1.0.0

// Validasi ini berdasarkan referensi http://stackoverflow.com/questions/12761922/how-to-validate-credit-cards-and-bank-account
// Panjang angka Credit Card antara 13-19 numerik
// Panjang nama Credit Card maksimal 26 alpha numerik

function onCreditCardCreate(strUrl) {

    if (document.getElementById('card_number').value != "" &&
        document.getElementById('name').value != "" &&
        document.getElementById('expired_date').value != "") { // Menjamin setiap field tidak kosong
            var xmlHttpRequest = false;
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
                    var n = str.indexOf("Success");
                    if (n != -1) {
                       window.location.replace(self.xmlHttpRequest.responseText.substring(n + 9));
                    } else alert(self.xmlHttpRequest.responseText);
                }
            }
            
            
            var submitValue = true;
                
            var params = "submit=" + submitValue + "&card_number=" + document.getElementById('card_number').value
                                                 + "&name=" + document.getElementById('name').value
                                                 + "&expired_date=" + document.getElementById('expired_date').value;                                             
                
            self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
        } else alert("Field * wajib diisi!");

}