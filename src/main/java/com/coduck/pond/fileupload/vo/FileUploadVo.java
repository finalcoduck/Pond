package com.coduck.pond.fileupload.vo;

public class FileUploadVo {
	private int fileNum;
	private int groupNum;
	private int refBoardNum;
	private String orgFileName;
	private String saveFileName;
	private long fileSize;
	
	public FileUploadVo() {
		// TODO Auto-generated constructor stub
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

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public FileUploadVo(int fileNum, int groupNum, int refBoardNum, String orgFileName, String saveFileName,
			long fileSize) {
		super();
		this.fileNum = fileNum;
		this.groupNum = groupNum;
		this.refBoardNum = refBoardNum;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "FileUploadController [fileNum=" + fileNum + ", groupNum=" + groupNum + ", refBoardNum=" + refBoardNum
				+ ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName + ", fileSize=" + fileSize + "]";
	}
	
	
}
