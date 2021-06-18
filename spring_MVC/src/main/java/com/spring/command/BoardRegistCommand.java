package com.spring.command;

import java.util.Date;

import com.spring.dto.BoardVO;

public class BoardRegistCommand {
	private String title;
	private String content;
	private String writer;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public BoardVO toBoardVO() {
		BoardVO board = new BoardVO();
		board.setTitle(this.title);
		board.setContent(this.content);
		board.setWriter(this.writer);
		board.setRegdate(new Date());
		
		return board;
	}
}
