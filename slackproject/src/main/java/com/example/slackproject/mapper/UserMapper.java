package com.example.slackproject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.slackproject.dto.UserDTO;

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
	// 가입된 유저리스트
	public List<UserDTO> userList() {
		return sqlSession.selectList("userList");
	}
	// 유저상태 업데이트
	public int updateUserStatus(Map<String, Object> params) {
		return sqlSession.update("updateUserStatus", params);
	}
}