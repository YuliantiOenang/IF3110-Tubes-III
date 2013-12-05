// AJAX Script for Validation
// Dongkol Ampas Bro - 28 October 2013
// @version 1.0.1

function ajaxValidation(method, value, target) {
    var xmlHttpRequest = false;
    var self = this;
    
    if (window.XMLHttpRequest) { // jika menggunakan browser selain IE
        self.xmlHttpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // jika menggunakan browser IE
        self.xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    self.xmlHttpRequest.open('POST', '../user/validation', true); // URL tempat POST akan di-directkan
    self.xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    self.xmlHttpRequest.onreadystatechange = function() {
        if (self.xmlHttpRequest.readyState == 4) { // Menunggu sampai POST selesai dilakukan
            // Finish
            var str = self.xmlHttpRequest.responseText;
            var n = str.indexOf("Success");
            if (n != -1) {
                updatePage("", target);
            } else {
                var m = str.indexOf("Failure");
                updatePage(self.xmlHttpRequest.responseText.substring(m + 9), target);               
            }
        }
    }
    
    var params = "method=" + method + "&value=" + encodeURIComponent(value);
    
    if (method == "checkEmail" || method == "checkUsername" || method == "checkConfirm") {
        var password = document.getElementById('password').value;
        if (password.length <= 0) params += "&valueTwo=" + "''";
        else params += "&valueTwo=" + encodeURIComponent(password);
    }
    
    if (method == "checkPassword") {
        var email = document.getElementById('email').value;
        if (email.length <= 0) params += "&valueTwo=" + "''";
        else params += "&valueTwo=" + encodeURIComponent(email);
        
        var username = document.getElementById('username').value;
        if (username.length <= 0) params += "&valueThree=" + "''";
        else params += "&valueThree=" + encodeURIComponent(username);
    }
    
    if (value == "") {
        updatePage("", target);
    } else {
        self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
    }
}

function updatePage(str, target) {
    document.getElementById(target + "_response").innerHTML = str;
    refreshCheck();
}

function onRegister(strUrl) {
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
            
        var params = "submit=" + submitValue + "&email=" + document.getElementById('email').value
                                             + "&username=" + document.getElementById('username').value
                                             + "&password=" + document.getElementById('password').value
                                             + "&nama_lengkap=" + document.getElementById('nama_lengkap').value
                                             + "&HP=" + document.getElementById('HP').value
                                             + "&alamat=" + document.getElementById('alamat').value
                                             + "&provinsi=" + document.getElementById('provinsi').value
                                             + "&kota=" + document.getElementById('kota').value
                                             + "&kodepos=" + document.getElementById('kodepos').value;                                            
            
        self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
}

function refreshCheck() {

    document.getElementById("submit").disabled = true; 
    
    if (document.getElementById('email').value != "" &&
    document.getElementById('username').value != "" &&
    document.getElementById('password').value != "" &&
    document.getElementById('confirm').value != "" &&
    document.getElementById('nama_lengkap').value != "") { // Menjamin setiap field tidak kosong
    
        if (document.getElementById('email_response').innerHTML.trim() == "" &&
        document.getElementById('username_response').innerHTML.trim() == "" &&
        document.getElementById('password_response').innerHTML.trim() == "" &&
        document.getElementById('confirm_response').innerHTML.trim() == "" &&
        document.getElementById('nama_lengkap_response').innerHTML.trim() == "") { // Jika semua hasil valid
            document.getElementById("submit").disabled = false; 
        }
    }
}

function onChange(strUrl) {

    if (document.getElementById('password').value != "" &&
    document.getElementById('confirm').value != "" &&
    document.getElementById('nama_lengkap').value != "") { // Menjamin setiap field tidak kosong
    
        if (document.getElementById('password_response').innerHTML.trim() == "" &&
        document.getElementById('confirm_response').innerHTML.trim() == "" &&
        document.getElementById('nama_lengkap_response').innerHTML.trim() == "") { // Jika semua hasil valid
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
                    
                var params = "submit=" + submitValue + "&password=" + document.getElementById('password').value
                                                     + "&nama_lengkap=" + document.getElementById('nama_lengkap').value
                                                     + "&HP=" + document.getElementById('HP').value
                                                     + "&alamat=" + document.getElementById('alamat').value
                                                     + "&provinsi=" + document.getElementById('provinsi').value
                                                     + "&kota=" + document.getElementById('kota').value
                                                     + "&kodepos=" + document.getElementById('kodepos').value;                                            

                self.xmlHttpRequest.send(params); // Melakukan proses pengiriman POST
        }

    } else alert("Field * wajib diisi!");
}