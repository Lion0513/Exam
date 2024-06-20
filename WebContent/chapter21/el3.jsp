<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<!-- Math.random()：乱数を生成するメソッド（範囲：0～1） -->
<!-- Mathライブラリ　暗黙のライブラリ -->
<p>${Math.random()<0.5 ? "あたり" : "はずれ"}</p>

<%@include file="../footer.html" %>