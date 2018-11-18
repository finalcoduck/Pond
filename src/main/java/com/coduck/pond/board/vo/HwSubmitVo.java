package com.coduck.pond.board.vo;

public class HwSubmitVo {

    // 글번호
    private Integer boardNum;

    // 과제글번호 그룹번호
    private Integer hwSubmitGroupNum;

    // 제출자ID 작성자
    private String hwSubmitWriter;

    // 채점자ID 
    private String hwTeacherId;

    // 과제 답안 내용 글내용
    private String hwSubmitContent;

    // 부여점수 
    private int hwSubmitScore;

    // 제출 여부 
    private char hwSubmit;
    
    public HwSubmitVo() {
	}

	public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
    }

    public Integer getHwSubmitGroupNum() {
        return hwSubmitGroupNum;
    }

    public void setHwSubmitGroupNum(Integer hwSubmitGroupNum) {
        this.hwSubmitGroupNum = hwSubmitGroupNum;
    }

    public String getHwSubmitWriter() {
        return hwSubmitWriter;
    }

    public void setHwSubmitWriter(String hwSubmitWriter) {
        this.hwSubmitWriter = hwSubmitWriter;
    }

    public String getHwTeacherId() {
        return hwTeacherId;
    }

    public void setHwTeacherId(String hwTeacherId) {
        this.hwTeacherId = hwTeacherId;
    }

    public String getHwSubmitContent() {
        return hwSubmitContent;
    }

    public void setHwSubmitContent(String hwSubmitContent) {
        this.hwSubmitContent = hwSubmitContent;
    }

    public int getHwSubmitScore() {
        return hwSubmitScore;
    }

    public void setHwSubmitScore(int hwSubmitScore) {
        this.hwSubmitScore = hwSubmitScore;
    }

    public char getHwSubmit() {
        return hwSubmit;
    }

    public void setHwSubmit(char hwSubmit) {
        this.hwSubmit = hwSubmit;
    }

	@Override
	public String toString() {
		return "HwSubmitVo [boardNum=" + boardNum + ", hwSubmitGroupNum=" + hwSubmitGroupNum + ", hwSubmitWriter="
				+ hwSubmitWriter + ", hwTeacherId=" + hwTeacherId + ", hwSubmitContent=" + hwSubmitContent
				+ ", hwSubmitScore=" + hwSubmitScore + ", hwSubmit=" + hwSubmit + "]";
	}
    
}
