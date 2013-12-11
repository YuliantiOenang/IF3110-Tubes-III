<jsp:include page="contentBegin.jsp"></jsp:include>
<%@ page import="java.util.*" %>

<form method="post" action="${pageContext.request.contextPath}/credit" id="form_credit" onsubmit="credit(); return false;">
	<div class='register_div'>
		<h1 class='header'>Registrasi Kartu Kredit</h1>
		<div class='per_form'>
			<label>Card Number</label><input type="text" name="Credit[card_number]" id="card_number" value="" required> <!-- <?php echo $model->card_number ?> -->
			<span class='error' id="error-card_number"></span>
		</div>
		
		<div class='per_form'>
			<label>Name of Card</label><input type="text" name="Credit[name_of_card]" id="name_of_card" value="<% if ((request.getAttribute("habisitukesubmit")==null)) out.print(request.getAttribute("card_name"));%>" required> <!-- <?php echo $model->name_of_card ?> -->
			<span class='error' id="error-name_of_card"></span>
		</div>
		
		<div class='per_form'>
			<label>Expired Date</label><input onfocus="loadCalendar()" type="text" name="Credit[expired_date]" id="expired_date" value="" required> <!-- <?php echo $model->expired_date ?> -->
			<span class='error' id="error-expired_date"></span>
			<div id="calendar" class="hide">
				<div class="calendar_header">
					<a onclick="hideCalendar()" href="#">X</a>
					<select id="cal_month" onchange="loadDate()">
						<!-- <?php 
							$m = array(1=>'Januari','Februari','Maret','April','Mei','Juni','Juli','Agustus','September','Oktober','November','Desember');
							foreach ($m as $key => $bulan) : ?> 
						<option value="<?php echo $key ?>"><?php echo $bulan ?></option>
						<?php endforeach; ?> -->
						
						<%
				HashMap<Integer, String> m = new HashMap<Integer, String>();
				m.put(1, "Januari");
				m.put(2, "Februari");
				m.put(3, "Maret");
				m.put(4, "April");
				m.put(5, "Mei");
				m.put(6, "Juni");
				m.put(7, "Juli");
				m.put(8, "Agustus");
				m.put(9, "September");
				m.put(10, "Oktober");
				m.put(11, "November");
				m.put(12, "Desember");	
				Iterator<Integer> keySetIterator = m.keySet().iterator();
				while(keySetIterator.hasNext()){
					Integer key = keySetIterator.next();
				%>
					<option value="<% out.print(key); %>"><% out.print(m.get(key)); %></option>
  				<%
				}  
				%>
						
					</select>
					<input type="text" id="cal_year" onchange="loadDate()" value=""> <!-- <?php echo date('Y') ?> -->
				</div>
				<div id="calendar_content"></div>
			</div>
		</div>
		<button type="submit" id="btn" class="btn">Register</button>
		<!-- <?php if (!$sudahSet): ?> -->
<%
		if (request.getAttribute("sudahSet")==null) {		

%>
			<a href="<% out.print(request.getContextPath()); %>/home" class="btn">Skip</a> <!-- <?php echo $this->makeUrl('index/home') ?> -->
<% } %>
	<!--<?php endif; ?>-->
	</div>
	<% if (request.getAttribute("habisitukesubmit")!=null) out.print("<input type='hidden' name='aksi' value='habisitukesubmit'/>"); %>
</form>


<% out.print("<script>var server = '" + request.getContextPath() + "';</script>"); %>
<script src="${pageContext.request.contextPath}/js/credit.js"></script>

<jsp:include page="contentEnd.jsp"></jsp:include>