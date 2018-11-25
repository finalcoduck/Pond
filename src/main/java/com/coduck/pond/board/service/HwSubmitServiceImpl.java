package com.coduck.pond.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.HwBoardDao;
import com.coduck.pond.board.dao.HwSubmitDao;
import com.coduck.pond.board.vo.BoardUserDto;
import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.board.vo.HwSubmitDto;
import com.coduck.pond.board.vo.HwSubmitVo;
import com.coduck.pond.core.constant.ErrorCodeConstant;

@Service
public class HwSubmitServiceImpl implements HwSubmitService{
	@Autowired
	HwSubmitDao hwSubmitDao;
	
	@Autowired
	HwBoardDao hwBoardDao;

	@Override
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo) {
		hwSubmitDao.insertSubmitBoard(hwSubmitVo);
	}

	@Override
	public int updateHwScore(HwSubmitVo hwSubmitVo) {
		return hwSubmitDao.updateHwScore(hwSubmitVo);
	}

	@Override
	public HwSubmitVo detailHwBoard(HwSubmitVo hwSubmitVo) {
		return hwSubmitDao.detailHwBoard(hwSubmitVo);
	}

	@Override
	public Map<String, List<HwSubmitDto>> getSubmitList(int hwSubmitGroupNum) {
		return hwSubmitDao.getSubmitList(hwSubmitGroupNum);
	}

	@Override
	public int insertHw(HwSubmitVo hwSubmitVo) {
		return hwSubmitDao.insertHw(hwSubmitVo);
	}

	@Override
	public BoardUserDto selectHWUserOne(HwBoardVo hwBoardVo) {
		return hwBoardDao.selectHWUserOne(hwBoardVo);
	}

	@Override
	public HwSubmitDto detailSubmit(int boardNum) {
		return hwSubmitDao.detailSubmit(boardNum);
	}
	
	
}
