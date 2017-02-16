<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" style="font-size: 15px;">
		<thead>
			<tr>
				<th>ツアー名</th>
				<th>出発日</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tList" items="${tourList}">
				<tr>
					<td>${tList.name}</td>
					<td>${tList.departure}</td>
					<td><s:form namespace="/order" action="tourDetail">
							<input type="hidden" name="code" value="${tList.code}" />
							<s:submit value="詳細" />
						</s:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>