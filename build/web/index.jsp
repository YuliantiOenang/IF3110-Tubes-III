<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@include file="include/header.jsp" %>
<c:set var="HOME_URL" value="<%=url %>" />
<div class="box_kategori">
    <sql:query var="result" dataSource="jdbc/d86coev9sq2g1b">
        SELECT COUNT(kategori_id) AS nums FROM barang_kategori
    </sql:query>
    <c:forEach var="row_kategori" items="${result.rows}">
        <c:set var="total_kategori" value="${row_kategori.nums}" />
    </c:forEach>
    <c:forEach begin="1" end="${total_kategori}" varStatus="loop">
        <sql:query var="result2" dataSource="jdbc/d86coev9sq2g1b">
            SELECT kategori_nama FROM barang_kategori WHERE kategori_id ="${loop.count}"
        </sql:query>
        <sql:query var="result3" dataSource="jdbc/d86coev9sq2g1b">
            SELECT barang_data.barang_id, nama, image_url, harga FROM `barang_kategori` 
            JOIN barang_data JOIN transaksi ON barang_kategori.kategori_id = barang_data.kategori_id 
            AND barang_data.barang_id = transaksi.barang_id WHERE barang_data.kategori_id = "${loop.count}" 
            GROUP BY barang_data.barang_id ORDER BY COUNT(nama) DESC LIMIT 0, 3
        </sql:query>
        <div class="box_nama"><h2>
            <c:forEach var="row" items="${result2.rowsByIndex}">
                <c:forEach var="column" items="${row}">
                    <c:out value="${column}"/>
                </c:forEach>
            </c:forEach>
        </h2></div>
        <c:forEach var="row2" items="${result3.rows}">
            <a class="box_barang" href="${HOME_URL}barang/${row2.barang_id}">
                <c:if test="${row2.image_url == 'NAT'}">
                    <img class="gambar_barang" src="${HOME_URL}assets/image/default.png" alt="Default" height="100" width="100">
                </c:if>
                <c:if test="${row2.image_url != 'NAT'}">
                    <img class="gambar_barang" src="${HOME_URL}${row2.image_url}" alt="Default" height="100" width="100">
                </c:if>
                <h3>${row2.nama}</h3>
                <span class="harga">Rp. ${row2.harga}</span>
            </a>
        </c:forEach>
    </c:forEach>
</div>
<%@include file="include/footer.jsp" %>