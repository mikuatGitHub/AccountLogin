<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTLを呼び出すタグディレクティブ -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerOK.jsp</title>
</head>

<body>

<!-- JSTLとEL式（スコープからプロパティを出力）でJavaコードを記述 -->
<p>「 <c:out value="${register.userId}" /> 」さん、登録に成功しました</p>

<a href="Welcome">トップへ戻る</a>

</body>
</html>