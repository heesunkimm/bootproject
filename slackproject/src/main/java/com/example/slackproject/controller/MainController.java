package com.example.slackproject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.slackproject.dto.AttendDTO;
import com.example.slackproject.mapper.MainMapper;
import com.example.slackproject.mapper.SlackService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private MainMapper mapper;
	
	@Autowired
	private SlackService slackService;
	
	// 출퇴근 상태
	private void setAttentStatus(HttpServletRequest req, AttendDTO dto) {
		if (dto == null) {
	        req.setAttribute("StartWork", true);
	    } else if (dto.getStartWorkTime() != null && dto.getLeaveWorkTime() == null) {
	        req.setAttribute("LeaveWork", true);
	    } else if (dto.getStartWorkTime() != null && dto.getLeaveWorkTime() != null) {
	        req.setAttribute("ReStartWork", true);
	    }
	}
	
	@GetMapping("/index")
	public String index(HttpServletRequest req, @AuthenticationPrincipal User user) {
		AttendDTO dto = mapper.attendCheck(user.getUsername());
		setAttentStatus(req, dto);
	    return "index";
	}
	
	// 출퇴근
	@PostMapping("/attend")
	public String Attend(HttpServletRequest req, @AuthenticationPrincipal User user, @RequestParam String checkTime, 
			@RequestParam(value="attendMemo", required = false) String attendMemo) {
		try {
			// 오늘 출퇴근 여부 확인
			AttendDTO dto = mapper.attendCheck(user.getUsername());
			String userName = mapper.loginUserName(user.getUsername());
			
			if(dto == null || dto.getLeaveWorkTime() != null) {
				// 출근&재출근 처리
				Map<String, Object> params = new HashMap<>();
				params.put("userId", user.getUsername());
				params.put("startWorkTime", checkTime);
				mapper.insertAttend(params);
				
				// 슬랙 출근 알림 전송
				String[] startTime = checkTime.split(" ");
				String message = String.format("%s님이 %s에 출근하였습니다.", userName, startTime[1]);
				System.out.println(message);
				slackService.sendMessage(message);
			}else if (dto.getStartWorkTime() != null && dto.getLeaveWorkTime() == null) {
				// 퇴근처리
                Date startWorkTime = dto.getStartWorkTime();
                Date leaveWorkTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(checkTime);
                
                // 퇴근전까지의 근무시간구하기
                long workMillis = leaveWorkTime.getTime() - startWorkTime.getTime();
                long hours = TimeUnit.MILLISECONDS.toHours(workMillis);
                long mins = TimeUnit.MILLISECONDS.toMinutes(workMillis) % 60;
                String newHours = String.format("%02d:%02d", hours, mins);
                
                // 최근 출퇴근 기록 조회
                AttendDTO latestAttend = mapper.latestAttend(user.getUsername());
                String totalHours;
                
                if(latestAttend == null || latestAttend.getWorkHours() == null) {
                	totalHours = "00:00";
                }else {
                	totalHours = latestAttend.getWorkHours();
                }
                
                String[] newHourStr = newHours.split(":");
                int newMins = Integer.parseInt(newHourStr[0]) * 60 + Integer.parseInt(newHourStr[1]);
                
                // totalHours를 분으로 변환
                int existMins = 0;
                if (totalHours != null && !totalHours.isEmpty()) {
                    String[] hourStr = totalHours.split(":");
                    existMins = Integer.parseInt(hourStr[0]) * 60 + Integer.parseInt(hourStr[1]);
                }
                int totalMins = newMins + existMins; 

                // 최종 누적시간을 HH:mm 형식으로 변환
                int workHours = totalMins / 60;
                int workMins = totalMins % 60;
                totalHours = String.format("%02d:%02d", workHours, workMins);
                
                Map<String, Object> params = new HashMap<>();
                params.put("attendId", dto.getAttendId());
				params.put("leaveWorkTime", checkTime);
				params.put("attendMemo", attendMemo);
				params.put("workHours", totalHours);
                
				int res = mapper.updateAttend(params);
				if (res == 0) {
		            throw new RuntimeException("퇴근 처리 중 오류가 발생했습니다. 다시 시도해주세요.");
		        }
				
				// 슬랙 퇴근 알 전송
				String[] endTime = checkTime.split(" ");
				String message = String.format("%s님이 %s에 퇴근하였습니다. 오늘 누적 근무시간은 %s입니다.", userName, endTime[1], totalHours);
				System.out.println(message);
				slackService.sendMessage(message);
			}
			setAttentStatus(req, mapper.attendCheck(user.getUsername()));
			return "redirect:index";
		}catch(Exception e) {
			throw new RuntimeException("서비스 이용 중 문제가 발생했습니다. 잠시 후 다시 시도해주세요.");
		}
	}
}
