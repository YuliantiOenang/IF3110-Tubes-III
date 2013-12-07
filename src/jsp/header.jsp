<%@ page import="com.ruserba.model.Database" %>
<%@ page import="com.ruserba.model.Category" %>
<%@ page import="java.util.ArrayList" %>

<%
	Database db = (Database)application.getAttribute("db");
	ArrayList<Category> cat_list = db.getCategory();
%>

<div id="header">
	<div id="headerlogin">
		<div id="headernotloggedin">
			<p><a href="javascript:;" id="headerloginbutton">Login</a></p>
			<p>Pengunjung baru? <a href="register.jsp">Register</a></p>
		</div>
		<div id="headerloggedin">
			<p>Welcome <span id="headerusername"></span>!<a href="javascript:;" id="headerlogoutbutton">Logout</a></p>
		</div>
	</div>
	<div id="headerlogo">
		<a href="index.jsp"><img src="images/logo.gif" alt="Ruserba logo" /></a>
	</div>
	<div>
		<div id="headershoppingbag">
			<a href="bag.jsp"><img src="images/bag.jpg" alt="Shopping bag icon" /></a>
		</div>
		<div class="headertabs">
			<div class="headertab">
				<input type="radio" id="headertab-1" name="headertab-group-1" checked="checked" />
				<label for="headertab-1">Kategori</label>
				<div class="headertabcontent">
					<%
						for (Category cat : cat_list)
							out.write("<a href=\"category.jsp?category_id=" + cat.getIdKategori() + "\">" + cat.getNamaKategori() + "</a>");
					%>
				</div> 
			</div>

			<div class="headertab">
				<input type="radio" id="headertab-2" name="headertab-group-1" />
				<label for="headertab-2">Pencarian</label>
				<div class="headertabcontent">
					<form action="search.jsp" method="GET">
						<label for="headersearchname">Nama barang</label><input type="text" id="headersearchname" name="product_name" />
						<label for="headersearchcategory">Kategori</label>
						<select id="headersearchcategory" name="category_id">
							<option value="0">== Pilih kategori ==</option>
							<%
								for (Category cat : cat_list)	{
									out.write("<option value=\"" + cat.getIdKategori() + "\">" + cat.getNamaKategori() + "</option>");
								}
							%>
							<!--
							<?php
								foreach($catarr as $cat)	{
									echo '<option value="'. $cat['id_kategori'] . '">' . $cat['nama_kategori'] . '</option>';
								}
							?>
							-->
						</select>
						<label for="headersearchprice">Harga</label><input type="text" id="headersearchprice" name="price" />
						<select name="price_comparison">
							<option value="0">== Pilih jenis komparasi ==</option>
							<option value="1">Lebih kecil</option>
							<option value="2">Lebih kecil atau sama dengan</option>
							<option value="3">Lebih besar</option>
							<option value="4">Lebih besar atau sama dengan</option>
						</select>
						<input type="submit" value="Cari!" />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
