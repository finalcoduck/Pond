package com.coduck.pond.fileupload.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.oauth2.GrantType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.service.FileUploadService;
import com.coduck.pond.fileupload.vo.FileListVo;
import com.coduck.pond.fileupload.vo.FileUploadVo;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	/*
	 * 단인 파일 업로드 처리
	 */
	@RequestMapping(value="/fileupload/insertfile", method=RequestMethod.POST)
	public String fileInsert(int groupNum,int refBoardNum,MultipartFile file, HttpSession session) {
		String uploadPath = session.getServletContext().getRealPath("/resources/upload");
		System.out.println("uploadPath:"+uploadPath);
		
		String orgFileName = file.getOriginalFilename(); //전송된 파일명
		String saveFileName = UUID.randomUUID()+"_"+ orgFileName; //저장할 파일명
		String fileType = FileUtils.getFileType(orgFileName);
		
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + saveFileName);
			FileCopyUtils.copy(is, fos); //spring에 있는 복사 기능
			is.close();
			fos.close();
			System.out.println("파일업로드 ~ 성공");
			
			long fileSize = file.getSize(); //파일크기 얻어오기
			FileUploadVo vo = new FileUploadVo(0, groupNum, refBoardNum, orgFileName, saveFileName, fileSize, fileType);
			System.out.println(vo);
			fileUploadService.insertFileInfo(vo); //파일 정보 인서트
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "fileupload";
	}
	
	/*
	 *  다중 파일 업로드 처리
	 */
	@RequestMapping(value="/fileupload/insertfiles", method=RequestMethod.POST)
	public String filesInsert(int groupNum,int refBoardNum, HttpSession session, MultipartHttpServletRequest mhsRequest) {
		String uploadPath = session.getServletContext().getRealPath("/resources/upload");
		System.out.println("uploadPath:"+uploadPath);
		List<MultipartFile> fileList = mhsRequest.getFiles("file"); //전송된 파일 모두 받아서 리스트에 저장
		
		int n = fileUploadService.insertFiles(fileList, groupNum, refBoardNum, uploadPath);
		return "fileupload";
	}
	
	/*
	 *  이동 컨트롤러
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response) {
		return "calendar";
	}*/
}
