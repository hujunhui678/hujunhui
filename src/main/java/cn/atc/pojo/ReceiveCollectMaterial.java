package cn.atc.pojo;

import java.util.List;

/**
 * 收领料单表
 * 
 * @author ASUS
 *
 */
public class ReceiveCollectMaterial {
	private long id;// 收领料单编号
	private Integer isReceive;// 1表示收料单
	private String releaseTime;// 发布时间
	private Integer isAgree;// 1表示已批准
	private Integer auditStateId;// 审核状态(审核状态表外键)
	private long leadingDeptId;// 领用部门(部门表外键)
	private long receivePersonId;// 领用人(用户表外键)
	private long releaseDeptId;// 发布部门
	private long releasePersonId;// 发布人
	private String notPassDesc;// 未通过备注
	private long auditorId;// 审核人(用户表外键)
	private String auditTime;// 审核完成时间
	private long approverId;// 审批人(用户表外键)
	private String agreeTime;// 审批通过时间
	private long version;// 乐观锁标识

	private List<ReceiveCollectMaterialDesc> receiveCollectMaterialDescList;// 收领料单详情
	private AuditState auditState;// 审核状态
	private Department leadingDept;// 领用部门
	private Admin receivePerson;// 领用人
	private Department releaseDept;// 发布部门
	private Admin releasePerson;// 发布人
	private Admin auditor;// 审核人
	private Admin approver;// 审批人
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getIsReceive() {
		return isReceive;
	}
	public void setIsReceive(Integer isReceive) {
		this.isReceive = isReceive;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public Integer getIsAgree() {
		return isAgree;
	}
	public void setIsAgree(Integer isAgree) {
		this.isAgree = isAgree;
	}
	public Integer getAuditStateId() {
		return auditStateId;
	}
	public void setAuditStateId(Integer auditStateId) {
		this.auditStateId = auditStateId;
	}
	public long getLeadingDeptId() {
		return leadingDeptId;
	}
	public void setLeadingDeptId(long leadingDeptId) {
		this.leadingDeptId = leadingDeptId;
	}
	public long getReceivePersonId() {
		return receivePersonId;
	}
	public void setReceivePersonId(long receivePersonId) {
		this.receivePersonId = receivePersonId;
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
	public String getNotPassDesc() {
		return notPassDesc;
	}
	public void setNotPassDesc(String notPassDesc) {
		this.notPassDesc = notPassDesc;
	}
	public long getAuditorId() {
		return auditorId;
	}
	public void setAuditorId(long auditorId) {
		this.auditorId = auditorId;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	public long getApproverId() {
		return approverId;
	}
	public void setApproverId(long approverId) {
		this.approverId = approverId;
	}
	public String getAgreeTime() {
		return agreeTime;
	}
	public void setAgreeTime(String agreeTime) {
		this.agreeTime = agreeTime;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public List<ReceiveCollectMaterialDesc> getReceiveCollectMaterialDescList() {
		return receiveCollectMaterialDescList;
	}
	public void setReceiveCollectMaterialDescList(List<ReceiveCollectMaterialDesc> receiveCollectMaterialDescList) {
		this.receiveCollectMaterialDescList = receiveCollectMaterialDescList;
	}
	public AuditState getAuditState() {
		return auditState;
	}
	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}
	public Department getLeadingDept() {
		return leadingDept;
	}
	public void setLeadingDept(Department leadingDept) {
		this.leadingDept = leadingDept;
	}
	public Admin getReceivePerson() {
		return receivePerson;
	}
	public void setReceivePerson(Admin receivePerson) {
		this.receivePerson = receivePerson;
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
	public Admin getAuditor() {
		return auditor;
	}
	public void setAuditor(Admin auditor) {
		this.auditor = auditor;
	}
	public Admin getApprover() {
		return approver;
	}
	public void setApprover(Admin approver) {
		this.approver = approver;
	}
	public ReceiveCollectMaterial(long id, Integer isReceive, String releaseTime, Integer isAgree, Integer auditStateId,
			long leadingDeptId, long receivePersonId, long releaseDeptId, long releasePersonId, String notPassDesc,
			long auditorId, String auditTime, long approverId, String agreeTime, long version,
			List<ReceiveCollectMaterialDesc> receiveCollectMaterialDescList, AuditState auditState,
			Department leadingDept, Admin receivePerson, Department releaseDept, Admin releasePerson, Admin auditor,
			Admin approver) {
		super();
		this.id = id;
		this.isReceive = isReceive;
		this.releaseTime = releaseTime;
		this.isAgree = isAgree;
		this.auditStateId = auditStateId;
		this.leadingDeptId = leadingDeptId;
		this.receivePersonId = receivePersonId;
		this.releaseDeptId = releaseDeptId;
		this.releasePersonId = releasePersonId;
		this.notPassDesc = notPassDesc;
		this.auditorId = auditorId;
		this.auditTime = auditTime;
		this.approverId = approverId;
		this.agreeTime = agreeTime;
		this.version = version;
		this.receiveCollectMaterialDescList = receiveCollectMaterialDescList;
		this.auditState = auditState;
		this.leadingDept = leadingDept;
		this.receivePerson = receivePerson;
		this.releaseDept = releaseDept;
		this.releasePerson = releasePerson;
		this.auditor = auditor;
		this.approver = approver;
	}
	public ReceiveCollectMaterial() {
		super();
	}
}
