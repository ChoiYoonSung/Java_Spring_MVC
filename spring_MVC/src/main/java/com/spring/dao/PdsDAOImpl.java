package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchCriteria;
import com.spring.dto.PdsVO;

public class PdsDAOImpl implements PdsDAO {

	private SqlSession session;

	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<PdsVO> selectPdsList(SearchCriteria cri) throws SQLException {
		int offset = cri.getStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<PdsVO> pdsList = session.selectList("Pds-Mapper.selectSearchPdsList", cri, rowBounds);
		return pdsList;
	}

	@Override
	public int selectSearchPdsListCount(SearchCriteria cri) throws SQLException {
		int cnt = session.selectOne("Pds-Mapper.selectSearchPdsListCount", cri);
		return cnt;
	}

	@Override
	public PdsVO selectPdsByPno(int pno) throws SQLException {
		PdsVO pds = session.selectOne("Pds-Mapper.selectPdsByPno", pno);
		return pds;
	}

	@Override
	public int selectPdsSequenceNextValue() throws SQLException {
		int pds_sequence = session.selectOne("Pds-Mapper.selectPdsSequenceNextValue");
		return pds_sequence;
	}

	@Override
	public void increaseViewCount(int pno) throws SQLException {
		session.update("Pds-Mapper.increaseViewCount", pno);
	}

	@Override
	public void insertPds(PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.insertPds", pds);
	}

	@Override
	public void updatePds(PdsVO pds) throws SQLException {
		session.update("Pds-Mapper.updatePds", pds);
	}

	@Override
	public void deletePds(int pno) throws SQLException {
		session.update("Pds-Mapper.deletePds", pno);
	}

}
