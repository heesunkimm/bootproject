<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="index_top.jsp" %>
<section class="schedule_cont">
    <form name="scheduleForm" action="/schedule" method="post" style="display: flex; flex-direction: column; text-align: center;">
    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label>
            <input type="text" name="scheduleTitle" placeholder="일정명" required>
        </label>
        <label>
            <textarea name="scheduleContent" placeholder="일정설명" maxlength="100"></textarea>
        </label>
        <div class="time_box">
        	<span>날짜 및 시간선택</span>
        	<label>
	            <input type="date" name="scheduleDate" required>
	        </label>
            <select name="scheduleTime">
                <option value="09:00">09:00</option>
                <option value="10:00">10:00</option>
                <option value="11:00">11:00</option>
                <option value="12:00">12:00</option>
                <option value="13:00">13:00</option>
                <option value="14:00">14:00</option>
                <option value="15:00">15:00</option>
                <option value="16:00">16:00</option>
                <option value="17:00">17:00</option>
                <option value="18:00">18:00</option>
            </select>
        </div>
        <button class="addBtn" type="submit">일정등록</button>
    </form>
</section>
<%@ include file="index_bottom.jsp" %>