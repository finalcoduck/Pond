package com.coduck.pond.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.HwSubmitDao;
import com.coduck.pond.board.vo.HwSubmitDto;
import com.coduck.pond.board.vo.HwSubmitVo;
import com.coduck.pond.core.constant.ErrorCodeConstant;

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
	public Map<String, List<HwSubmitDto>> getSubmitList(int hwSubmitGroupNum) {
		return hwSubmitDao.getSubmitList(hwSubmitGroupNum);
	}

	@Override
	public HashMap<String, Object> insertHw(HwSubmitVo hwSubmitVo) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		hwSubmitDao.insertHw(hwSubmitVo);
		
		resultMap.put(ErrorCodeConstant.ERR_C_KEY,ErrorCodeConstant.SUCCESS);
		
		return resultMap;
	}
	
	
}
