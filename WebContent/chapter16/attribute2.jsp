<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- bean.Productをインポート -->
<!-- Listをインポート -->
<%@page import="bean.Product, java.util.List" %>

<!-- 下記の@SuppressWarningsはEclipseの警告を消すための記述です。 -->

<!-- Product型のオブジェクトをrequest.getAttribute()を使ってサーブレットからデータを受け取る
　　（）の中はサーブレットで指定した変数名で取得 -->
<%
@SuppressWarnings("unchecked")

List<Product> list=(List<Product>)request.getAttribute("list");
%>

<!-- ループ文を使ってリストの中身を表示 -->
<% for (Product p : list) { %>
	<p><%=p.getId() %>：<%=p.getName() %>：<%=p.getPrice() %></p>
<% } %>

<%@include file="../footer.html" %>


