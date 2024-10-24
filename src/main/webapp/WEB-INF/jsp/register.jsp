<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>
</head>

<body>

<!-- RegisterServletのURLにpost送信 -->
<form action="Register" method="post">
ユーザーID：<input type="text" name="userId"><br>
パスワード：<input type="password" maxlength="20" name="pass"><br>
ひとことメッセージ：<input type="text" name="message"><br>
年齢：<input type="number" maxlength="2" name="age"><br>
<input type="submit" value="登録">
</form>

</body>
</html>