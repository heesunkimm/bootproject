<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<section id="error" class="content">
		<div>
			<h2>죄송합니다! 문제가 발생했습니다.</h2>
			<p>에러 메시지: ${msg}</p>
		    <a href="/index" class="btn">홈으로 돌아가기</a>
		</div>
    </section>
</body>
</html>