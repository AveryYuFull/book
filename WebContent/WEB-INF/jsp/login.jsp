<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>login page</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/style/reset.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/style/login.css" type="text/css" />
	<style type="text/css">
      .errorMessage {
        color: red;
      }  
    </style>
    
    <script type="text/javascript">
    function login() {
        var loginFormObj = document.getElementById("loginForm");
        var userNameValue = document.getElementById("userName").value;
        var isSubmitForm = true;
        if (!userNameValue) {
            document.getElementById("errorUserName").innerHTML = "User name is required.";
            isSubmitForm = false;
        } else {
            document.getElementById("errorUserName").innerHTML = "";
        }
        
        var passwordValue = document.getElementById("password").value;
        if (!passwordValue) {
            document.getElementById("errorPassword").innerHTML = "password is required.";
            isSubmitForm = false;
        } else {
            document.getElementById("errorPassword").innerHTML = "";
        }
        
        if (isSubmitForm) {
            loginFormObj.submit();
        }
    }
    </script>
  </head>
  <body>
    <c:if test="${!empty(TIP_MESSAGE)}">
      ${TIP_MESSAGE}
    </c:if>
    <div class="login_title"></div>
    <div class="login_form">
      <div class="form_logo"></div>
      <div class="form_title">图书分享系统</div>
      <div class="form_content">
	    <form action="login" method="post" id="loginForm">
	      <div class="login_form_content">
	        <label class="login_form_label">用户名</label>
	        <input class="login_form_input" type="text" name="userName" id="userName" />
	      </div>
	      <div class="login_form_content">
	        <label class="login_form_label">密码</label>
	        <input class="login_form_input" type="password" name="password" id="password" />
	      </div>
	      <div class="login_form_button">登陆</div>
	      <!-- 
	      <label id="errorUserName" class="errorMessage">
	        <c:if test="${!empty(ERROR_FIELDS) }">${ERROR_FIELDS.errorUserName == null ? "" : ERROR_FIELDS.errorUserName}</c:if>
	      </label>
	      <br />
	      Password: <input type="password" name="password" id="password" /> 
	      <label id="errorPassword" class="errorMessage">
	        <c:if test="${!empty(ERROR_FIELDS)}">${ERROR_FIELDS.errorPassword == null ? "" : ERROR_FIELDS.errorPassword}</c:if>
	      </label><br />
          <input type="button" value="Login" onclick="login()" />
           -->
	    </form>
	  </div>
    </div>
  </body>
</html>