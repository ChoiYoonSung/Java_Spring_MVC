package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.spring.command.PageMaker;
import com.spring.command.SearchCriteria;
import com.spring.dao.AttachDAO;
import com.spring.dao.PdsDAO;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public class PdsServiceImpl implements PdsService {

	private PdsDAO pdsDAO;

	public void setPdsDAO(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}

	private AttachDAO attachDAO;

	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}

	@Override
	public Map<String, Object> getPdsList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기
		List<PdsVO> pdsList = pdsDAO.selectPdsList(cri);

		// 전체 pds 개수
		int totalCount = pdsDAO.selectSearchPdsListCount(cri);

		// PageMaker 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		dataMap.put("pdsList", pdsList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		// 조회수 상승

		addAttachList(pds);

		return pds;
	}

	@Override
	public PdsVO read(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		pdsDAO.increaseViewCount(pno);

		addAttachList(pds);
		return pds;
	}

	// 등록
	@Override
	public void registPds(PdsVO pds) throws SQLException {
		int pno = pdsDAO.selectPdsSequenceNextValue();
		pds.setPno(pno);
		pdsDAO.insertPds(pds);

		if (pds.getAttachList() != null)
			for (AttachVO attach : pds.getAttachList()) {
				attach.setPno(pno);
				attach.setAttacher(pds.getWriter());
				attachDAO.insertAttach(attach);
			}
	}

	// 수정
	@Override
	public void modiftyPds(PdsVO pds) throws SQLException {
		pdsDAO.updatePds(pds);

		if (pds.getAttachList() != null)
			for (AttachVO attach : pds.getAttachList()) {
				attach.setPno(pds.getPno());
				attach.setAttacher(pds.getWriter());
				attachDAO.insertAttach(attach);
			}
	}

	// 삭제
	@Override
	public void removePds(int pno) throws SQLException {
		pdsDAO.deletePds(pno);
	}

	// Attach

	@Override
	public AttachVO getAttachByAno(int ano) throws SQLException {
		AttachVO attach = attachDAO.selectAttachByAno(ano);
		return attach;
	}

	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		attachDAO.deleteAttach(ano);
	}

	private void addAttachList(PdsVO pds) throws SQLException {

		if (pds == null)
			return;

		int pno = pds.getPno();
		List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
		pds.setAttachList(attachList);
	}
}
