<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Integer arrayresult = (Integer)request.getAttribute("arrayresult"); %>
<% Integer size = (Integer)request.getAttribute("size"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h2><%=arrayresult %>件登録しました。</h2>
	<p>登録件数は<%=size %>です。</p>
	<a href="index.jsp">トップページへ戻る</a>

</body>
</html>