package com.spring.command;

import java.util.Date;

import com.spring.dto.ReplyVO;

public class ReplyRegistCommand {
	private int bno;
	private String replyer;
	private String replytext;
	
	public final int getBno() {
		return bno;
	}
	public final void setBno(int bno) {
		this.bno = bno;
	}
	public final String getReplyer() {
		return replyer;
	}
	public final void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public final String getReplytext() {
		return replytext;
	}
	public final void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public ReplyVO toReplyVO() {
		ReplyVO reply = new ReplyVO();
		reply.setBno(bno);
		reply.setReplyer(replyer);
		reply.setReplytext(replytext);
		reply.setRegdate(new Date());
		reply.setUpdatedate(new Date());
		
		return reply;
	}
}
