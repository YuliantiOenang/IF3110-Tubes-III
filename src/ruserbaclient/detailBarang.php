<?php
	require_once('header.php');
?>
			<div onload="RefreshCartandShow()" id="content_frame">
				

<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>

<script src="js/detailBarang.js"></script>
<img src="img/titik.png" onload="detailBarang('<?=URLService;?>','<?=$_GET['id'];?>')">
<div id="kontenDetailBarang"></div>
<script src="js/validasiBarang.js"></script>
<script>
	var server = "";
</script>


			</div>
		</div>
		<?php
require_once('footer.php');
?>
