<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>


<p>商品の追加に成功しました。</p>
<p>下記の商品を登録しました。</p>


商品名<%=request.getParameter("name") %>
<br>
価格<%=request.getParameter("price") %>



<%@include file="../footer.html" %>