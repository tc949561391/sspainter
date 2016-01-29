<%--
  Created by IntelliJ IDEA.
  User: tristan
  Date: 15/12/28
  Time: 下午6:12
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form id="login_form" action="${pageContext.request.contextPath}/login2" method="get">

        <c:if test="${error==100}">
            无该用户<br>
        </c:if>

        <c:if test="${error==101}">
            密码错误<br>
        </c:if>
        <label>username</label><br>
        <input id="username" type="text" name="loginId"><br>
        <label>password</label><br>
        <input id="password" type="password" name="password"><br>


    </form>
    <button id="loginButton">submit</button>
    <script>
        $(function(){
            $("#loginButton").click(function(){
                alert("onclick");
                $("#login_form").submit();
                return false;
            })

        })
    </script>
    <p>还没有注册?赶快<a href="pageregister" style="color: aqua">加入</a>吧!</p>
</div>
</body>
</html>
