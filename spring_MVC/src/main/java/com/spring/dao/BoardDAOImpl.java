package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<BoardVO> selectBoardList( SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<BoardVO> boardList = session.selectList("Board-Mapper.selectSearchBoardList", cri, rowBounds);
		return boardList;
	}

	@Override
	public int selectSearchBoardListCount( SearchCriteria cri) throws SQLException {
		int cnt = session.selectOne("Board-Mapper.selectSearchBoardListCount", cri);
		return cnt;
	}

	@Override
	public BoardVO selectBoardByBno( int bno) throws SQLException {
		BoardVO board = session.selectOne("Board-Mapper.selectBoardByBno", bno);
		return board;
	}

	@Override
	public int selectBoardSequenceNextValue(SqlSession session) throws SQLException {
		int board_sequence = session.selectOne("Board-Mapper.selectBoardSequenceNextValue");
		return board_sequence;
	}

	@Override
	public void increaseViewCount( int bno) throws SQLException {
		session.update("Board-Mapper.increaseViewCount", bno);
	}

	@Override
	public void insertBoard( BoardVO board) throws SQLException {
		session.update("Board-Mapper.insertBoard", board);
	}

	@Override
	public void updateBoard( BoardVO board) throws SQLException {
		session.update("Board-Mapper.updateBoard", board);
	}

	@Override
	public void deleteBoard( int bno) throws SQLException {
		session.update("Board-Mapper.deleteBoard", bno);
	}

}
