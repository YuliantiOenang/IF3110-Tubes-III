<jsp:include page="contentBegin.jsp"></jsp:include>

<script type="text/javascript">
	function fitcat(obj) {
		fitimg(obj,245,400,true,false,false);
	}
</script>
<div class='prevarrow' onclick='prevCategory()'></div>

<%
	int page_num = 1;
	int pageH = 1;
	out.print("<div class='group_product_cont ");
	if (pageH!=1){
		out.print("hidden");
	}
	out.print("' id='cont1'>");
	
%>
<!-- <?php
		$page_num = 1;
		echo "<div class='group_product_cont ";
		if ($page!=1) echo "hidden";
		echo "' id='cont1'>";
		foreach ($model as $key=>$value) {
			if (($key%3 == 0)&&($key!=0)) {
				$page_num++;
				echo "	</div>
						<div class='group_product_cont ";
				if ($page!=$page_num) echo "hidden";
				echo "' id='cont".$page_num."'>";
			}
			echo "<div class='prodcont";
			if ($key%3 == 0) echo " first";
			if ($key%3 == 2) echo " third";
			echo"'>
				<img class='kat_bg' onload='fitcat(this)' src='".$this->getBaseUrl()."/img/kategori/".$value->gambar."'/>
				<div class='data'>
					<div class='nativearea' id='native1'></div>
					<div class='cat_title'><h3 class='layout_cat'>".$value->nama_kategori."</h3>
					<p class='layout_detail'><b>Description</b></p>
					<p class='layout_detail'>-Sub Description-</p></div>
					<div class='cat_detail'></div>
					<a href='".$this->makeUrl('kategori/view/'.$value->id)."' target=''><div class='browse'><h1>BROWSE</h1></div></a>
				</div>
			</div>
			";
		}
		echo "</div>"

?>  -->
<div class='nextarrow' onclick='nextCategory()'></div>
<script type="text/javascript">
	function showCategory() {
		var n = 1;
		while (document.querySelectorAll('#cont'+n).length) {
			if (!document.querySelectorAll('#cont'+n+'.hidden').length) return n;
			n++;
		}
		return 0;
	}

	var show = showCategory();
	var items = document.querySelectorAll('.group_product_cont').length;
	
	function nextCategory () {
		if (show<items) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					document.getElementById('cont'+show).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('cont'+show), " hidden");
					vara++;
					console.log(x+' : cont'+show);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				show++;
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('cont'+show), "hidden");
						document.getElementById('cont'+show).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : cont'+show);
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
	function prevCategory () {
		if (show>1) {
			var x,y,vara,varb,varc,vard;
			vara = 0;
			varb = 0;
			for (x=0;x<=11;x++){
				setTimeout(function(){
					document.getElementById('cont'+show).style.opacity = 1-(0.1*vara);
					if (vara==10) addClass(document.getElementById('cont'+show), " hidden");
					vara++;
					console.log(x+' : cont'+show);
				}, (50*(varb+1)));
				varb++;
			}
			setTimeout(function(){
				show--;
				varc = 0;
				vard = 0;
				for (y=0;y<=11;y++){
					setTimeout(function(){
						if (varc==0) removeClass(document.getElementById('cont'+show), "hidden");
						document.getElementById('cont'+show).style.opacity = 0.1*varc;
						varc++;
						console.log(y+' : cont'+show);
					}, (120+(50*(vard+1))));
					vard++;
				}
			},600);
		}
	}
</script>

<jsp:include page="contentEnd.jsp"></jsp:include>