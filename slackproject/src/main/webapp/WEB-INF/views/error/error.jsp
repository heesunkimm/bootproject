<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<style>
	#error ul li + li {margin-top: 2%;}
	#error ul li a {border-bottom: 1px solid #555;}
	#error ul li a:hover {border-color: green; color: green;}
</style>
</head>
<body>
	<section id="error" class="content">
		<div>
			<h2>죄송합니다! 문제가 발생했습니다.</h2>
			<p style="margin: 3% 0;">에러 메시지: ${msg}</p>
			<ul style="text-align: center;">
				<li><a href="/login">로그인페이지로 돌아가기</a></li>
				<li><a href="/index">홈으로 돌아가기</a></li>
			</ul>
		</div>
    </section>
</body>
</html>