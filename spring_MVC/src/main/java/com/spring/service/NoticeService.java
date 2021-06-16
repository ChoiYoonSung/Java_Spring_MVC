package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.NoticeVO;

public interface NoticeService {
	// 목록 조회
	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	NoticeVO getNotice(int nno) throws SQLException;
	
	NoticeVO getNoticeforModify(int nno) throws SQLException;
	
	void registNotice(NoticeVO notice) throws SQLException;
	
	void modiftyNotice(NoticeVO notice) throws SQLException;
	
	void removeNotice(int nno) throws SQLException;
}
