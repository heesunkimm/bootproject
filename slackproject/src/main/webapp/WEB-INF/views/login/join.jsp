<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
	<section id="join" class="content">
        <form name="f" action="" method="post">
            <p>회원가입</p>
            <div class="input_box">
                <label>
                    <input type="text" name="userName" placeholder="이름" required>
                </label>
                <label>
                    <input type="text" name="userBirth" placeholder="생년월일 ex&#41;2024-10-01" required>
                </label>
                <label>
                    <input type="text" name="userId" placeholder="아이디" required>
                </label>
                <label>
                    <input type="password" name="userPw" placeholder="비밀번호" required>
                </label>
            </div>
            <button class="join_btn" type="button">회원가입</button>
        </form>
    </section>
</body>
</html>