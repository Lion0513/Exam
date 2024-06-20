<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- bean.Productをインポート -->
<%@page import="bean.Product" %>


<!-- Product型のオブジェクトをrequest.getAttribute()を使ってサーブレットからデータを受け取る
　　（）の中はサーブレットで指定した変数名で取得 -->
<% Product p=(Product)request.getAttribute("product"); %>

<!-- productオブジェクトのゲッターを使って値を表示 -->
<%=p.getId() %>:<%=p.getName() %>:<%=p.getPrice() %><br>


<%@include file="../footer.html" %>