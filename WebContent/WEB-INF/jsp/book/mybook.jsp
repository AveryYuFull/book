<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/style/reset.css" type="text/css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/style/style.css" type="text/css" />
    <title>Home Page</title>
  </head>
  <body>
    <div id="wrapper">
      <div id="header">
        <div class="logo">LOGO</div>
        <div class="menu">
          <ul>
            <li><a href="##">我的图书</a></li>
            <li><a href="##">全部图书</a></li>
          </ul>
        </div>
        <div class="tool">TOOL</div>
       </div>
      <div id="breadcrumb"></div>
      <div id="main">
        <div id="left"></div>
        <div id="content"></div>
      </div>
      <div id="footer"></div>
    </div>
  </body>
</html>