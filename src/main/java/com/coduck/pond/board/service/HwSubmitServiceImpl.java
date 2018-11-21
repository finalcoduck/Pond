package com.coduck.pond.board.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<HwSubmitVo> detailHwBoard(int boardNum) {
		return hwSubmitDao.detailHwBoard(boardNum);
	}

	@Override
	public Map<String, List<HwSubmitVo>> getSubmitList(String groupNum) {
		return hwSubmitDao.getSubmitList(groupNum);
	}
	
	
}
