<head>
	<title>RuSerBa</title>
	<link rel="stylesheet" href="css/halamanbarang.css" type="text/css" />
	<link rel="stylesheet" href="css/imageslider.css" type="text/css" />
</head>

<?php include 'header.php'?>
	</head>
<?php include 'middle.php'?>

<body id="index" class="home">
	<div style="width:1100px; margin-left:auto; margin-right:auto">
	<article id="featured" class="body">
	<form method="post" action="editbarang">
		<h2>Edit</h2>
	<?php 
		$id=$_GET["id"];
		$con=mysqli_connect("localhost","root","","ruserba"); //ini kalau di tubes 1
		// Check connection
		if (mysqli_connect_errno()) {
			echo "Failed to connect to MySQL: " . mysqli_connect_error();
		}
		
		$sql = "SELECT * FROM barang id '= "$_GET=["id"] "'";
		$result=mysqli_query($con,$sql);
		$rows=mysqli_num_rows($result);
		
		// Display result
			while ($row = mysqli_fetch_array($result)) {
				$nama=$row['nama'];
				$harga=$row['harga'];
				"<input type=\"hidden\" value='"+$row=['id']+"'name='id'>"
          				+"<pre>Nama Barang	: <input type=\"text\" name=\"nama\" value="+$row['nama']+"></pre>"
                		+"<pre>Kategori		: <input type=\"text\" name=\"kategori\" value="+$row['kategori']+"></pre>"
                		+"<pre>Harga		: <input type=\"text\" name=\"harga\" value="+$row['harga']+"></pre>"
                		+"<pre>Jumlah		: <input type=\"text\" name=\"jumlah\" value="+$row['jumlah']+"></pre>"
                		+"<pre id=\"addedrequest\">Deskripsi		: <textarea name=\"deskripsi\" cols=\"25\" rows=\"5\">"+$row['keterangan']+"</textarea></pre>"
                		+"<pre>Link Gambar	: <input type=\"text\" name=\"img\" value="+$row['gambar']+"></pre>";
			}
	?>
	<input type="submit" value="Edit">
	</form>
	</body>
</html>