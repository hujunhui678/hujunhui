package cn.atc.pojo;

import java.util.List;

/**
 * 出库入库记录表
 * @author ASUS
 *
 */
public class StoreHouseOutInRecord {
	private String id;// 编号
	private String sid;//编号(字符串)
	private int isOut;// 是否出库（1表示出库）
	private String time;// 出入库时间
	private String empName;// 出入库人姓名
	private long principal;// 出入库负责人
	private long leadingDept;// 领用部门编号(部门表外键)
	private long receivePerson;// 领用人编号(用户表外键)
	private long releaseDeptId;// 发布部门编号
	private long releasePersonId;// 发布人编号
	private String remark;// 备注
	
	private Admin principalAdmin;// 出入库负责人
	private Department leadingDepartment;// 领用部门
	private Admin receiveAdmin;// 领用人
	private Department releaseDept;// 发布部门
	private Admin releasePerson;// 发布人
	private List<StoreHouseOutInDescRecord> storeHouseOutInDescRecordList;// 详细记录
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getIsOut() {
		return isOut;
	}
	public void setIsOut(int isOut) {
		this.isOut = isOut;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getPrincipal() {
		return principal;
	}
	public void setPrincipal(long principal) {
		this.principal = principal;
	}
	public long getLeadingDept() {
		return leadingDept;
	}
	public void setLeadingDept(long leadingDept) {
		this.leadingDept = leadingDept;
	}
	public long getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(long receivePerson) {
		this.receivePerson = receivePerson;
	}
	public long getReleaseDeptId() {
		return releaseDeptId;
	}
	public void setReleaseDeptId(long releaseDeptId) {
		this.releaseDeptId = releaseDeptId;
	}
	public long getReleasePersonId() {
		return releasePersonId;
	}
	public void setReleasePersonId(long releasePersonId) {
		this.releasePersonId = releasePersonId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Admin getPrincipalAdmin() {
		return principalAdmin;
	}
	public void setPrincipalAdmin(Admin principalAdmin) {
		this.principalAdmin = principalAdmin;
	}
	public Department getLeadingDepartment() {
		return leadingDepartment;
	}
	public void setLeadingDepartment(Department leadingDepartment) {
		this.leadingDepartment = leadingDepartment;
	}
	public Admin getReceiveAdmin() {
		return receiveAdmin;
	}
	public void setReceiveAdmin(Admin receiveAdmin) {
		this.receiveAdmin = receiveAdmin;
	}
	public Department getReleaseDept() {
		return releaseDept;
	}
	public void setReleaseDept(Department releaseDept) {
		this.releaseDept = releaseDept;
	}
	public Admin getReleasePerson() {
		return releasePerson;
	}
	public void setReleasePerson(Admin releasePerson) {
		this.releasePerson = releasePerson;
	}
	public List<StoreHouseOutInDescRecord> getStoreHouseOutInDescRecordList() {
		return storeHouseOutInDescRecordList;
	}
	public void setStoreHouseOutInDescRecordList(List<StoreHouseOutInDescRecord> storeHouseOutInDescRecordList) {
		this.storeHouseOutInDescRecordList = storeHouseOutInDescRecordList;
	}
	public StoreHouseOutInRecord() {
		super();
	}
	public StoreHouseOutInRecord(String id, String sid, int isOut, String time, String empName, long principal,
			long leadingDept, long receivePerson, long releaseDeptId, long releasePersonId, String remark,
			Admin principalAdmin, Department leadingDepartment, Admin receiveAdmin, Department releaseDept,
			Admin releasePerson, List<StoreHouseOutInDescRecord> storeHouseOutInDescRecordList) {
		super();
		this.id = id;
		this.sid = sid;
		this.isOut = isOut;
		this.time = time;
		this.empName = empName;
		this.principal = principal;
		this.leadingDept = leadingDept;
		this.receivePerson = receivePerson;
		this.releaseDeptId = releaseDeptId;
		this.releasePersonId = releasePersonId;
		this.remark = remark;
		this.principalAdmin = principalAdmin;
		this.leadingDepartment = leadingDepartment;
		this.receiveAdmin = receiveAdmin;
		this.releaseDept = releaseDept;
		this.releasePerson = releasePerson;
		this.storeHouseOutInDescRecordList = storeHouseOutInDescRecordList;
	}
	
}
