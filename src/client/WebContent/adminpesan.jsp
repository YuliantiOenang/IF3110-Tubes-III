<jsp:include page="adminbegin.jsp"></jsp:include>
<script type="text/javascript">
	function fitpict(obj) {
		fitimg(obj,340,340,true,true,false);
	}
</script>
<h1 class='small-header'>ALERT</h1>

<div class="item_edit">
	<h4>information</h4>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<p><c:out value="${msg}"> </c:out></p> 
</div>


<script src="${pageContext.request.contextPath}/js/validasiBarang.js"></script>
<script>
	var server = "${pageContext.request.contextPath}";
</script>

	
<jsp:include page="adminend.jsp"></jsp:include>