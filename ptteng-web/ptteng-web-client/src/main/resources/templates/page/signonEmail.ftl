<div>
    <form action="/signon/user" method="post" >
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name" required/></td>
                <a href="/register/sms" style="color: #5bc0de">使用手机号码注册</a>
            </tr>
            <tr>
                <td>输入密码：</td>
                <td><input type="password" name="passwd" id="passwd" required/></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" id="confirm" onkeyup="validate()" required/>
                    <span id="tishi"/>
                </td>
            </tr>
            <tr>
                <td>邮箱地址：</td>
                <td>
                    <input id="emailAddress" name="email" type="email" required/>
                    <input id="code" name="code" type="text" required>
                    <input id="j-get-code" type="button" value="获取验证码" onclick="fasong()" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="注册" />
                </td>
            </tr>
        </table>
    </form>

    <script>
        function validate() {
            var pw1 = document.getElementById("passwd").value;
            var pw2 = document.getElementById("confirm").value;
            if(pw1 == pw2) {
                document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
                document.getElementById("submit").disabled = false;
            } else {
                document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
                document.getElementById("submit").disabled = true;
            }

        }

        function fasong() {
            var address = document.getElementById("emailAddress").value;
            var xmlhttp;
            if (window.XMLHttpRequest) {
                // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlhttp = new XMLHttpRequest();
            } else {
                // IE6, IE5 浏览器执行代码
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }

            xmlhttp.open("POST", "/register/send", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("contact=" + address);
            console.log(address)
        }

    </script>
</div>