<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- JSTLをインポート -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- ループ文を使ってリストの中身を表示 -->
<c:forEach var="p" items="${list}">
<!--  -->
${p.id}:${p.name}:${p.price}<br>
</c:forEach>



<%@include file="../footer.html" %>