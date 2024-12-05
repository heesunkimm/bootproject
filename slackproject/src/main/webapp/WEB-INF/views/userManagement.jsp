<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="index_top.jsp" %>
<style>
	button {padding: 4px 10px; border: 1px solid #ccc; color: #555;}
	button:hover {color: green;}
</style>
<section class="schedule_cont">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table class="s_table">
        <thead>
            <tr>
                <th>유저명</th>
                <th>아이디</th>
                <th>권한</th>
                <th>가입일</th>
                <th>승인요청</th>
            </tr>
        </thead>
        <tbody>
       	<c:forEach var="item" items="${userList}">
            <tr>
                <td>${item.userName}</td>
                <td>${item.userId}</td>
                <td>${item.userRoles}</td>
                <td>${item.userRegDate}</td>
                <td>
                	<c:if test="${item.userStatus eq 'F'}">
		    <button type="button" onclick="updateUserStatus(this)" data-user="${item.userId}" data-status="${item.userStatus}">승인요청</button>
		</c:if>
		<c:if test="${item.userStatus eq 'T'}">
		    <button type="button" onclick="updateUserStatus(this)" data-user="${item.userId}" data-status="${item.userStatus}">승인취소</button>
		</c:if>
                </td>
            </tr>
       	</c:forEach>
        </tbody>
    </table>
</section>
<script>
	function updateUserStatus(btn) {
		let token = $("input[name='_csrf']").val();
	    let userStatus = $(btn).data("status");
	    let userId = $(btn).data("user");
	    
	    $.ajax({
			url: "/userStatusUpdate", 
			method: "POST",
			headers: {"X-CSRF-TOKEN": token}, 
			data: {
				userId: userId,
				userStatus: userStatus
				},
			success: function(result) {
				if(result === "T"){
					alert("승인되었습니다.");
				}else if(result === "F") {
					alert("승인취소 되었습니다.");
				}else {
					alert("알 수 없는 오류가 발생했습니다.");
				}
				location.reload();
			},
			error: function(err) {
				console.log("Error: " + err);
	            alert("서버 요청 실패.\n네트워크 상태를 확인해주세요.");
			}
		}); 
	};
</script>
<%@ include file="index_bottom.jsp" %>