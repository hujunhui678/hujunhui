package cn.atc.pojo;

/**
 * 部门表
 * @author ASUS
 *
 */
public class Department {
	
	private long id;// 编号
	private String deptName;// 部门名称
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
