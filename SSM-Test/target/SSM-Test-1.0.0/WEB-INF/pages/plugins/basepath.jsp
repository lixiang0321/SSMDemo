<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath() ;
    application.setAttribute("basePath", basePath) ; // 将BasePath的内容保存在application属性之中
%>
<base href="<%=basePath%>/"/>