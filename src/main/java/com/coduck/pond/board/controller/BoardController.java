package com.coduck.pond.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.coduck.pond.board.service.BoardService;
import com.coduck.pond.board.vo.BoardSrchDto;
import com.coduck.pond.board.vo.GroupNoticeVo;
import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//그룹 게시글 조회
	@RequestMapping(value = "/board/search/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> searchBoard (@RequestBody BoardSrchDto boardSrchDto) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		
		
		map.put("boardList",boardService.selectBoardList(boardSrchDto));
		
		map.put("boardSrchDto",boardSrchDto);
		
		return map;
	}
	
	//그룹 게시글 추가
	@RequestMapping(value = "/board/insert/notice/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> insertNoticeBoard (@RequestBody GroupNoticeVo groupNoticeVo,MemDto memDto) {
		
		//글작성 권환 확인
		
		//세션에서 작성자 추가
		groupNoticeVo.setBoardWriter(memDto.getMemVo().getMemEmail());
		
		System.out.println(groupNoticeVo);
		HashMap<String,Object> resultMap = boardService.insertNoticeBoard(groupNoticeVo);
		
		return resultMap;
	}
}
