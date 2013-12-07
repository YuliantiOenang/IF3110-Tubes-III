<?php
if (isset($_COOKIE['isCreditCard']))
{
?>
	Ada kredit card
<?php
}
else
{
	header("Location: registrasiKartu.php");
}
?>
