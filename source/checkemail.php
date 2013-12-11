<?php
include('conn.php');
if(isset($_POST['email']) && !empty($_POST['email'])){
      $useremail=strtolower(pg_real_escape_string($_POST['email']));
      $query="select * from anggota where email='$useremail'";
      $res=pg_query($query);
      $count=pg_num_rows($res);
      $HTML='';
      if($count > 0){
        $HTML='is already use';
      }else{
        $HTML='';
      }
      echo $HTML;
}
?>