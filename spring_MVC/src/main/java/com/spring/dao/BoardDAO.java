package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList(SearchCriteria cri) throws SQLException;

	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;

	BoardVO selectBoardByBno(int bno) throws SQLException;

	int selectBoardSequenceNextValue(SqlSession session) throws SQLException;

	void increaseViewCount(int bno) throws SQLException;

	void insertBoard(BoardVO board) throws SQLException;

	void updateBoard(BoardVO board) throws SQLException;

	void deleteBoard(int bno) throws SQLException;
}
