package com.coduck.pond.fileupload.vo;

import java.util.Date;

// 파일 업로드 테이블과 참조 게시글 조인 Vo

public class FileListVo {
	private int fileNum;
	private int groupNum;
	private int refBoardNum;
	private String orgFileName;
	private String saveFileName;
	private long fileSize;
	private String boardWriter;
	private String subjectTitle;
	private Date boardRegdate;
	private String fileType;
	
	public FileListVo() {
		// TODO Auto-generated constructor stub
	}

	public FileListVo(int fileNum, int groupNum, int refBoardNum, String orgFileName, String saveFileName,
			long fileSize, String boardWriter, String subjectTitle, Date boardRegdate, String fileType) {
		super();
		this.fileNum = fileNum;
		this.groupNum = groupNum;
		this.refBoardNum = refBoardNum;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.fileSize = fileSize;
		this.boardWriter = boardWriter;
		this.subjectTitle = subjectTitle;
		this.boardRegdate = boardRegdate;
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "FileListVo [fileNum=" + fileNum + ", groupNum=" + groupNum + ", refBoardNum=" + refBoardNum
				+ ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName + ", fileSize=" + fileSize
				+ ", boardWriter=" + boardWriter + ", subjectTitle=" + subjectTitle + ", boardRegdate=" + boardRegdate
				+ ", fileType=" + fileType + "]";
	}

	public int getFileNum() {
		return fileNum;
	}

	public void setFileNum(int fileNum) {
		this.fileNum = fileNum;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getRefBoardNum() {
		return refBoardNum;
	}

	public void setRefBoardNum(int refBoardNum) {
		this.refBoardNum = refBoardNum;
	}

	public String getOrgFileName() {
		return orgFileName;
	}

	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public Date getBoardRegdate() {
		return boardRegdate;
	}

	public void setBoardRegdate(Date boardRegdate) {
		this.boardRegdate = boardRegdate;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
