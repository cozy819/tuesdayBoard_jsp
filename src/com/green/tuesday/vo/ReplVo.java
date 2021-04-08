package com.green.tuesday.vo;

public class ReplVo {
	
	// Fields
	private int replNum;
    private int songNum;
    private String replWriter;
    private String replContent;
    private String registerDate;
	
    // Constructor
    public ReplVo() {}
	public ReplVo(int replNum, int songNum, String replWriter, String replContent, String registerDate) {
		this.replNum = replNum;
		this.songNum = songNum;
		this.replWriter = replWriter;
		this.replContent = replContent;
		this.registerDate = registerDate;
	}
	
	// Getter
	public int getReplNum() {
		return replNum;
	}
	public int getSongNum() {
		return songNum;
	}
	public String getReplWriter() {
		return replWriter;
	}
	public String getReplContent() {
		return replContent;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	
	// Setter
	public void setReplNum(int replNum) {
		this.replNum = replNum;
	}
	public void setSongNum(int songNum) {
		this.songNum = songNum;
	}
	public void setReplWriter(String replWriter) {
		this.replWriter = replWriter;
	}
	public void setReplContent(String replContent) {
		this.replContent = replContent;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "ReplVo [replNum=" + replNum + ", songNum=" + songNum + ", replWriter=" + replWriter + ", replContent="
				+ replContent + ", registerDate=" + registerDate + "]";
	}
    
    
}
