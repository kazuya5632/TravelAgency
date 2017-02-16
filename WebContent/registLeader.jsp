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
	<h3>責任者登録画面</h3>
	<div>
		<s:form namespace="/order" action="registLeader" theme="simple">
			<table border="1">
				<tr>
					<td>責任者名</td>
					<td><input type="text" name="leaderName"></td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td><input type="text" name="tel"></td>
				</tr>
				<tr>
					<td>大人人数</td>
					<td><input type="text" name="adultNumber"></td>
				</tr>
				<tr>
					<td>子供人数</td>
					<td><input type="text" name="childNumber"></td>
				</tr>
			</table>
			<input type="hidden" name="adultPrice" value="${tour.adultPrice}" />
			<input type="hidden" name="chilePrice" value="${tour.childPrice}" />
			<input type="submit" value="登録">
		</s:form>
	</div>
</body>
</html>