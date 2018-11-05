package com.coduck.pond.board.service;

import java.util.List;

import com.coduck.pond.board.vo.BoardSrchDto;
import com.coduck.pond.board.vo.HwBoardVo;


public interface BoardService {
	
	public List<HwBoardVo> selectBoardList (BoardSrchDto boardSrchDto);
	
}
