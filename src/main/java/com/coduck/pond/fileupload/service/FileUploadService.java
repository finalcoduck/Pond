package com.coduck.pond.fileupload.service;

import java.util.List;

import com.coduck.pond.fileupload.vo.FileUploadVo;

public interface FileUploadService {
	public void insertFileInfo(FileUploadVo vo);
	public List<FileUploadVo> getFilesByGroup(int groupNum);
	public void deleteFile(String groupNum, int refBoardNum);
}
