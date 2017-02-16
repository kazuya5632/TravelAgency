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

<s:form namespace="/travel" action="goPreOrder" theme="simple">
			<table border="1">
				<tr>
					<td>ツアー名</td>
					<td>${tour.name}</td>
				</tr>
				<tr>
					<td>出発日</td>
					<td>${tour.departure}</td>
				</tr>
				<tr>
					<td>人数</td>
					<td>${order.persons}</td>
				</tr>
				<tr>
					<td>大人人数</td>
					<td>${order.adultNumber}</td>
				</tr>
				<tr>
					<td>子供人数</td>
					<td>${order.chileNumber}</td>
				</tr>
				<tr>
					<td>金額</td>
					<td>${order.price}</td>
				</tr>
			</table>
			<br>
			<h4>上記の内容で申し込みますか？</h4>
			<input type="submit" value="申し込み">
		</s:form>


</body>
</html>