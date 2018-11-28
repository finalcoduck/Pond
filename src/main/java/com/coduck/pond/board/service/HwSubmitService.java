package com.coduck.pond.board.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.coduck.pond.board.vo.BoardUserDto;
import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.board.vo.HwSubmitDto;
import com.coduck.pond.board.vo.HwSubmitVo;

public interface HwSubmitService {
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo);
	
	public int updateHwScore(HwSubmitVo hwSubmitVo);
	
	public HwSubmitVo detailHwBoard(HwSubmitVo hwSubmitVo);
	
	public Map<String, List<HwSubmitDto>> getSubmitList(int hwSubmitGroupNum);
	
	public int insertHw(HwSubmitVo hwSubmitVo);
	
	public BoardUserDto selectHWUserOne(HwBoardVo hwBoardVo);
	
	public HwSubmitDto detailSubmit(int boardNum);
	
}
