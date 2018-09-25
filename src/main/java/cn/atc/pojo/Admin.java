package cn.atc.pojo;

import java.util.Date;


public class Admin {
	private long id;
	private String name;
	private String loginName;
	private String password;
	private String address;
	private String gender;
	private String phone;
	private String cardId;
	private Integer loginNameModifyCount;
	private Integer deptChildId;
	private Date entryTime;

	private ChildDept childdept;// 该管理员所属的子部门

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public Integer getDeptChildId() {
		return deptChildId;
	}

	public void setDeptChildId(Integer deptChildId) {
		this.deptChildId = deptChildId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ChildDept getChilddept() {
		return childdept;
	}

	public void setChilddept(ChildDept childdept) {
		this.childdept = childdept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getLoginNameModifyCount() {
		return loginNameModifyCount;
	}

	public void setLoginNameModifyCount(Integer loginNameModifyCount) {
		this.loginNameModifyCount = loginNameModifyCount;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
}
