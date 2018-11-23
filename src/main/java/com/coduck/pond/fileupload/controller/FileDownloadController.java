package com.coduck.pond.fileupload.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {
	//파일 다운로드
	@RequestMapping("/group/filedownload")
	public String downloadFile(String saveFileName, String orgFileName,HttpSession session, Model model) throws Exception {
		String filePath = session.getServletContext().getRealPath("/resources/upload/") + saveFileName;
		System.out.println("filePath:"+filePath);
		File ff = new File(filePath);
		if(!ff.canRead()) {
			throw new Exception("File can't read(파일을 찾을 수 없습니다)");
		}
		model.addAttribute("orgFileName", orgFileName);
		model.addAttribute("downloadFile",ff);
		return "fileDownloadView";
	}
}
