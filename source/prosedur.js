var width = 800;
var height = 400;
var imgAr1 = new Array();
var rImg1 = new Array();
imgAr1[0] = "images/prosedure1.jpg";
imgAr1[1] = "images/prosedure2.jpg";
imgAr1[2] = "images/prosedure3.jpg";
imgAr1[3] = "images/prosedure4.jpg";

for(var j=0; j<imgAr1.length; j++){
	rImg1[j] = new Image();
	rImg1[j].src = imgAr1[j];
}
document.onload = setting();
var slide;
function setting()
{
	slide = document.getElementById('pic');
	slide.scr = imgAr1[0];
	slide.setAttribute("width",width);
	slide.setAttribute("height",height);
}
var picture = 0;
function slideshow(){
	if(picture < imgAr1.length-1){
		picture = picture+1;
		slide.src = imgAr1[picture];
	}
}
function prev(){
	if(picture > 0){
		picture = picture-1;
		slide.src = imgAr1[picture];
	}
}
function start(){
	slide.src = imgAr1[0];
	picture = 0;
}	
function end(){
	slide.src = imgAr1[imgAr1.length-1];
	picture = imgAr1.length-1;
}