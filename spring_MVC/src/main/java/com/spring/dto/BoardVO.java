package com.spring.dto;

import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private int viewcnt;
	private Date regdate;
	private Date updatedate;
	
	private int replycnt; // 댓글 개수
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public final int getReplycnt() {
		return replycnt;
	}
	public final void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}
	
}
