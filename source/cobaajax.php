<html>
<head>
<script type="text/javascript" src="jq-1.4.1.min.js"></script>
<script type="text/javascript">
$(function()
{
  $('.userid').keyup(function()
  {
  var userid=$(this).val();
  userid=trim(userid);
  if(userid!=''){
  $('.check').show();
  $('.check').fadeIn(400).html('<br><img src="images/ajax-loading.gif" /> ');

  var dataString = 'userid='+ userid;
  $.ajax({
          type: "POST",
          url: "check2.php",
          data: dataString,
          cache: false,
          success: function(result){
               var result=trim(result);
               if(result==''){
                       $('.check').html('<font color="green"><br>'+userid+' Tersedia</font>');
                       $('#submit').attr('disabled', '');
                       $('#submit').attr('value', 'Register');
                       $(".userid").removeClass("red");
                       $(".userid").addClass("white");
               }else{
                       $('.check').html('<br>'+userid+' '+result);
                       $('#submit').attr('disabled', 'disabled');
                       $('#submit').attr('value', 'Register Deactive');
                       $(".userid").removeClass("white");
                       $(".userid").addClass("red");
               }
          }
      });
   }else{
       $('.check').html('');
       $('#submit').attr('disabled', 'disabled');
       $('#submit').attr('value', 'Register Deactive');
   }
  });
});


function trim(str){
     var str=str.replace(/^\s+|\s+$/,'');
     return str;
}
</script>
</head>
<body>
<form id="formdaftar" class="styled" action="sukses.php" method="post">
 <label>Username:</label>
	<input type="text" name="userid" class="userid" autocomplete="off">
	<span class="check" style="color:red;" ></span><br>
	  <input class="btn-submit" type="submit" value="Register" name="submit" id="submit" />
</form>
</body>