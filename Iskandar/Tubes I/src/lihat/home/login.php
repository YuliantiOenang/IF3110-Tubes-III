<form id="loginForm" name="loginForm" action="#" method="POST" onsubmit="onLoginClick('user/login', 'loginForm'); return false;">
    <div id="logintext">
        Username : <input type="text" name="username"><br>
        Password : <input type="password" name="password"><br>
        <input type="submit" value="submit" name="submit">
        <input type="button" value="back" onClick="history.go(-1);return reset();">
    </div>
</form>