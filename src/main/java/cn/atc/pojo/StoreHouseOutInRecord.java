package cn.atc.pojo;

import java.util.List;

/**
 * ��������¼��
 * @author ASUS
 *
 */
public class StoreHouseOutInRecord {
	private long id;// ���
	private String sid;//���(�ַ���)
	private int isOut;// �Ƿ���⣨1��ʾ���⣩
	private String time;// �����ʱ��
	private String empName;// �����������
	private long principal;// ����⸺����
	private long leadingDept;// ���ò��ű��(���ű����)
	private long receivePerson;// �����˱��(�û������)
	private long releaseDeptId;// �������ű��
	private long releasePersonId;// �����˱��
	private String remark;// ��ע
	
	private Admin principalAdmin;// ����⸺����
	private Department leadingDepartment;// ���ò���
	private Admin receiveAdmin;// ������
	private Department releaseDept;// ��������
	private Admin releasePerson;// ������
	private List<StoreHouseOutInDescRecord> storeHouseOutInDescRecordList;// ��ϸ��¼
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public StoreHouseOutInRecord(long id, String sid, int isOut, String time, String empName, long principal,
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
	public StoreHouseOutInRecord() {
		super();
	}
	
}
