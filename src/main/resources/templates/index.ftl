<html>
    <#include "./common/header.ftl">


<body>
<div class="container">

    <form class="form-signin" method="post" action="/sell/seller/login">
        <h2 class="form-signin-heading">Login</h2>
        <label class="sr-only">用户名</label>
        <input type="text" name="username" class="form-control" placeholder="用户名" required autofocus>
        <label class="sr-only">密码</label>
        <input type="password" name="password" class="form-control" placeholder="密码" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>

</div> <!-- /container -->

</body>

</html>