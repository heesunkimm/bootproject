<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
	<section id="join" class="content">
        <form name="joinForm" action="/join" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="input_box">
                <label>
                    <input type="text" name="userName" placeholder="이름" required>
                </label>
                <label>
                    <input type="text" name="userId" placeholder="아이디" required>
                </label>
                <button class="checkBtn" type="button">중복확인</button>
                <label>
                    <input type="password" name="userPw" placeholder="비밀번호" required>
                </label>
                <label>
                    <input type="password" name="userPw02" placeholder="비밀번호확인" required>
                </label>
            </div>
            <button class="joinBtn" type="submit">회원가입</button>
        </form>
    </section>
    <script>
	    $(document).ready(function() {
	    	// 아이디 중복체크
	    	$(".checkBtn").on('click', function() {
	    		let csrfToken = $(`input[name='${_csrf.parameterName}']`).val();
	    		let userId = $("input[name='userId']").val();
	    		
	    		if (!userId) {
	    			return alert("아이디를 입력해주세요.");
	            }
	    		
	    		$.ajax({
	    			url: "/idCheck",
	    			method: "POST",
    				headers: {"X-CSRF-TOKEN": csrfToken}, 
	    			data: {userId: userId},
	    			success: function(res) {
	    				if(res === 'FALSE') {
	    					alert("이미 사용중인 아이디입니다.");
	    				}else if(res === 'TRUE') {
	    					alert("사용가능한 아이디입니다.");
	    					$("input[name='userId']").prop("readonly", true);
	    					$(".checkBtn").prop("disabled", true);
    					}else {
	    				    alert(res);
    					}
	    			},
	    			error: function(err) {
			            console.error(err);
			            alert("서버 요청 실패.\n네트워크 상태를 확인해주세요.");
	    			}
	    		})
	    	});
	    	
	    	// 회원가입
	    	$("form[name='joinForm']").on('submit', function(e) {
	    		e.preventDefault();
	    		if (!$("input[name='userId']").prop("readonly") || !$(".checkBtn").prop("disabled")) {
	    	        return alert("아이디 중복확인을 완료해주세요.");
	    	    }else if($("input[name='userPw']").val() != $("input[name='userPw02']").val()) {
	    			return alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
	    		}
	    		this.submit();
	    	});
	    	
		 	// msg가 존재하는 경우 alert
			let msg = "${msg}";
			if (msg != "") {
				alert(msg);
			}
		});
    </script>
</body>
</html>