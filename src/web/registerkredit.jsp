<%-- 
    Document   : registerkredit
    Created on : Nov 27, 2013, 9:10:40 PM
    Author     : user
--%>

<jsp:include page="header.jsp"> 
<jsp:param name="pageTitle" value="Register"/> 
</jsp:include> 
       <form id="formdaftarkartukredit" class="styled" action="kartukredit" method="post" onsubmit="return checkForm(this);">
		    <fieldset>
			  <!--<legend>Contact Form</legend>-->
			  <ol>
				<li class="form-row">
				  <label>No Kartu:</label>
				  <input type="text" name="nokartu" id="nokartu" class="nokartu" autocomplete="off">
					<span class="checknokartu" style="color:red;" ></span> 
				  
				</li>
				<li class="form-row">
				  <label>Nama pada Kartu:</label>
				  
				  <input id="namakartu" type="text" class="namakartu" name="namakartu" value=""/>
				</li>
			    <li class="form-row">
				  <label>Tanggal Kadaluwarsa:</label>
				  <input id="tglkadaluwarsa" type="text" class="text-input required tanggal default" name="tglkadaluwarsa" value="" />
				</li>
				<li class="button-row text-right">
				  <input class="btn-ok" type="submit" value="OK" name="btn-ok" id="btn-ok" />
				 <!-- <input class="btn-skip" type="submit" value="Skip" name="btn-skip" />-->
				</li>
			  </ol>
			</fieldset>
		  </form>
    <%@include file="footer.jsp" %>