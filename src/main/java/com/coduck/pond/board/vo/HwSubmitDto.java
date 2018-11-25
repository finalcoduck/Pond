package com.coduck.pond.board.vo;

import java.util.Date;

public class HwSubmitDto {

    // 글번호
    private Integer boardNum;
    
    //이름
	private String memName;
    
    //프로필사진
    private String memProfilePic;

    // 과제글번호 그룹번호
    private Integer hwSubmitGroupNum;
    
    // 과제 제목 글제목
    private String boardTitle;

    // 과제 내용 글내용
    private String boardContent;

    // 제출자ID 작성자
    private String hwSubmitWriter;

    // 채점자ID 
    private String hwTeacherId;

    // 과제 답안 내용 글내용
    private String hwSubmitContent;
    
    // 과제 등록일 
    private Date boardRegdate;

    // 부여점수 
    private int hwSubmitScore;

    // 제출 여부 
    private char hwSubmit;
    
    public HwSubmitDto() {
	}

	public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
    }
    
    public Date getBoardRegdate() {
		return boardRegdate;
	}

	public void setBoardRegdate(Date boardRegdate) {
		this.boardRegdate = boardRegdate;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemProfilePic() {
		return memProfilePic;
	}

	public void setMemProfilePic(String memProfilePic) {
		this.memProfilePic = memProfilePic;
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
