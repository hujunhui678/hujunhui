package cn.atc.pojo;

/*
 * Employee��
 */
public class Employee {
	private long id;// ���
	private String name;// ����
	private String phone;// �绰
	private String cardId;// ���֤��
	private String address;// ��ַ
	private long deptChildId;// �Ӳ��ű�����
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
