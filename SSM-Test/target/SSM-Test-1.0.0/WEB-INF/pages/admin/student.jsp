<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <title>SSM框架整合</title>
    <jsp:include page="/WEB-INF/pages/plugins/basepath.jsp"/>
</head>
<body>
<%!
    public static final String STUDENT_ADD_URL="pages/admin/student/add.action";
%>
<h1>${errors}</h1>
<form action="<%=STUDENT_ADD_URL%>" method="post">
    学生名称:<input name="sname" id="sname" value="小明">
    <button type="submit">发送</button>
    <button type="reset">重置</button>
</form>
</body>
</html>
