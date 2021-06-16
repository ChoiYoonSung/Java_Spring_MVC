package com.spring.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.command.SearchCriteria;
import com.spring.dto.ReplyVO;

public interface ReplyService {
	Map<String, Object> getReplyList(int bno, SearchCriteria cri) throws SQLException;
	
	int getReplyListCount(int bno) throws SQLException;
	
	void registReply(ReplyVO reply) throws SQLException;
	void modifyReply(ReplyVO reply) throws SQLException;
	void deleteReply(int rno) throws SQLException;
}
