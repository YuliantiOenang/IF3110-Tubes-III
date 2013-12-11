<?php
	if (isset($query)) {
		$con = mysqli_connect('', 'root', '', 'ruserba');
		if ($con) {
			$stmt = mysqli_prepare($con, $query);
			if (isset($params)) {
				$s = '';
				$funcparams = array();
				foreach ($params as $key => $value) {
					$funcparams[$key] = &$params[$key];
					$s .= 's';
				}
				array_unshift($funcparams, $stmt, $s);
				call_user_func_array('mysqli_stmt_bind_param', $funcparams);
			}
			mysqli_stmt_execute($stmt);
			$affected = mysqli_affected_rows($con);
			$result = @mysqli_fetch_all(mysqli_stmt_get_result($stmt), MYSQLI_ASSOC);
			mysqli_stmt_close($stmt);
		}
		mysqli_close($con);
	}
?>