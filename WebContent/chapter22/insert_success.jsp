<%-- メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">

	<c:param name="title">
		chapter22_InsertSuccess
	</c:param>

	<c:param name="content">
		<p>商品の追加に成功しました</p>
		<p>下記の商品を登録しました</p>

		商品名：<%=request.getParameter("name") %>
		<br>
		価格：<%=request.getParameter("price") %>
	</c:param>
</c:import>