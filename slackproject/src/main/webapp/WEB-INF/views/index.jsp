<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="index_top.jsp" %>
<section class="attend_cont">
	<form name="attendFrom" action="/attend" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="checkTime">
		<div class="attend_box" style="text-align: center;">
            <p class="today"></p>
            <p class="clock"></p>
            <c:if test="${LeaveWork}">
            <label>
            	<input type="text" name="attendMemo" placeholder="비고">
			</label>
            </c:if>
        </div>
        	<c:if test="${StartWork}">
		        <button class="attendBtn" type="submit">출근</button>
        	</c:if>
        	<c:if test="${LeaveWork}">
		        <button class="attendBtn" type="submit">퇴근</button>
        	</c:if>
			<c:if test="${ReStartWork}">
			    <button>재출근</button>
			</c:if>
        	
	    </form>
</section>
<script>
	$(document).ready(function() {
		// 시계
		function getClock() {
			let day = new Date();
			let formattedDate = day.getFullYear() + "-" + String((day.getMonth() + 1)).padStart(2, "0") + "-" + String(day.getDate()).padStart(2, "0") + " " + String(day.getHours()).padStart(2, "0") + ":" + String(day.getMinutes()).padStart(2, "0") + ":" + String(day.getSeconds()).padStart(2, "0");
			$("input[name='checkTime']").val(formattedDate);
	        $(".today").text(day.getFullYear() + "년" + (day.getMonth() + 1) + "월" + day.getDate() + "일");
	        $(".clock").text(String(day.getHours()) + "시" + String(day.getMinutes()).padStart(2, "0") + "분" + String(day.getSeconds()).padStart(2, "0") + "초");
		};
		getClock();
		setInterval(() => {getClock()}, 1000);
	})
</script>
<%@ include file="index_bottom.jsp" %>