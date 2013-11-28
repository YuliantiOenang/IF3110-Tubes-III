// AJAX Script for Login Authentication
// Dongkol Ampas Bro - 27 October 2013
// @version 1.0.0

function onLoginClick(strUrl, formName) {
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
    
    self.xmlHttpRequest.send(getString(formName)); // Melakukan proses pengiriman POST
}

function getString(formName) {
    var form = document.forms[formName]; // Mendapat form dari dokumen
    var qstr = "";
    
    function getElement(name, value) { // Mendapat nilai-nilai dari form
        qstr += (qstr.length > 0 ? "&" : "")
            + escape(name).replace(/\+/g, "%2B") + "="
            + escape(value ? value : "").replace(/\+/g, "%2B");
    }
    
    var elementArray = form.elements;

    for (var i = 0; i < elementArray.length; i++) {
        var element = elementArray[i];
        var elementType = element.type.toUpperCase();
        var elementName = element.name;
        
        if (elementName) {
            if (elementType == "TEXT" || elementType == "PASSWORD") {
                getElement(elementName, element.value);
            }
        }
    }

    return qstr;
}