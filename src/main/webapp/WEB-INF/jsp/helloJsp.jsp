<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
helloJsp
<hr>
<c:forEach var="list" items="${mlist}">
    <c:out value="${list}"></c:out>
</c:forEach>
</body>
</html>