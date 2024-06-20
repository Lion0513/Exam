<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- JSTLをインポート -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

抽選結果：
<c:if test="${Math.random()<0.5 }">
      あたり
</c:if>

<c:url var="result" value="/chapter8/greeting-out.jsp">
<c:param name="user" value="ひぐぺん工房" />
</c:url>
<a href=${result} > URL</a>

<p>${result}</p>

<%@include file="../footer.html" %>