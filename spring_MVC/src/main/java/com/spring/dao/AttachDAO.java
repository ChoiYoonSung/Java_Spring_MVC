package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.AttachVO;

public interface AttachDAO {
	List<AttachVO> selectAttachByPno(int pno) throws SQLException;

	AttachVO selectAttachByAno(int ano) throws SQLException;

	void insertAttach(AttachVO attach) throws SQLException;

	void deleteAttach(int ano) throws SQLException;

	void deleteAllAttach(int pno) throws SQLException;
}
