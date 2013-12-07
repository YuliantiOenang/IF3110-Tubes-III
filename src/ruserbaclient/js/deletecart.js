function deleteCart(id)
{
	var cookieTop = parseInt(getCookie('topCart'));
	var offs = id;
	while (offs < cookieTop)
	{
		setCookie(offs,getCookie(offs+1));
		offs++;
	}
	cookieTop--;
	setCookie('topCart',cookieTop);
	window.location.href = "cart.php";
}
