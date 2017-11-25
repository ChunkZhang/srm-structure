<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <title>固体火箭发动机结构完整性分析网站</title>

    <meta charset="utf-8">
</head>
    <body background="${pageContext.servletContext.contextPath}/images/banner2.jpg" style="text-align: center; background-repeat: no-repeat; background-size: cover; color: #F8F8F8;">
    <h1>固体火箭发动机结构完整性分析网站</h1>


    <form>
        <span>用户名:</span>
        <span><input type="text"  name="userName" ></span> <br/>
        <span>密&nbsp;&nbsp;码:</span>
        <span><input type="password" name="password" ></span><br/>
        <span><input type="submit" formaction="${pageContext.servletContext.contextPath}/login" formmethod="post"  ></span>
    </form>
    <button onclick="window.location.href='/srm/views/sign.jsp'">注册</button>



    </body>
</html>
