package cn.atc.pojo;

import java.util.Date;

public class LoginLog {
	private int id;
	private String loginAddress;
	private String loginIP;
	private Date loginTime;
	private String loginName;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginAddress() {
		return loginAddress;
	}
	public void setLoginAddress(String loginAddress) {
		this.loginAddress = loginAddress;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
