package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public interface PdsService {
	// Pds 전체 리스트
	Map<String, Object> getPdsList(SearchCriteria cri) throws SQLException;
	
	// Pds 정보(조회)
	PdsVO getPds(int pno) throws SQLException;
	
	// Pds 정보(조회수 증가)
	PdsVO read(int pno) throws SQLException;
	
	// 등록
	void registPds(PdsVO pds) throws SQLException;
	
	// 수정
	void modiftyPds(PdsVO pds) throws SQLException;
	
	// 삭제
	void removePds(int pno) throws SQLException;
	
	AttachVO getAttachByAno(int ano) throws SQLException;
	
	void removeAttachByAno(int ano) throws SQLException;
}
