package com.coduck.pond.board.vo;

public class BoardSrchDto {
	
	/** 검색어 */
	private String srchWord;
	
	/** 다음1키값 */
	private int nxt1KeyVal;
	
	/** 페이지당건수 */
	private int pagePerCnt;
	
	/** 다음페이지존재여부 */
	private String nxtPageFl;

	public String getSrchWord() {
		return srchWord;
	}

	public void setSrchWord(String srchWord) {
		this.srchWord = srchWord;
	}

	public int getNxt1KeyVal() {
		return nxt1KeyVal;
	}

	public void setNxt1KeyVal(int nxt1KeyVal) {
		this.nxt1KeyVal = nxt1KeyVal;
	}

	public int getPagePerCnt() {
		return pagePerCnt;
	}

	public void setPagePerCnt(int pagePerCnt) {
		this.pagePerCnt = pagePerCnt;
	}

	public String getNxtPageFl() {
		return nxtPageFl;
	}

	public void setNxtPageFl(String nxtPageFl) {
		this.nxtPageFl = nxtPageFl;
	}

}
