<%--
  Created by IntelliJ IDEA.
  User: tristan
  Date: 15/12/28
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="register_form" action="${pageContext.request.contextPath}/doregister" method="post">
    <label>username</label><br>
    <input id="username" type="text" name="name"><br>
    <label>password</label><br>
    <input id="password" type="password" name="password">


</form>
    <button onclick="submitre()">register</button>

    <script>
        function submitre(){
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;
            if (username==""||password==""){
                alert("输入用户名和密码");
            }else {
                var registerForm=document.getElementById("register_form");
                registerForm.submit();
            }

        }
    </script>


</body>
</html>
