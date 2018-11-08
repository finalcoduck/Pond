package com.coduck.pond.fileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coduck.pond.core.utils.file.FileUtils;
import com.coduck.pond.fileupload.service.FileUploadService;
import com.coduck.pond.fileupload.vo.FileListVo;

@Controller
public class FileListController {
	@Autowired
	private FileUploadService fileUploadService;
	//fileupload/filelist
	@RequestMapping(value = "/group/filelist", method = RequestMethod.GET)
	public String fileList(Model model, @RequestParam(value="groupNum", defaultValue="30") int groupNum) {
		List<FileListVo> list = fileUploadService.getFilesByGroup(groupNum);
		// 파일 사이즈 KB 혹은 MB 단위로 변환
		for (FileListVo vo : list) {
			long fileSize = vo.getFileSize();
			long newFileSize = FileUtils.changeFileSize(fileSize);
			vo.setFileSize(newFileSize);
		}
		model.addAttribute("fileList",list);
		return "/group/file-list";
	}
}
