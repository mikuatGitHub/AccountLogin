<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTLを呼び出すタグディレクティブ -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginOK.jsp</title>
</head>

<body>

<!-- JSTLとEL式（スコープからプロパティを出力）でJavaコードを記述 -->
<p>「 <c:out value="${login.userId}" /> 」さん、ログインに成功しました</p>

<p><a href="Delete">アカウントを削除する</a></p>

<p><a href="Welcome">トップへ戻る</a></p>

</body>
</html>