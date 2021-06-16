package com.spring.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.spring.command.PageMaker;
import com.spring.command.SearchCriteria;
import com.spring.dao.NoticeDAO;
import com.spring.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDAO noticeDAO;

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		// 현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기
		List<NoticeVO> noticeList = noticeDAO.selectSearchNoticeList(cri);

		// 전체 board 개수
		int totalCount = noticeDAO.selectSearchNoticeListCount(cri);

		// PageMaker 생성
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		dataMap.put("noticeList", noticeList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public NoticeVO getNotice(int nno) throws SQLException {
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		noticeDAO.increaseViewCount(nno);
		return notice;
	}

	@Override
	public NoticeVO getNoticeforModify(int nno) throws SQLException {
		NoticeVO notice = noticeDAO.selectNoticeByNno(nno);
		return notice;
	}

	@Override
	public void registNotice(NoticeVO notice) throws SQLException {
		int nno = noticeDAO.selectNoticeSequenceNextValue();
		notice.setNno(nno);
		noticeDAO.insertNotice(notice);
	}

	@Override
	public void modiftyNotice(NoticeVO notice) throws SQLException {
		noticeDAO.updateNotice(notice);
	}

	@Override
	public void removeNotice(int nno) throws SQLException {
		noticeDAO.deleteNotice(nno);
	}

}
