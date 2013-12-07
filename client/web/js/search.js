window.addEventListener('load', function() {
	var searchform = document.getElementById('searchform');
	var searchinput = document.getElementsByName('searchinput')[0];
	var searchbutton = document.getElementById('searchbutton');

	searchbutton.onclick = function () {
		searchform.onsubmit();
	};

	searchform.onsubmit = function() {
		window.location.href = '/ruserba/search/' + encodeURIComponent(searchinput.value);
		return false;
	}
});