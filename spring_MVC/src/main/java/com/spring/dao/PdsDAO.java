package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.PdsVO;

public interface PdsDAO {
	// Pds 리스트
	List<PdsVO> selectPdsList(SearchCriteria cri) throws SQLException;

	// Pds 리스트 개수
	int selectSearchPdsListCount(SearchCriteria cri) throws SQLException;

	// 선택 Pds
	PdsVO selectPdsByPno(int pno) throws SQLException;

	// 다음 시퀀스
	int selectPdsSequenceNextValue() throws SQLException;

	// 조회수
	void increaseViewCount(int pno) throws SQLException;

	// 입력
	void insertPds(PdsVO pds) throws SQLException;

	// 수정
	void updatePds(PdsVO pds) throws SQLException;

	// 삭제
	void deletePds(int pno) throws SQLException;
}
