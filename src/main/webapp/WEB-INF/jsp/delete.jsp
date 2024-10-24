<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTLを呼び出すタグディレクティブ -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>delete.jsp</title>
</head>

<body>
<!-- JSTLとEL式（スコープからプロパティを出力）でJavaコードを記述 -->
<p>「 <c:out value="${login.userId}" /> 」さん、登録を削除します</p>

<!-- DeleteServletのURLパターンにpost送信 -->
<form action="Delete" method="post">
	（ユーザーIDをhiddenで送信します）
	<input type="hidden" name="userId" value="<c:out value="${login.userId}"/>"><br>
	<input type="submit" value="アカウントを削除">
</form>

</body>
</html>