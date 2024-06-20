<%-- メニューJSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">

	<c:param name="title">
		chapter22_Insert
	</c:param>

	<c:param name="content">
		<table border="1">
			<thead>
				<th>ID</th><th>Name</th><th>Price</th>
			</thead>
			<tbody>
				<!-- ループ文を使ってリストの中身を表示 -->
				<c:forEach var = "p" items = "${ list }" >
					<tr>
						<td> ${ p.id   } </td>
						<td> ${ p.name } </td>
						<td> ${ p.price} </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:param>
</c:import>
