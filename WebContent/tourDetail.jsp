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
	ツアー詳細を表示
	<table border="1">
		<tr>
			<td>ツアー名</td>
			<td>${tour.name}</td>
		</tr>
		<tr>
			<td>定員</td>
			<td>${tour.capacity}</td>
		</tr>
		<tr>
			<td>大人価格</td>
			<td>${tour.adultPrice}</td>
		</tr>
		<tr>
			<td>子供価格</td>
			<td>${tour.childPrice}</td>
		</tr>
		<tr>
			<td>出発日</td>
			<td>${tour.departure}</td>
		</tr>
		<tr>
			<td>締切日</td>
			<td>${tour.deadline}</td>
		</tr>
	</table>
	<s:form namespace="/order" action="preOrder">
		<input type="hidden" name="code" value="${tour.code}" />
		<s:submit value="申し込み" />
	</s:form>
</body>
</html>