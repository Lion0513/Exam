<%-- メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">

	<c:param name="title">
		chapter22_Insert
	</c:param>

	<c:param name="content">
		<p>検索キーワードを入力してください</p>

		<form action="search" method="post">
		<!-- inputタグの name属性に注目 -->
		<input type="text" name="keyword">
		<input type="submit" value="検索">
		</form>
	</c:param>

</c:import>