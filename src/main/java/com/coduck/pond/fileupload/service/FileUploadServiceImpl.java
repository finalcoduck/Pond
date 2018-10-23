package com.coduck.pond.fileupload.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.fileupload.dao.FileUploadDao;
import com.coduck.pond.fileupload.vo.FileUploadVo;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	@Autowired
	private FileUploadDao fileUploadDao;
	
	public void insertFileInfo(FileUploadVo vo) {
		fileUploadDao.insertFileInfo(vo);
	}
	
	public List<FileUploadVo> getFilesByGroup(int groupNum){
		return fileUploadDao.getFilesByGroup(groupNum);
	}
	
	public void deleteFile(String groupNum, int refBoardNum) {
		Map<String, Object> map = new HashMap<>();
		map.put("groupNum", groupNum);
		map.put("refBoardNum", refBoardNum);
		fileUploadDao.deleteFile(map);
	}
}
