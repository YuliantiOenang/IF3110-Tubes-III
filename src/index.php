<?php include "header.php";?>
<?php include "sidebar.php";?>
<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
<article id="featured" class="body">
	<h2>Most Wanted Products</h2>
	<div id="slideshow">
			<label class="arrows" id="arrow-1" onclick="autoPlaySlide.slidetoleft();"><</label>
			<label class="arrows" id="arrow-2" onclick="autoPlaySlide.slidetoright();">></label>
			<div id="slideshow-inner">
				<ul id="myslide">
				<?php
				//meminta daftar barang dengan REST
				$service_url = 'http://wbd3pusheen.ap01.aws.af.cm/restslide.php';
				$curl = curl_init($service_url);
				curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
				$curl_response = curl_exec($curl);
				if ($curl_response === false) {
					$info = curl_getinfo($curl);
					curl_close($curl);
					die('error occured during curl exec. Additioanl info: ' . var_export($info));
				}
				curl_close($curl);
				$decoded = $curl_response;
				echo $decoded;
				?>
				</ul></div></div>
	</article><!-- /#featured -->
<script>
autoPlaySlide = {
	delay:3000,
	geser:0,
	counter:0,
	i:1,
	init: function(){
		document.getElementById("myslide").style.width="1500%";
	},
	play: function(){
		document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";
		if(autoPlaySlide.counter==0){
			if(autoPlaySlide.i==15){ 
				autoPlaySlide.counter=1; 
				autoPlaySlide.geser+=100; 
			}else{ autoPlaySlide.geser-=100; }
		}else{
			if(autoPlaySlide.i==1){ 
				autoPlaySlide.counter=0; 
				autoPlaySlide.geser-=100; 
			}else{ autoPlaySlide.geser+=100; }
		}
		if(autoPlaySlide.counter==0){ autoPlaySlide.i++; }else{ autoPlaySlide.i--; }
		setTimeout("autoPlaySlide.play()",autoPlaySlide.delay);
	},
	slidetoleft: function(){
		autoPlaySlide.geser+=100;
		autoPlaySlide.i--;
		document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";	
	},
	slidetoright: function(){
		autoPlaySlide.geser-=100;
		autoPlaySlide.i++;
		document.getElementById("myslide").style.left=autoPlaySlide.geser+"%";	
	}
}
autoPlaySlide.init();
autoPlaySlide.play();
</script>
<?php include "footer.php";?>
</div>
</body>
</html>