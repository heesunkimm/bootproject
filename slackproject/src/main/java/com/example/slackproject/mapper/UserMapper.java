package com.example.slackproject.mapper;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
	@Autowired
	private SqlSession sqlSession;

	// 아이디 중복확인
	public int idCheck(String userId) {
		return sqlSession.selectOne("idCheck", userId);
	}
	
	// 회원가입
	public int joinUser(Map<String, Object> params) {
		return sqlSession.insert("joinUser", params);
	}
}