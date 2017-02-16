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

	<h4>ツアー検索</h4>
	<s:form namespace="/order" action="searchTour" theme="simple">
		<table border="1">
			<tr>
				<td>コースコード</td>
				<td><input type="text" name="courseCode"></td>
			</tr>
			<tr>
				<td>出発日</td>
				<td><input type="text" name="departure"></td>
			</tr>
		</table>
		<input type="submit" value="検索">
	</s:form>
</body>
</html>