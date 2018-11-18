package com.coduck.pond.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.HwSubmitDao;
import com.coduck.pond.board.vo.HwSubmitVo;

@Service
public class HwSubmitServiceImpl implements HwSubmitService{
	@Autowired
	HwSubmitDao hwSubmitDao;

	@Override
	public void insertSubmitBoard(HwSubmitVo hwSubmitVo) {
		hwSubmitDao.insertSubmitBoard(hwSubmitVo);
	}

	@Override
	public int updateHwScore(HwSubmitVo hwSubmitVo) {
		return hwSubmitDao.updateHwScore(hwSubmitVo);
	}	
}
