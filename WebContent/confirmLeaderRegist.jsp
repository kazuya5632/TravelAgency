<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ConfirmLeaderTour</title>
</head>
<body style="font-size: 15px;">
	<h3>確認画面</h3>
	<div>
		<s:form namespace="/order" action="goRegistLeader" theme="simple">
			<table border="1">
				<tr>
					<td>ツアー名</td>
					<td>${tour.name}</td>
				</tr>
				<tr>
					<td>責任者名</td>
					<td>${participant.name}</td>
				</tr>
				<tr>
					<td>電話番号</td>
					<td>${participant.tel}</td>
				</tr>
				<tr>
					<td>大人人数</td>
					<td>${adultNumber}</td>
				</tr>
				<tr>
					<td>子供人数</td>
					<td>${childNumber}</td>
				</tr>
			</table>
			<br>

			<h4>上記の内容で登録しますか？</h4>
			<input type="submit" value="登録">
		</s:form>
		<br> <a
			href="http://localhost:8080/TravelAgency/travel/menu.action">メニュー画面へ</a>
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