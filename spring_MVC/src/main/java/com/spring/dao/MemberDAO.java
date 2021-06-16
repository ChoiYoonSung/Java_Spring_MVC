package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.command.Criteria;
import com.spring.command.SearchCriteria;
import com.spring.dto.MemberVO;

public interface MemberDAO {
	MemberVO selectMemberById(String id) throws SQLException;

	List<MemberVO> selectMemberList() throws SQLException; // 전체 조회
	List<MemberVO> selectMemberList(Criteria cri) throws SQLException; // 페이징
	List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException; // 검색

	int selectMemberListCount(SearchCriteria cri) throws SQLException;

	public void insertMember(MemberVO member) throws SQLException; // 회원등록

	public void updateMember(MemberVO member) throws SQLException; // 회원수정

	public void deleteMember(String id) throws SQLException; // 회원삭제

	public void disabledMember(String id) throws SQLException; // 회원 사용 비활성

	public void enabledMember(String id) throws SQLException; // 회원 사용 활성
}
