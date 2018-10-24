package com.coduck.pond.fileupload.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.service.FileUploadService;
import com.coduck.pond.fileupload.vo.FileUploadVo;

@Controller
public class FileDeleteController {
	@Autowired
	private FileUploadService fileUploadService;
	
	/*
	 *  파일 삭제 처리 (실제 경로 삭제까지)
	 */
	@RequestMapping(value="/fileupload/deletefile", method=RequestMethod.GET)
	public String deleteFiles(int fileNum, HttpSession session) {
		FileUploadVo vo = fileUploadService.getFileByNum(fileNum);
		String fileName = vo.getSaveFileName();
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/");
		String filePath = uploadPath + fileName; // 파일 실제 경로
		
		if(FileUtils.deleteFile(filePath)) {
			System.out.println("성공시");
			try {
				fileUploadService.deleteFile(fileNum);
			}catch (Exception e) {
				System.out.println("디비만 실패");
			}
		}else {
			System.out.println("실패");
		}
		
		return "fileupload";
	}
}
