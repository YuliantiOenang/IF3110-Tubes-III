<?php
//include_once('inc/dbConnect.inc.php');
include('conn.php');
if(isset($_POST['userid']) && !empty($_POST['userid'])){
      $username=strtolower(pg_real_escape_string($_POST['userid']));
      $query="select * from anggota where userid='$username'";
      $res=pg_query($query);
      $count=pg_num_rows($res);
      $HTML='';
      if($count > 0){
        $HTML=' telah digunakan';
      }else{
        $HTML='';
      }
      echo $HTML;
}
?>