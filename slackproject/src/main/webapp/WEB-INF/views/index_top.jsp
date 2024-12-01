<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <header>
        <ul>
            <li><a href="javascript:;">출퇴근</a></li>
            <li><a href="javascript:;">일정등록</a></li>
            <li><a href="javascript:;">유저관리</a></li>
            <li><a href="javascript:;">로그아웃</a></li>
        </ul>
    </header>