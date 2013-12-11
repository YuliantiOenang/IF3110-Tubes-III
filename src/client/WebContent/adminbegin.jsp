<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
        <title>Calvin Salvy</title>
        <% out.print("<script>var server = '" + request.getContextPath() + "';</script>"); %>
        <link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/css/style.css' />
        <script type="text/javascript">
                function hasClass(ele,cls) {
                        return ele.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'));
                }
                
                function addClass(ele,cls) {
                        if (!this.hasClass(ele,cls)) ele.className += " "+cls;
                }
                
                function removeClass(ele,cls) {
                        if (hasClass(ele,cls)) {
                        var reg = new RegExp('(\\s|^)'+cls+'(\\s|$)');
                        ele.className=ele.className.replace(reg,' ');
                        }
                }
                function fitimg(obj,width,height,xfit,yfit,overlay)
                {
                        var objheight = obj.offsetHeight;
                        var objwidth = obj.offsetWidth;
                        var screen = objheight/objwidth;
                        var fit = height/width;
                        if (Math.abs(screen-fit)<=0.1) {
                                obj.width = width;
                                obj.height = height;
                        }
                        else if (((screen<fit)&&overlay)||((screen>fit)&&!overlay)){
                                        obj.height = height;
                                        if (xfit) {
                                                obj.width = ((height*1.0)/(screen*1.0));
                                                obj.style.marginLeft = (((1.0*width)-((1.0*height)/(1.0*screen)))/2).toString()+"px";
                                        }
                                        else {
                                                obj.width = width;
                                        }
                                }
                        else {
                                        obj.width = width;
                                        if (yfit) {
                                                obj.height = (width*screen);
                                                obj.style.marginTop = ((height-(width*screen))/2).toString()+"px";
                                        }
                                        else {
                                                obj.height = height;
                                        }
                        }
                }
                function showLogin() {
                        document.getElementById('login_cont').style.opacity = 0;
                        document.getElementById('login_cont').style.top = "0px";
                        document.getElementById('login_username').focus();
                        var x,aa,bb;
                        aa = 0;
                        bb = 0;
                        for (x=0;x<=11;x++){
                                setTimeout(function(){
                                        document.getElementById('login_cont').style.opacity = 0.1*aa;
                                        aa++;
                                }, (50*(bb+1)));
                                bb++;
                        }
                }
                function hideLogin() {
                        document.getElementById('login_cont').style.opacity = 1;
                        var x,aa,bb;
                        aa = 0;
                        bb = 0;
                        for (x=0;x<=11;x++){
                                setTimeout(function(){
                                        document.getElementById('login_cont').style.opacity = 1-(0.1*aa);
                                        if (aa>=10) document.getElementById('login_cont').style.top = "-100%";
                                        aa++;
                                }, (50*(bb+1)));
                                bb++;
                        }
                }
        </script>
</head>
<body>
<!-- if (isset($effect)&&$effect) {?> -->
<%
if (request.getAttribute("effect")!=null) {
	out.print("<img class='loader' id='starter' src='"+request.getContextPath()+"/img/site/logo_b.png'></img>");
	out.print("<div class='prolog' id='starter2'><p>We are here to provide you with a brand new aura in our country through fashion, creativity, and innovative designs with world class quality. We always provide the best for our consumers by giving the best quality of our products. We will bring to you products made out of best chosen materials. We collaborate with the experts who have years and years of experience in the fashion and design industry. We will excite you with our new and creative concept to be more fashionable. And we guarantee you no dissatisfaction because we are sure that you will be satisfied at any cost whatsoever.<br/><br/>Best Regards,<br/>Calvin Valentino & Salvy Reynalv</p></div>");
	out.print("<a href='/index/home'><img class='trans' id='trans' src='"+request.getContextPath()+"/img/logo.png'></img></a>");
	out.print("<div class='background' id='content'>");		
}
%>
<!-- }// endif -->
        <div class='conctr'>
                        <div id='content_frame' name='page' onLoad="RefreshCartandShow()">