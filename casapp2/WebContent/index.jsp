<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回值测试</title>
</head>
<body>
<% 
    request.setCharacterEncoding("UTF-8");
    org.jasig.cas.client.authentication.AttributePrincipal principal = (org.jasig.cas.client.authentication.AttributePrincipal) request.getUserPrincipal();
    java.util.Map attributes = principal.getAttributes();
    String userid=(String)attributes.get("userid"); 
    String cnblogUsername = (String)attributes.get("cnblogUsername"); 
    String cnblogPassword = (String)attributes.get("cnblogPassword"); 
    String test=(String)attributes.get("test"); 
    
    %>
    <div>cas返回值演示</div>
    <ul>
        <li>userid:<%= userid%></li>
        <li>username:<%= cnblogUsername%></li>
        <li>password:<%= cnblogPassword%></li>
        <li>test:<%= test%></li>
    </ul>
</body>
</html>