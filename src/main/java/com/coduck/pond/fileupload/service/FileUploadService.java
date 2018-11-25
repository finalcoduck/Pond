package com.coduck.pond.fileupload.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.fileupload.vo.FileListVo;
import com.coduck.pond.fileupload.vo.FileUploadVo;

public interface FileUploadService {
	public void insertFileInfo(FileUploadVo vo);
	public List<FileListVo> getFilesByGroup(int groupNum);
	public void deleteFile(int fileNum);
	public int insertFiles(List<MultipartFile> fileList, int groupNum, int refBoardNum, String uploadPath);
	public List<FileListVo> getFilesByGroupBoard(HwBoardVo hwBoardVo);
	public FileUploadVo getFileByNum(int fileNum);
}
