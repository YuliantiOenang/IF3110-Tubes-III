window.addEventListener('load', function() {
	var selectorder = document.getElementById('selectorder');
	var selectsort = document.getElementById('selectsort');

	selectorder.onchange = function() {
		if (selectorder.selectedIndex == 0) {
			if (selectsort.selectedIndex == 0) {
				window.location.href = basePageUrl + '/name/asc';
			}
			else {
				window.location.href = basePageUrl + '/name/desc';
			}
		}
		else {
			if (selectsort.selectedIndex == 0) {
				window.location.href = basePageUrl + '/price/asc';
			}
			else {
				window.location.href = basePageUrl + '/price/desc';
			}
		}
	};

	selectsort.onchange = function() {
		if (selectorder.selectedIndex == 0) {
			if (selectsort.selectedIndex == 0) {
				window.location.href = basePageUrl + '/name/asc';
			}
			else {
				window.location.href = basePageUrl + '/name/desc';
			}
		}
		else {
			if (selectsort.selectedIndex == 0) {
				window.location.href = basePageUrl + '/price/asc';
			}
			else {
				window.location.href = basePageUrl + '/price/desc';
			}
		}
	};

});