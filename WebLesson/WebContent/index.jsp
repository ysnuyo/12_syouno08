<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<h2>英単語と日本語を入力してください。</h2>
<form action="input" method="post">
	<table>
		<tr><th>英単語</th><td><input type="text" name="eng"></td></tr>
		<tr><th>日本語</th><td><input type="text" name="jp"></td></tr>
	</table>
	<input type="submit" value="送信">
</form>
</body>
</html>