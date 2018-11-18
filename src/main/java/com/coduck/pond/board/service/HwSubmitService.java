package com.coduck.pond.board.service;


import com.coduck.pond.board.vo.HwSubmitVo;

public interface HwSubmitService {
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo);
	
	public int updateHwScore(HwSubmitVo hwSubmitVo);
}
