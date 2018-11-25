package com.coduck.pond.fileupload.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.service.FileUploadService;
import com.coduck.pond.fileupload.vo.FileListVo;
import com.coduck.pond.group.vo.GroupVo;

@Controller
public class FileListController {
	@Autowired
	private FileUploadService fileUploadService;
	//fileupload/filelist
	
	@RequestMapping(value = "/group/filelist", method = RequestMethod.GET)
	public String fileList(Model model, int groupNum) {
		GroupVo groupVo = new GroupVo();
		groupVo.setGroupNum(groupNum);
		List<FileListVo> list = fileUploadService.getFilesByGroup(groupNum);
		// 파일 사이즈 KB 혹은 MB 단위로 변환
		for (FileListVo vo : list) {
			long fileSize = vo.getFileSize();
			long newFileSize = FileUtils.changeFileSize(fileSize);
			vo.setFileSize(newFileSize);
		}
		model.addAttribute("fileList",list);
		model.addAttribute("groupVo", groupVo);
		return "/group/file-list";
	}
	
	@RequestMapping(value = "/group/filelist/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap searchFileList(@RequestBody HwBoardVo hwBoardVo) {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		
		
		List<FileListVo> list = fileUploadService.getFilesByGroupBoard(hwBoardVo);
		// 파일 사이즈 KB 혹은 MB 단위로 변환
		for (FileListVo vo : list) {
			long fileSize = vo.getFileSize();
			long newFileSize = FileUtils.changeFileSize(fileSize);
			vo.setFileSize(newFileSize);
		}
		resultMap.put("fileList", list);
		
		return resultMap;
	}
}
