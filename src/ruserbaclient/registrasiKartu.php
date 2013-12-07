<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
<link href="css/date.css" type="text/css" rel="stylesheet">

<form onsubmit="credit(); return false;" method="POST" id="form_credit">
	<div id="addcreditcardcontent" class="basiccontent register_div">
		<h1 class="header">Registrasi Kartu Kredit</h1>
		<div class="per_form">
			<label>Card Number*</label>
			<input type="text" id="card_number" value="" name="card_number"><br>
		</div>
		<div class="per_form">
			<label>Name*</label>
			<input type="text" value="" id="name_of_card" name="name_of_card"><br>
		</div>
		<div class="per_form">
			<label>Expired Date (YYYY-MM-DD)</label>
			<input type="text" id="expired_date" name="expired_date" value=""><br>
		</div>
		<button class="btn small full" type="submit">Submit</button>
		<a class="btn small full" href="profil.php" type="button">Skip</a><br>
	</div>
</form>
<script type="text/javascript" src="js/date.js"></script>
<script src="js/credit.js"></script>
<script>
	var server = "";
</script>
			</div>
		</div><div class="calendar" style="display: none; position: absolute; top: 445px; left: 594px; z-index: 100;"><div class="months"><span class="prev-month"><span class="prevMonth"><</span></span><span class="next-month"><span class="nextMonth">></span></span><span class="current-month">December 2013</span></div><table><thead><tr class="weekdays"><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td><span class="day">1</span></td><td><span class="day">2</span></td><td><span class="day">3</span></td><td><span class="day">4</span></td><td class="today"><span class="day">5</span></td><td><span class="day">6</span></td><td><span class="day">7</span></td></tr><tr><td><span class="day">8</span></td><td><span class="day">9</span></td><td><span class="day">10</span></td><td><span class="day">11</span></td><td><span class="day">12</span></td><td><span class="day">13</span></td><td><span class="day">14</span></td></tr><tr><td><span class="day">15</span></td><td><span class="day">16</span></td><td><span class="day">17</span></td><td><span class="day">18</span></td><td><span class="day">19</span></td><td><span class="day">20</span></td><td><span class="day">21</span></td></tr><tr><td><span class="day">22</span></td><td><span class="day">23</span></td><td><span class="day">24</span></td><td><span class="day">25</span></td><td><span class="day">26</span></td><td><span class="day">27</span></td><td><span class="day">28</span></td></tr><tr><td><span class="day">29</span></td><td><span class="day">30</span></td><td><span class="day">31</span></td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr></tbody></table></div>
		<?php
require_once('footer.php');
?>
