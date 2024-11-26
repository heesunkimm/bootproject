<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="index_top.jsp" %>
<section class="attend_cont">
	<form name="attendFrom" action="/attend" method="post">
		<input type="hidden" name="checkTime">
		<div class="attend_box" style="text-align: center;">
            <p class="today"></p>
            <p class="clock"></p>
            <label>
            	<input type="text" name="notes" placeholder="비고">
			</label>
        </div>
        <button class="attendBtn" type="submit">출근</button>
    </form>
</section>
<script>
	$(document).ready(function() {
		function getClock() {
			let day = new Date();
			let formattedDate = `${day.getFullYear()}-${day.getMonth() + 1}-${day.getDate()} ${String(day.getHours())}:${String(day.getMinutes()).padStart(2, "0")}:${String(day.getSeconds()).padStart(2, "0")}`;
			$("input[name='checkTime']").val(formattedDate)
            $(".today").text(`${day.getFullYear()}년 ${(day.getMonth() + 1)}월 ${day.getDate()}일`);
            $(".clock").text(`${String(day.getHours())}시 ${String(day.getMinutes()).padStart(2, "0")}분 ${String(day.getSeconds()).padStart(2, "0")}초`);
		}
		getClock();
        setInterval(() => {getClock()}, 1000);
        
		$("form[name='attendFrom']").on('submit', function (e) {
        	// $.ajax({
            //     url: "",
            //     method: "get",
            //     data: {},
            //     success: function (res) {
            //     },
            //     error: function (err) {
            //         alert("Error Message: " + err);
            //     }
            // })
		});
	});
</script>
<%@ include file="index_bottom.jsp" %>