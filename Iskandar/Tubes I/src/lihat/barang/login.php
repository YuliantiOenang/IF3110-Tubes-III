<form id="loginForm" name="loginForm" action="#" method="POST" onsubmit="onLoginClick('<?=SITE_ROOT.NAME_ROOT;?>/index.php/barang/login', 'loginForm'); return false;">
    <div id="logintext">
        Username : <input type="text" name="username"><br>
        Password : <input type="password" name="password"><br>
        <input type="submit" value="submit" name="submit">
        <input type="button" value="back" onClick="history.go(-1);return reset();">
    </div>
</form>