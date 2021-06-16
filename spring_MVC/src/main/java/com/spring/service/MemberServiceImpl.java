package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.spring.command.Criteria;
import com.spring.command.PageMaker;
import com.spring.command.SearchCriteria;
import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundException;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberById(id);
		if (member == null)
			throw new NotFoundException();
		if (!pwd.equals(member.getPwd()))
			throw new InvalidPasswordException();
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memList = memberDAO.selectMemberList();
		return memList;
	}

	@Override
	public List<MemberVO> getMemberList(Criteria cri) throws SQLException {
		List<MemberVO> memList = memberDAO.selectMemberList(cri);
		return memList;
	}

	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(cri));

		List<MemberVO> memList = memberDAO.selectMemberList(cri);

		dataMap.put("memList", memList);
		dataMap.put("pageMaker", pageMaker);
		return dataMap;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}

	@Override
	public void disabled(String id) throws SQLException {
		memberDAO.disabledMember(id);
	}

	@Override
	public void enabled(String id) throws SQLException {
		memberDAO.enabledMember(id);
	}

}
