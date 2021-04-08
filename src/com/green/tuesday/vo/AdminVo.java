package com.green.tuesday.vo;

public class AdminVo {
	
	// Fields
	private int indexNum;
    private String adminId;
    private String adminPassword;
    private String registerDate;
    private String tag;
    
    // Constructor
	public AdminVo() {}
	public AdminVo(int indexNum, String adminId, String adminPassword, String registerDate, String tag) {
		this.indexNum = indexNum;
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.registerDate = registerDate;
		this.tag = tag;
	}
	
	// Getter
	public int getIndexNum() {
		return indexNum;
	}
	public String getAdminId() {
		return adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public String getTag() {
		return tag;
	}
	
	// Setter
	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	// toString
	@Override
	public String toString() {
		return "AdminVo [indexNum=" + indexNum + ", adminId=" + adminId + ", adminPassword=" + adminPassword
				+ ", registerDate=" + registerDate + ", tag=" + tag + "]";
	}
      
}
