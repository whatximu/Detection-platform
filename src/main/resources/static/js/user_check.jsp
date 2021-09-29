
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@page import="DAO.UserDaoImpl"%>
<%@ page import="javax.swing.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'testconnection.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>

<body>

<%

    String inputname=request.getParameter("username");

    request.getSession().setAttribute("user",inputname);
    String inputpwd=request.getParameter("userpwd");
    boolean[]booleans2= new  boolean[2];
    UserDaoImpl asd =new UserDaoImpl();
    booleans2= asd.check(inputname,inputpwd);
    boolean a=booleans2[0];
    boolean b=booleans2[1];

    if(a&&b){
        response.sendRedirect("ADMIN/form1.jsp");
    }else {
        out.println("<script language='javascript'>alert('账号或密码错误！');window.location.href='ADMIN/index.html';</script>");
    }
%>
</body>
</html>
