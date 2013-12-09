<html>

<script>
	
	function confirmUser()
	{
		var ask=confirm("Apakah Anda yakin menghapus barang ini ? ");
		if(ask)
		{
				window.location="delete.php";
		}
	}
</script>

<body>
		<input type="button" onclick="confirmUser()" value="Hapus Barang"></input>
</body>

</html>