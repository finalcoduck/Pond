package com.coduck.pond.fileupload.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coduck.pond.fileupload.vo.FileUploadVo;

@Repository
public class FileUploadDao {
	private static final String NAMPSPACE = "Mappers.FileUploadMapper.";
	@Autowired
	private SqlSession session;
	
	public void insertFileInfo(FileUploadVo vo) {
		session.insert(NAMPSPACE+"insertFileInfo", vo);
	}
	
	public List<FileUploadVo> getFilesByGroup(int groupNum){
		return session.selectList(NAMPSPACE+"getFilesByGroup", groupNum);
	}
	
	public void deleteFile(Map<String, Object> map) {
		session.delete(NAMPSPACE+"deleteFile", map);
	}
}
