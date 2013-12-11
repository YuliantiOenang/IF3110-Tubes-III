<?php
//include_once('inc/dbConnect.inc.php');

if(isset($_POST['userid']) && !empty($_POST['userid'])){
      $username=$_POST['userid'];
      if($username=='kharisma') $count=1;
	  
      $HTML='';
      if($count > 0){
        $HTML=' telah digunakan';
      }else{
        $HTML='';
      }
      echo $HTML;
}
?>