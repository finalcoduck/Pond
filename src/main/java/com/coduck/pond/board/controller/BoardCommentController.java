package com.coduck.pond.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.board.service.CommentService;
import com.coduck.pond.board.vo.CommentVo;
import com.coduck.pond.board.vo.MemCommentDto;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class BoardCommentController {
	@Autowired
	private CommentService commentSerivce;
	
	@RequestMapping(value="/board/insert/comment/proc", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody Map<String, Object> insertComment(@RequestBody CommentVo commentVo){
		Map<String, Object> map = new HashMap<>();
		try {
		commentSerivce.insertComment(commentVo);
		map.put("msg", "success");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("msg", "fail");
		}
		return map;
	}
	
	@RequestMapping("/board/get-comment/proc")
	public @ResponseBody Map<String, Object> getMemComment(String refBoardNum, MemDto memDto){
		Map<String, Object> map = new HashMap<>();
		List<MemCommentDto> list = commentSerivce.getMemComment(refBoardNum);
		map.put("list", list);
		map.put("memEmail", memDto.getMemVo().getMemEmail());
		return map;
	}
	
	@RequestMapping(value="/board/comment/delete/proc", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> deleteComment(String cmntNum){
		Map<String, Object> map = new HashMap<>();
		try {
		commentSerivce.deleteComment(Integer.parseInt(cmntNum));
		map.put("msg", "success");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("msg", "fail");
		}
		return map;
	}
}
