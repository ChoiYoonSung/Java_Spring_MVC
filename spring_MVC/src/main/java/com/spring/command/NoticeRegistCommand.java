package com.spring.command;

import java.util.Date;

import com.spring.dto.NoticeVO;

public class NoticeRegistCommand {
	private String title;		// 공지사항 제목
	private String writer;		// 공지사항 작성자
	private String content;		// 공지사항 내용
	
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getWriter() {
		return writer;
	}
	public final void setWriter(String writer) {
		this.writer = writer;
	}
	public final String getContent() {
		return content;
	}
	public final void setContent(String content) {
		this.content = content;
	}

	public NoticeVO toNoticeVO() {
		NoticeVO notice = new NoticeVO();
		notice.setTitle(this.title);
		notice.setWriter(this.writer);
		notice.setContent(this.content);
		notice.setRegdate(new Date());
		
		return notice;
	}
}
