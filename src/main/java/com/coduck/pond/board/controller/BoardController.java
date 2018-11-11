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
import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.core.constant.ErrorCodeConstant;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/board/insert/homework/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> insertHomeworkBoard (@RequestBody HwBoardVo hwBoardVo, MemDto memDto){
		hwBoardVo.setBoardWriter(memDto.getMemVo().getMemEmail());
		
		HashMap<String,Object> resultMap = boardService.insertHomeworkBoard(hwBoardVo);
		
		return resultMap;
	}
	
	
	//그룹 게시글 조회
	@RequestMapping(value = "/board/search/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> searchBoard (@RequestBody BoardSrchDto boardSrchDto) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		
		
		map.put("boardList",boardService.selectBoardList(boardSrchDto));
		
		map.put("boardSrchDto",boardSrchDto);
		
		return map;
	}
	
	//그룹 공지 게시글 추가
	@RequestMapping(value = "/board/insert/notice/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> insertNoticeBoard (@RequestBody GroupNoticeVo groupNoticeVo,MemDto memDto) {
		
		//글작성 권환 확인
		
		//세션에서 작성자 추가
		groupNoticeVo.setBoardWriter(memDto.getMemVo().getMemEmail());
		
		System.out.println(groupNoticeVo);
		HashMap<String,Object> resultMap = boardService.insertNoticeBoard(groupNoticeVo);
		
		return resultMap;
	}
	
		//그룹 게시물 삭제
		@RequestMapping(value = "/board/delete/proc", method = RequestMethod.POST)
		public @ResponseBody HashMap<String,Object> deleteBoard (@RequestBody GroupNoticeVo groupNoticeVo,MemDto memDto) {
			
			HashMap<String,Object> resultMap = new HashMap<String, Object>();
			
			//글삭제 권환 확인
			
			//보드 타입 확인
			if(groupNoticeVo.getBoardType()==CommonConstant.NOTICE) {
				return boardService.deleteNoticeBoard(groupNoticeVo.getBoardNum());
			}else if(groupNoticeVo.getBoardType()==CommonConstant.HOMEWORK) {
				return boardService.deleteHWBoard(groupNoticeVo.getBoardNum());
			}
			resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.FAILURE);
			
			return resultMap;
		}
}
