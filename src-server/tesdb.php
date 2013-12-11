<?php
			// Establish connection
			$pg_connection_string = "dbname=d5216j2nufkt99 host=ec2-54-235-99-46.compute-1.amazonaws.com port=5432 user=nulxwejlynnksi password=J17_WbbObzQJuwEGmDoR7avViM sslmode=require";
			$con = pg_connect($pg_connection_string);
			// Check connection
			if (!$con) {
				echo "Failed to connect to MySQL: " . pg_last_error($con);
			}
			// Query
			$result = pg_query($con,"SELECT * FROM data_barang");
			// Close connection
			pg_close($con);
			// Return value
			while($row = pg_fetch_array($result)) {
				var_dump ($row);
				echo "<br>";
			}
?>