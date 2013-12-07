<?php
  session_start();
  if(isset($_SESSION['LOGIN_STATUS']) && !empty($_SESSION['LOGIN_STATUS'])){
      header('location:index.php');
  }
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.4.1.min.js"></script>
<script type="text/javascript">
function validKartuKredit(){
      var NoKartu=$('#NoKartu').val();
      var NameOnCard=$('#NameOnCard').val();
      var dd=$('#dd').val();
      var mm=$('#mm').val();
      var yyyy=$('#yyyy').val();

      var dataString = 'NoKartu='+ NoKartu + '&NameOnCard='+ NameOnCard + '&dd=' + dd +;
      $("#flash").show();
      $("#flash").fadeIn(400).html('<img src="image/loading.gif" />');
      $.ajax({
      type: "POST",
      url: "processed.php",
      data: dataString,
      cache: false,
      success: function(result){
               var result=trim(result);
               $("#flash").hide();
               if(result=='correct'){
                     window.location='index.php';
               }else{
                     $("#errorMessage").html(result);
               }
      }
      });
}

function trim(str){
     var str=str.replace(/^\s+|\s+$/,'');
     return str;
}
</script>
</head>
<body>
<div id="container">
    <!--top section start-->
    <div id='mainHead'>
         <div class="mainTitle"><h1>REGISTRASI KARTU KREDIT</h1></div>
    </div>

    <div id="wrapper">
                 <div>No. Kartu
                 <input type="text" name="NoKartu" id="NoKartu">
              </div>
			  &nbsp;
              <div>Nama Pemilik
                 <input type="text" name="NameOnCard" id="NameOnCard">
              </div>
			  &nbsp;
              <div>
                 Tanggal Expire (dd/mm/yyyy)
                 <input type="text" name="dd" id="dd">
                 <input type="text" name="mm" id="mm">
                 <input type="text" name="yyyy" id="yyyy">
              </div>
			  &nbsp;
              <div>
                 <input type="button" name="submit" value="Submit" class="button" onclick="validKartuKredit()">
				 <input type="button" name="submit" value="Skip" class="button" onclick="validKartuKredit()">
              </div>
    </div>
</div>
</body>
</html>
