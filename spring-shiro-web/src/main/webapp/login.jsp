<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>   --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<%--   <shiro:guest>未登录</shiro:guest>  
  
<shiro:user>
    <shiro:principal />
</shiro:user>   --%>

  <form action="login.do" method="post" name="form1">
     用户名：<input type="text" name="username"/><br/>
     密码：   <input type="text" name="password"/><br/>
     <input type="submit" name="subject" value="登录"/><br/>
     <div>${error}</div>
  </form>
</body>
</html>
