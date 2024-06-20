<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%--JSPの宣言による変数の宣言　メンバ変数になる --%>
<%! int countA=0; %>

<%

	//スクリプトレット内で定義される変数
	//JSPが実行している間だけ有効
	int countB=0;


	//インクリメント
	countA++;
	countB++;


%>

     <p>宣言による変数countAは<%=countA %></p>
     <p>スクリプトレット内の変数countBは<%=countB %></p>







<%@include file="../footer.html" %>
