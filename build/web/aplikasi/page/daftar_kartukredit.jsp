<%@page import="java.util.ArrayList"%>
<%@page import ="java.lang.String"%>
<%@include file="/include/header.jsp" %>
<%! public static String HOME_URL = "http://localhost:8080/tugas_web2/"; %>
<h1>Pendaftaran Pelanggan</h1>
<form id="daftar_kartukredit" onSubmit="return submitCreditCard(this)">
    <p><label>Nomor kartu kredit</label>: <input type="text" name="nomor_kartu" size="25" maxlength="23" onKeyUp="regCCNumber(this)"> <i>exp. 1234-5678-9012-3456</i></p>
    <p><label>Nama pada kartu</label>: <input type="text" name="nama_kartu" size="40" maxlength="40" onKeyUp="regCCName(this)"></p>
    <p><label>Masa akhir berlaku kartu</label>: <select name="bulan">
    <% ArrayList<String> arrayofbulan = new ArrayList<String>();
    arrayofbulan.add("Januari");
    arrayofbulan.add("Februari");
    arrayofbulan.add("Maret");
    arrayofbulan.add("April");
    arrayofbulan.add("Mei");
    arrayofbulan.add("Juni");
    arrayofbulan.add("Juli");
    arrayofbulan.add("Agustus");
    arrayofbulan.add("September");
    arrayofbulan.add("Oktober");
    arrayofbulan.add("November");
    arrayofbulan.add("Desember");
        int i = 0;
        for(i = 0; i < arrayofbulan.size(); i++)
        {
            out.println( "<option value=\""+(i + 1)+"\">"+arrayofbulan.get(i)+"</option>");
        }
    %>
        </select>&nbsp;<select name="tahun">
<% for(i = 2050; i >= 2013; i--) {
        out.println("<option value=\""+i+"\">"+i+"</option>");
    } %>
        </select></p>
    <p><label>&nbsp;</label>&nbsp;<input type="submit" name="submit" value="Daftarkan Kartu Kredit" disabled="disabled"> atau <a href="<%=HOME_URL %>">Cukup lewat saja</a></p>
</form>
<%@include file="/include/footer.jsp" %>