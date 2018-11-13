package com.coduck.pond.board.vo;

import java.sql.Date;

public class MemCommentDto {
	private int cmntNum;
	private int refBoardNum;
	private String cmntContent;
	private String cmntWriter;
	private Date cmntRegDate;
	private String memName;
	private String memProfilePic;
	
	public MemCommentDto() {
		// TODO Auto-generated constructor stub
	}

	public MemCommentDto(int cmntNum, int refBoardNum, String cmntContent, String cmntWriter, Date cmntRegDate,
			String memName, String memProfilePic) {
		super();
		this.cmntNum = cmntNum;
		this.refBoardNum = refBoardNum;
		this.cmntContent = cmntContent;
		this.cmntWriter = cmntWriter;
		this.cmntRegDate = cmntRegDate;
		this.memName = memName;
		this.memProfilePic = memProfilePic;
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

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemProfilePic() {
		return memProfilePic;
	}

	public void setMemProfilePic(String memProfilePic) {
		this.memProfilePic = memProfilePic;
	}

	@Override
	public String toString() {
		return "MemCommentDto [cmntNum=" + cmntNum + ", refBoardNum=" + refBoardNum + ", cmntContent=" + cmntContent
				+ ", cmntWriter=" + cmntWriter + ", cmntRegDate=" + cmntRegDate + ", memName=" + memName
				+ ", memProfilePic=" + memProfilePic + "]";
	}

	
	
}
