package com.coduck.pond.fileupload.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.core.utils.GetMemDtoUtility;
import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.service.FileUploadService;
import com.coduck.pond.fileupload.vo.FileUploadVo;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.group.vo.GroupVo;
import com.coduck.pond.member.service.ProfileService;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private GroupService groupService;
	
	/*
	 *  이동 컨트롤러
	 */
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpServletResponse response) {
		return "fileupload";
	}*/
	
	/*
	 * 단일 파일 업로드 처리
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
	 * 프로필 사진 단일 업로드 처리
	 */
	@RequestMapping(value="/fileupload/insert-profile-pic", method=RequestMethod.POST)
	public String file(MultipartFile file, HttpSession session, String email) {
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/mem-photo");
		System.out.println("uploadPath:"+uploadPath);
		
		String orgFileName = file.getOriginalFilename(); //전송된 파일명
		String saveFileName = UUID.randomUUID()+"_"+ orgFileName; //저장할 파일명
		
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + saveFileName);
			FileCopyUtils.copy(is, fos); //spring에 있는 복사 기능
			is.close();
			fos.close();
			System.out.println("파일업로드 ~ 성공");
			
			profileService.updatePic(email, saveFileName);
			MemDto memDto = (MemDto)session.getAttribute(CommonConstant.USER_SESSION_KEY);
			memDto.getMemVo().setMemProfilePic(saveFileName);
			session.setAttribute(CommonConstant.USER_SESSION_KEY, memDto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/member/profile";
	}
	
	/*
	 * 그룹 사진 파일 업로드 처리
	 */
	@RequestMapping(value="/fileupload/group-pic-upload", method=RequestMethod.POST)
	public String groupFile(MultipartFile file, HttpSession session, GroupVo groupVo, MemDto memDto) {
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/group-photo");
		System.out.println("uploadPath:"+uploadPath);
		
		String orgFileName = file.getOriginalFilename(); //전송된 파일명
		String saveFileName = UUID.randomUUID()+"_"+ orgFileName; //저장할 파일명
		
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(uploadPath + "//" + saveFileName);
			FileCopyUtils.copy(is, fos); //spring에 있는 복사 기능
			is.close();
			fos.close();
			
			groupVo.setGroupImage(saveFileName); // 저장된 파일명으로 디비저장
			groupService.insertGorup(groupVo);
			//세션 업데이트
			Map<Integer, Character> memGroupMap = profileService.getMemberGroupInfo(memDto.getMemVo().getMemEmail());
			MemDto newMemDto = GetMemDtoUtility.getMemDto(memDto.getMemVo(), memGroupMap);
			session.setAttribute(CommonConstant.USER_SESSION_KEY, newMemDto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "forward:/selectgroup/index";
	}
}
