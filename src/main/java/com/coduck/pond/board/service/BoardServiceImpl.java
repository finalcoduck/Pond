package com.coduck.pond.board.service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coduck.pond.board.dao.HwBoardDao;
import com.coduck.pond.board.dao.NoticeDao;
import com.coduck.pond.board.vo.BoardSrchDto;
import com.coduck.pond.board.vo.HwBoardVo;
import com.coduck.pond.core.constant.CommonConstant;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	HwBoardDao hwBoardDao;
	
	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public List<HwBoardVo> selectBoardList(BoardSrchDto boardSrchDto) {
		
		//과제게시물과 공지 게시물을 불러와 리스트 하나에 합침
		List<HwBoardVo> boardList = hwBoardDao.selectHwBoardList(boardSrchDto); 
		boardList.addAll(noticeDao.selectNoticeList(boardSrchDto));
		
		// 게시물 번호 순으로 정렬
		Collections.sort(boardList,new Comparator<HwBoardVo>(){
			@Override
			public int compare(HwBoardVo o1, HwBoardVo o2) {
				return o2.getBoardNum().compareTo(o1.getBoardNum());
			}
		});
		
		int Nxt1KeyVal = boardSrchDto.getNxt1KeyVal();
		
		// 다음으로 불러올 페이지가 있는 경우
		if(boardList.size()>CommonConstant.MAX_BOARD_COUNT*Nxt1KeyVal) {
			
			boardList = boardList.subList(CommonConstant.MAX_BOARD_COUNT*(Nxt1KeyVal-1),CommonConstant.MAX_BOARD_COUNT*Nxt1KeyVal);
			boardSrchDto.setNxt1KeyVal(Nxt1KeyVal+1);			
			boardSrchDto.setNxtPageFl(CommonConstant.TRUE);
			
		}else { 
			// 다음으로 불러올 페이지가 없는 경우
			boardList = boardList.subList(CommonConstant.MAX_BOARD_COUNT*(Nxt1KeyVal-1),boardList.size());
			boardSrchDto.setNxtPageFl(CommonConstant.FALSE);
		}
		
		return boardList;
	}

}
