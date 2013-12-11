<?php
include('conn.php');
if(isset($_POST['nokartu']) && !empty($_POST['nokartu'])){
      $nokartu=strtolower(pg_real_escape_string($_POST['nokartu']));
      $query="select * from kartukredit where nokartu='$nokartu'";
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