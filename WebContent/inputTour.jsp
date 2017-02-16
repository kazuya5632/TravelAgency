<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/i18n/jquery.ui.datepicker-ja.min.js"></script>
<link type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet" />
<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			numberOfMonths : 1
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#datepicker2").datepicker({
			numberOfMonths : 1
		});
	});
</script>
<title>RegistTour</title>
</head>
<body style="font-size: 15px;">
	<h3>ツアー登録画面</h3>
	<div>
		<s:form namespace="/travel" action="tourRegist" theme="simple">
			<table border="1">
				<tr>
					<td>コース名</td>
					<td><select name="courseCode">
							<c:forEach var="cList" items="${courseList}">
								<option value="${cList.code}">${cList.name}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>ツアー名</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>定員</td>
					<td><input type="text" name="capacity"></td>
				</tr>
				<tr>
					<td>大人価格</td>
					<td><input type="text" name="adultPrice"></td>
				</tr>
				<tr>
					<td>子供価格</td>
					<td><input type="text" name="childPrice"></td>
				</tr>
				<tr>
					<td>出発日</td>
					<td><input type="text" name="departure" id="datepicker"></td>
				</tr>
				<tr>
					<td>締切日</td>
					<td><input type="text" name="deadline" id="datepicker2"></td>
				</tr>
			</table>
			<input type="submit" value="登録">
		</s:form>
	</div>



	<style>
.tb_button {
	padding: 1px;
	cursor: pointer;
	border-right: 1px solid #8b8b8b;
	border-left: 1px solid #FFF;
	border-bottom: 1px solid #fff;
}

.tb_button.hover {
	borer: 2px outset #def;
	background-color: #f8f8f8 !important;
}

.ws_toolbar {
	z-index: 100000
}

.ws_toolbar .ws_tb_btn {
	cursor: pointer;
	border: 1px solid #555;
	padding: 3px
}

.tb_highlight {
	background-color: yellow
}

.tb_hide {
	visibility: hidden
}

.ws_toolbar img {
	padding: 2px;
	margin: 0px
}
</style>

</body>
</html>