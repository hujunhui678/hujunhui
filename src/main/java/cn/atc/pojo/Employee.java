package cn.atc.pojo;

/*
 * Employee表
 */
public class Employee {
	private long id;// 编号
	private String name;// 姓名
	private String phone;// 电话
	private String cardId;// 身份证号
	private String address;// 地址
	private long deptChildId;// 子部门编号外键
	private ChildDept childdept;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getDeptChildId() {
		return deptChildId;
	}

	public void setDeptChildId(long deptChildId) {
		this.deptChildId = deptChildId;
	}

	public ChildDept getChilddept() {
		return childdept;
	}

	public void setChilddept(ChildDept childdept) {
		this.childdept = childdept;
	}

}
