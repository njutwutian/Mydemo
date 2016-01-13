<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Routing Map</title>
    <link rel="stylesheet" type="text/css" href="./CSS/login.css" />
</head>

<body>
  <div id="main">
      <div id="loginmain">
          <h3>login</h3>
          <div id="userinfo">
              <div id="userpass">
              <form id="loginform">
                   <input id="username" class="user-name" type="text" placeholder="UserName" tabindex="1" name="username"/>
                   <input id="password" class="pass-word" type="password" placeholder="PassWord" tabindex="2" name="password"/>
                   <input class="logging" type="button" onclick="onLoginCheck()" tabindex="5" value="登录" accesskey="l"/>
                   <span id="msg"></span>
                   <div class="extralogin">
                           <span class="register">
                           <a tabindex="4" href="">
                               new user
                           </a>
                           </span>
                           &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                           <span class="forget">
                           <a tabindex="4" href="">
                               foget key
                           </a>
                           </span>
                   </div>
              </form>
              </div>
          </div>
      </div>
  </div>
</body>
<script>
    function logfun()
    {
         alert("abc");
         var form = document.getElementById("loginform");
         alert(typeof(form));
         document.getElementById("loginform").submit();
    }
    var xmlHttp;
    function createXmlHttp() {
        if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        }
        else 
        {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } 
    }
    function onLoginCheck() {
        createXmlHttp();
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var url = "/hello/servlet/CheckLoginServlet?username=" + username + "&password=" + password;
        xmlHttp.open("POST",url);
        xmlHttp.send(null);
        xmlHttp.onreadystatechange = showCheckInfoCallback;
    }
    function showCheckInfoCallback() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var text = xmlHttp.responseText;
                var obj = eval("(" + text + ")");
                document.getElementById("msg").innerHTML = obj.data;
                if(obj.flag==1){
                	window.location.href="/hello/index.jsp";
                }
            }
        } 
    }
</script>
</html>
