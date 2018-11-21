package com.coduck.pond.board.service;


import java.util.List;
import java.util.Map;

import com.coduck.pond.board.vo.HwSubmitDto;
import com.coduck.pond.board.vo.HwSubmitVo;

public interface HwSubmitService {
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo);
	
	public int updateHwScore(HwSubmitVo hwSubmitVo);
	
	public List<HwSubmitVo> detailHwBoard(int boardNum);
	
	public Map<String, List<HwSubmitDto>> getSubmitList(int hwSubmitGroupNum);
	
}
