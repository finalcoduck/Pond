package com.coduck.pond.fileupload.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.dao.FileUploadDao;
import com.coduck.pond.fileupload.vo.FileListVo;
import com.coduck.pond.fileupload.vo.FileUploadVo;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
	private FileUploadDao fileUploadDao;
	
	public void insertFileInfo(FileUploadVo vo) {
		fileUploadDao.insertFileInfo(vo);
	}
	
	public List<FileListVo> getFilesByGroup(int groupNum){
		List<FileListVo> fileList = fileUploadDao.getFilesByGroup(groupNum);
		
		return fileList;
	}
	
	public void deleteFile(int fileNum) {
		fileUploadDao.deleteFile(fileNum);
	}
	
	//다중 파일 업로드 로직
	@Transactional
	public int insertFiles(List<MultipartFile> fileList, int groupNum, int refBoardNum, String uploadPath) {
		for (MultipartFile file : fileList) {
			if(file.getOriginalFilename() == null || file.getOriginalFilename() == "") {
				continue; //클라이언트가 아무 파일도 전송하지 않았을시 처리 
			}
			String orgFileName = file.getOriginalFilename(); //전송된 파일명
			String saveFileName = UUID.randomUUID()+"_"+ orgFileName; //저장할 파일명
			String fileType = FileUtils.getFileType(orgFileName);
			try {
				InputStream is = file.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "//" + saveFileName);
				FileCopyUtils.copy(is, fos); //spring에 있는 복사 기능
				is.close();
				fos.close();
				
				long fileSize = file.getSize(); //파일크기 얻어오기
				FileUploadVo vo = new FileUploadVo(0, groupNum, refBoardNum, orgFileName, saveFileName, fileSize, fileType);
				System.out.println(vo);
				fileUploadDao.insertFileInfo(vo); //파일 정보 인서트
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return -1;
			}
		}
		return 1;
	}

	@Override
	public FileUploadVo getFileByNum(int fileNum) {
		return fileUploadDao.getFileByNum(fileNum);
	}
}
