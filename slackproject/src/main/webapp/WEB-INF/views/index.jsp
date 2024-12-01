<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ include file="index_bottom.jsp" %>