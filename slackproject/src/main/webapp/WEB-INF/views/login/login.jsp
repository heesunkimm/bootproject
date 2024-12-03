<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css">
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
    <section id="login" class="content">
        <form name="f" action="/login" method="post">
        	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="input_box">
                <label>
	                <c:if test="${empty cookie['saveId']}">
	                  	<input type="text" name="userId" value="" placeholder="ID" required>
	              	</c:if>
	              	<c:if test="${not empty cookie['saveId']}">
	              		<input type="text" name="userId" value="${cookie['saveId'].value}" placeholder="ID" required>
	              	</c:if>
                </label>
                <label>
                    <input type="password" name="userPw" placeholder="PASSWORD" required>
                </label>
                <button class="login_btn" type="submit">로그인</button>
            </div>

            <div class="save_box">
                <label>
                     아이디 저장 <input type="checkbox" name="saveId" value="on" <c:if test="${not empty cookie['saveId']}">checked</c:if>>
                </label>
            </div>

            <div class="join_box">
                <a href="/join">회원가입</a>
                <!-- <ul class="find_box">
                    <li><a href="javascript:;">아이디찾기</a></li>
                    <li><a href="javascript:;">비밀번호찾기</a></li>
                </ul> -->
            </div>
        </form>
    </section>
    <script>
		// msg가 존재하는 경우 alert
		let msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
    </script>
</body>
</html>