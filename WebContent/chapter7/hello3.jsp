<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>


<%-- メッセージの出力 --%>
<p>Hello!</p>
<p>include</p>

<%-- Javaプログラムを記述　システム日付を表示 --%>
<p><% out.println(new java.util.Date()); %></p>

<%@include file="../footer.html" %>
