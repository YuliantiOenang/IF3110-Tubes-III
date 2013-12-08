var d = document; 
function showhide(id,event){
	if(event=='hide'){ d.getElementById(id).style.display = 'none'; }
	else if(event=='show'){ d.getElementById(id).style.display = ''; }
}
/* ANIMATE POPUP BOX v.3.5 (Updated on 24 October 2013)
   this javascript originally created by Taufik on April 2009
   Allright Reserved
*/
ANIMATEPOPUPBOX = {
	mbox_w: 0,
	mbox_h: 0,
	mbox_fade: 100,
	mbox_name: '',
	mbox_head: '',
	delay: 10,
	win_w: screen.availWidth,
	win_h: screen.availHeight,
	animatemboxw: function(){
		mbox_left=(ANIMATEPOPUPBOX.win_w-ANIMATEPOPUPBOX.mbox_w)/2;
		mbox_top=(ANIMATEPOPUPBOX.win_h-ANIMATEPOPUPBOX.mbox_h)/2-100;
		d.getElementById("fade_mbox").style.top=mbox_top+"px";
		d.getElementById("mbox").style.top=mbox_top+"px";
		ANIMATEPOPUPBOX.mbox_w+=ANIMATEPOPUPBOX.delay;
		showhide("fade_mbox","show");
		d.getElementById("fade_mbox").style.left=mbox_left+"px";
		d.getElementById("mbox").style.left=mbox_left+"px";
		d.getElementById("fade_mbox").style.width=ANIMATEPOPUPBOX.mbox_w+"px";
		if(ANIMATEPOPUPBOX.mbox_w<300){ setTimeout("ANIMATEPOPUPBOX.animatemboxw()",10); } else { setTimeout("ANIMATEPOPUPBOX.animatemboxh()",50); }
	},
	animatemboxh: function(){
		mbox_top=(ANIMATEPOPUPBOX.win_h-ANIMATEPOPUPBOX.mbox_h)/2-100;
		d.getElementById("fade_mbox").style.top=mbox_top+"px";
		d.getElementById("mbox").style.top=mbox_top+"px";
		ANIMATEPOPUPBOX.mbox_h+=ANIMATEPOPUPBOX.delay;
		d.getElementById("fade_mbox").style.height=ANIMATEPOPUPBOX.mbox_h+"px";
		if(ANIMATEPOPUPBOX.mbox_h<200){ setTimeout("ANIMATEPOPUPBOX.animatemboxh()",10); } else { setTimeout("ANIMATEPOPUPBOX.faderbox()",50); }
	},
	faderbox: function(){
		ANIMATEPOPUPBOX.mbox_fade-=10;
		d.getElementById("fade_mbox").style.filter="alpha(opacity="+ANIMATEPOPUPBOX.mbox_fade+")";
		d.getElementById("fade_mbox").style.opacity=ANIMATEPOPUPBOX.mbox_fade/100;
		showhide("mbox","show");
		d.getElementById("mbox").innerHTML="<div id='mbox_header'>"+ANIMATEPOPUPBOX.mbox_head+"<span style='float:right'><a href='javascript:ANIMATEPOPUPBOX.closembox()'>CLOSE [ X ]</a></span></div>";
		if(ANIMATEPOPUPBOX.mbox_fade>0){ setTimeout("ANIMATEPOPUPBOX.faderbox()",100); } else { 
			showhide("fade_mbox","hide");
			d.getElementById("mbox").innerHTML+=d.getElementById(ANIMATEPOPUPBOX.mbox_name).innerHTML;
		}
	},
	showbox: function(id,head){
		ANIMATEPOPUPBOX.mbox_name=id;
		ANIMATEPOPUPBOX.mbox_head=head;
		showhide("back_mbox","show");
		setTimeout("ANIMATEPOPUPBOX.animatemboxw()",500);
	},
	closembox: function(){
		ANIMATEPOPUPBOX.mbox_w=10;
		ANIMATEPOPUPBOX.mbox_h=10;
		ANIMATEPOPUPBOX.mbox_fade=100;
		d.getElementById("mbox").innerHTML="";
		showhide("mbox","hide");
		d.getElementById("fade_mbox").style.filter="alpha(opacity=100)";
		d.getElementById("fade_mbox").style.opacity="1";
		d.getElementById("fade_mbox").style.width="10px";
		d.getElementById("fade_mbox").style.height="10px";
		d.getElementById("fade_mbox").style.left="0px";
		showhide("back_mbox","hide");
	}
};
function searchsuggest(text)
{
	var xmlhttp;
	var temp = ""+text;
	if (temp.length==0)
	{ 
		document.getElementById("cariyu").innerHTML="";
		return;
	}
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("cariyu").innerHTML=xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET","search?cari="+text+"&suggest=true",true);
	xmlhttp.send();
}
var spage=1;
var stext;
function search(text)
{
	var xmlhttp;
	if (text.length==0){ return; }
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			document.getElementById("featured").innerHTML+=xmlhttp.responseText;
			document.getElementById("cariyu").innerHTML="";
		}
	};
	xmlhttp.open("GET","search?cari="+text+"&suggest=false&page="+spage,true);
	xmlhttp.send();
}
function auth(user,pass){
	var xmlhttp;
	if (user.length==0 ||pass.length==0)
	{	 
		//document.getElementById("menubar").innerHTML+="";
		return;
	}
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange=function()
	{
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			if(xmlhttp.responseText=="0"){
				ANIMATEPOPUPBOX.closembox();
				localStorage.wbduser = user;
				localStorage.wbdlogintime=new Date().getTime();
				var s = "<li><a href=\"profile.jsp\">Welcome "+localStorage.wbduser+"!</a></li>";
				s += "<li><a href=\"index.jsp\" onclick=\"javascript:localStorage.removeItem('wbduser');localStorage.removeItem('wbdlogintime');localStorage.removeItem('shoppingbag');\">Logout</a></li>";
				document.getElementById("log").innerHTML=s;
				document.getElementById("loginbutton").innerHTML='<input type="button" value="Login" onclick="auth(username.value,password.value)"> <a href="registerform.jsp">Daftar baru!</a>';
			}else if(xmlhttp.responseText=="1"){
				document.getElementById("errorInfo").innerHTML='<img src="images/unlike.png" width="15" height="15"/>Invalid username passowrd!';
				document.getElementById("loginbutton").innerHTML='<input type="button" value="Login" onclick="auth(username.value,password.value)"> <a href="registerform.jsp">Daftar baru!</a>';
			}else{
				ANIMATEPOPUPBOX.closembox();
				localStorage.wbduser = user;
				localStorage.wbdlogintime=new Date().getTime();
				window.location="adminbarang.jsp";
			}
		}else{
			document.getElementById("loginbutton").innerHTML='<img src="images/ope-loader.gif"/>Logging in...';
		}
	};
	xmlhttp.open("POST","authentication",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("username="+user+"&password="+pass);
}
if(typeof(Storage)!=="undefined"){
	if(localStorage.wbduser && localStorage.wbdlogintime){
		if(hitunghari(Number(localStorage.wbdlogintime),new Date().getTime())<=30){
			var s = "<li><a href=\"profile.jsp\">Welcome "+localStorage.wbduser+"!</a></li>";
			s += "<li><a href=\"index.jsp\" onclick=\"javascript:localStorage.removeItem('wbduser');localStorage.removeItem('wbdlogintime');localStorage.removeItem('shoppingbag');\">Logout</a></li>";
			document.getElementById("log").innerHTML=s;
		}else{
			alert("Waktu login kamu sudah lebih dari 30 hari.\nSilahkan login ulang");
			localStorage.removeItem('wbduser');
			localStorage.removeItem('wbduserlogin');
			localStorage.removeItem('shoppingbag');
			window.location.href="../RuSerBa/index.jsp";
		}
	}else{
		var s = "<li><a href=\"javascript:ANIMATEPOPUPBOX.showbox('userlogin','User Login');\">Login</a></li>";
		s += "<li><a href=\"registerform.jsp\">Daftar</a></li>";
		document.getElementById("log").innerHTML=s;
	}
}else{
	document.getElementById("menubar").innerHTML="Maaf, browser kamu tidak support Web Storage sehingga informasi username tidak dapat disimpan...";
}
function hitunghari(timestamp1,timestamp2){
    var difference = timestamp2 - timestamp1;
    var daysDifference = Math.floor(difference/1000/60/60/24);
    return daysDifference;
}
function resetsuggest(){
	setTimeout("document.getElementById('cariyu').innerHTML='';",200);
}
function resetsearch(){
	spage=1;
	document.getElementById('featured').innerHTML='';
}
window.onscroll = function() {
	if ((window.innerHeight + window.scrollY) >= document.body.offsetHeight) {
		if(stext!=null){
			spage++;
			search(stext);
			alert(spage);
		}
	}
};