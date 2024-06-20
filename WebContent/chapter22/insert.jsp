<%-- メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">

	<c:param name="title">
		chapter22_Insert
	</c:param>


	<c:param name="content">
		<p>追加する商品情報を入力してください</p>

		<form action="insert" method="post">
		商品名：<input type="text" name="name">
		<br>
		価　格：<input type="text" name="price">
		<input type="submit" value="追加">
		</form>
	</c:param>

</c:import>