package cn.atc.pojo;

/**
 * ���ű�
 * @author ASUS
 *
 */
public class Department {
	
	private long id;// ���
	private String deptName;// ��������
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Department(long id, String deptName) {
		super();
		this.id = id;
		this.deptName = deptName;
	}
	public Department() {
		super();
	}
}
