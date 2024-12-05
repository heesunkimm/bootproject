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
			<h2>접근권한이 없습니다. 로그인 후 이용해주세요.</h2>
			<ul style="text-align: center;">
				<li><a href="/index">홈으로 돌아가기</a></li>
			</ul>
		</div>
    </section>
</body>
</html>