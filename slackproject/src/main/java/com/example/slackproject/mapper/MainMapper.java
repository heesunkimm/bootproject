package com.example.slackproject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.slackproject.dto.AttendDTO;

@Service
public class MainMapper {
	@Autowired
	private SqlSession sqlSession;
	
	// 로그인 유저이름 가져오기
	public String loginUserName(String userId) {
		return sqlSession.selectOne("loginUserName", userId);
	}
	// 오늘날짜 출퇴근여부 확인
	public AttendDTO attendCheck(String userId) {
		return sqlSession.selectOne("attendCheck", userId);
	}
	// 출근
	public int insertAttend(Map<String, Object> params) {
		return sqlSession.insert("insertAttend", params);
	}
	// 퇴근
	public int updateAttend(Map<String, Object> params) {
		return sqlSession.update("updateAttend", params);
	}
	// 최근 출퇴근 기록 조회
	public AttendDTO latestAttend(String userId) {
		return sqlSession.selectOne("latestAttend", userId);
	}
	// 일정등록
	public int insertSchedule(Map<String, Object> params) {
		return sqlSession.insert("insertSchedule", params);
	}

}
