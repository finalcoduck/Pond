package com.coduck.pond.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coduck.pond.board.service.BoardService;
import com.coduck.pond.board.service.HwSubmitService;
import com.coduck.pond.board.vo.BoardSrchDto;
import com.coduck.pond.board.vo.BoardUserDto;
import com.coduck.pond.board.vo.GroupNoticeVo;
import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.board.vo.HwSubmitDto;
import com.coduck.pond.board.vo.HwSubmitVo;
import com.coduck.pond.core.constant.CommonConstant;
import com.coduck.pond.core.constant.ErrorCodeConstant;
import com.coduck.pond.group.service.GroupService;
import com.coduck.pond.member.vo.MemDto;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	HwSubmitService hwSubmitService;
	
	@Autowired
	private GroupService groupService;

	//과제 등록
	@RequestMapping(value = "/board/insert/homework/proc", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> insertHomeworkBoard (@RequestBody Map<String, Object> map, MemDto memDto){
		
		HwBoardVo hwBoardVo = new HwBoardVo();
		hwBoardVo.setGroupNum(Integer.parseInt((String)map.get("groupNum")));
		hwBoardVo.setBoardWriter((String)(memDto.getMemVo().getMemEmail()));
		hwBoardVo.setBoardTitle((String)(map.get("boardTitle")));
		hwBoardVo.setBoardContent((String)(map.get("boardContent")));
		hwBoardVo.setHwEndDate((String)(map.get("hwEndDate")));
		hwBoardVo.setHwMaxScore(Integer.parseInt((String)(map.get("hwMaxScore"))));
		hwBoardVo.setSubjectTitle((String)(map.get("subjectTitle")));
		
		List<String> student_list = (List<String>)map.get("student_list");
		
		HashMap<String,Object> resultMap = boardService.insertHomeworkBoard(hwBoardVo);

		HwSubmitVo hwSubmitVo = new HwSubmitVo();
		
		Integer seq_val = boardService.selectBoardSeqVal();
	
		for(int i=0; i<student_list.size(); i++) {
			hwSubmitVo.setHwSubmitGroupNum(seq_val);		
			hwSubmitVo.setHwSubmitWriter((String)student_list.get(i));
			hwSubmitVo.setHwTeacherId(memDto.getMemVo().getMemEmail());
			hwSubmitService.insertSubmitBoard(hwSubmitVo);
		}
		
		return resultMap;
	}
	
	//과제 상세
	@RequestMapping(value = "/group/view", method = {RequestMethod.GET, RequestMethod.POST})
	public String detailHwBoard(Model model, int boardNum, MemDto memDto, int groupNum) {	
	
		if(memDto.getMemGroupMap().get(groupNum) == CommonConstant.MANAGER) {
			HwBoardVo hwBoardVo = boardService.detailHomeworkBoard(boardNum);
			
			Map<String, List<HwSubmitDto>> map = hwSubmitService.getSubmitList(boardNum);
			
			BoardUserDto boardUserDto = hwSubmitService.selectHWUserOne(hwBoardVo);
			
			model.addAttribute("hwBoardVo", hwBoardVo);
			model.addAttribute("boardNum", boardNum);
			model.addAttribute("groupNum", groupNum);
			model.addAttribute("boardUserDto", boardUserDto);
			model.addAttribute("studentList", map.get("studentList"));
			
			return "/group/view-teacher";
			
		}else if(memDto.getMemGroupMap().get(groupNum) == CommonConstant.STUDENT){
			HwBoardVo hwBoardVo = boardService.detailHomeworkBoard(boardNum);
			HwSubmitVo hwSubmitVo = new HwSubmitVo();
			hwSubmitVo.setHwSubmitWriter(memDto.getMemVo().getMemEmail());
			
			hwSubmitVo.setBoardNum(boardNum);
			
			hwSubmitVo = hwSubmitService.detailHwBoard(hwSubmitVo);
			
			
			model.addAttribute("boardNum", boardNum);
			model.addAttribute("groupNum", groupNum);
			model.addAttribute("hwBoardVo", hwBoardVo);
			model.addAttribute("hwSubmitVo", hwSubmitVo);

			return "/group/view-student";
		}
		return null;
	}
	
	@RequestMapping(value = "/group/submit", method = RequestMethod.GET)
	public String detailSubmit(int boardNum, Model model) {
		HwSubmitVo hwSubmitVo = hwSubmitService.detailSubmit(boardNum);
		
		model.addAttribute("hwSubmitVo", hwSubmitVo);
		
		return "/group/submit";
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

	//과제 제출
	@RequestMapping(value = "/board/submit/homework", method = RequestMethod.POST)
	public String insertHw(HwSubmitVo hwSubmitVo, MemDto memDto, int groupNum) {
		hwSubmitVo.setHwSubmitWriter(memDto.getMemVo().getMemEmail());
		
		hwSubmitService.insertHw(hwSubmitVo);
		
		return "redirect:/group/view?groupNum=" + groupNum + "&boardNum=" + hwSubmitVo.getBoardNum();
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
	
	//채점점수 업데이트
	@RequestMapping(value = "/board/update/homework/proc", method = RequestMethod.POST)
	public String updateHwScore(HwSubmitVo hwSubmitVo, String hwBoardNum, String groupNum) {
		hwSubmitService.updateHwScore(hwSubmitVo);
		return "redirect:/group/view?groupNum=" + groupNum + "&boardNum=" + hwBoardNum;
	}
}
