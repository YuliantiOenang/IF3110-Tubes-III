<%@include file="include/header.jsp" %>
<div class="kategori">
    <h1><%
        String message = (String) request.getAttribute("nama_kategori");
        out.print(message);
    %></h1>
    <p>
        <a class="sorting" href="?by=nama&amp;sort=asc&amp;page=1">Sorting By Name Ascending</a>
        <a class="sorting" href="?by=nama&amp;sort=desc&amp;page=1">Sorting By Name Descending</a>
        <a class="sorting" href="?by=harga&amp;sort=asc&amp;page=1">Sorting By Price Ascending</a>
        <a class="sorting" href="?by=harga&amp;sort=desc&amp;page=1">Sorting By Price Descending</a>
    </p>
    <p>
    </p>
</div>
<%@include file="include/footer.jsp" %>