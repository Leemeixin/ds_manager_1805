<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/10/30
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="/js/jquery-1.11.3.min.js"></script>
</head>
<body>

    内嵌页面
    <table>
        <c:forEach items="${list}" var="attr">
            <tr>
                <td>${attr.shxmMch}</td>
                    <c:forEach var="val" items="${attr.valueList}">
                        <td>${val.shxzh}${val.shxzhMch}</td>
                    </c:forEach>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
