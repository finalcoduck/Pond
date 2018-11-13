package com.coduck.pond.board.vo;

import java.sql.Date;

public class CommentVo {
	private int cmntNum;
	private int refBoardNum;
	private String cmntContent;
	private String cmntWriter;
	private Date cmntRegDate;
	
	public CommentVo() {
		// TODO Auto-generated constructor stub
	}

	public CommentVo(int cmntNum, int refBoardNum, String cmntContent, String cmntWriter, Date cmntRegDate) {
		super();
		this.cmntNum = cmntNum;
		this.refBoardNum = refBoardNum;
		this.cmntContent = cmntContent;
		this.cmntWriter = cmntWriter;
		this.cmntRegDate = cmntRegDate;
	}

	public int getCmntNum() {
		return cmntNum;
	}

	public void setCmntNum(int cmntNum) {
		this.cmntNum = cmntNum;
	}

	public int getRefBoardNum() {
		return refBoardNum;
	}

	public void setRefBoardNum(int refBoardNum) {
		this.refBoardNum = refBoardNum;
	}

	public String getCmntContent() {
		return cmntContent;
	}

	public void setCmntContent(String cmntContent) {
		this.cmntContent = cmntContent;
	}

	public String getCmntWriter() {
		return cmntWriter;
	}

	public void setCmntWriter(String cmntWriter) {
		this.cmntWriter = cmntWriter;
	}

	public Date getCmntRegDate() {
		return cmntRegDate;
	}

	public void setCmntRegDate(Date cmntRegDate) {
		this.cmntRegDate = cmntRegDate;
	}

	@Override
	public String toString() {
		return "CommentVo [cmntNum=" + cmntNum + ", refBoardNum=" + refBoardNum + ", cmntContent=" + cmntContent
				+ ", cmntWriter=" + cmntWriter + ", cmntRegDate=" + cmntRegDate + "]";
	}

}
