package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardService {
	Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
	
	BoardVO getBoard(int bno) throws SQLException;
	
	BoardVO getBoardForModify(int bno) throws SQLException;
	
	void registBoard(BoardVO board) throws SQLException;
	
	void modiftyBoard(BoardVO board) throws SQLException;
	
	void removeBoard(int bno) throws SQLException;
}
