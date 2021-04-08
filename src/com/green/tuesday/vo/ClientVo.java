package com.green.tuesday.vo;

public class ClientVo {
	
	// Fields
    private int indexNum;
    private String clientId;
    private String clientPassword;
    private String clientEmail;
    private String registerDate;
    private String tag;
	
    // Constructor
    public ClientVo() {}
	public ClientVo(int indexNum, String clientId, String clientPassword, String clientEmail, String registerDate,
			String tag) {
		this.indexNum = indexNum;
		this.clientId = clientId;
		this.clientPassword = clientPassword;
		this.clientEmail = clientEmail;
		this.registerDate = registerDate;
		this.tag = tag;
	}

	// Getter
	public int getIndexNum() {
		return indexNum;
	}
	public String getClientId() {
		return clientId;
	}
	public String getClientPassword() {
		return clientPassword;
	}
	public String getClientEmail() {
		return clientEmail;
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
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
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
		return "ClientVo [indexNum=" + indexNum + ", clientId=" + clientId + ", clientPassword=" + clientPassword
				+ ", clientEmail=" + clientEmail + ", registerDate=" + registerDate + ", tag=" + tag + "]";
	}
      
}
