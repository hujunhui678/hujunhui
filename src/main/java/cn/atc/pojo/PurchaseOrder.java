package cn.atc.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * �ɹ�������
 * 
 * @author ASUS
 *
 */
public class PurchaseOrder {
	private long id;// �ɹ���������(�����������)
	private long buyer;// �ɹ�Ա(��Ա�����)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date purchaseTime;// �ɹ�ʱ��
	private Integer isSignin;// �Ƿ�ǩ��(0δǩ��1��ǩ��)
	private long consignee;// �ջ���(��Ա�����)
	private Integer auditStateId;// ���״̬(���״̬�����)
	private String notPassDesc;// δͨ����ע
	private long leadingDept;// ���ò���(���ű����)
	private long receivePerson;// ������(�û������)
	private long auditor;// �����(��Ա�����)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auditTime;// ������ʱ��

	private Admin buyerEmp;// �ɹ�Ա
	private Admin consigneeEmp;// �ջ���
	private AuditState auditState;// ���״̬
	private Admin auditorEmp;// �����
	private Department leadingDepartment;// ���ò���
	private Admin receiveAdmin;// ������
	private List<PurchaseOrderDesc> purchaseOrderDescList;// �ɹ�������ϸ
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getBuyer() {
		return buyer;
	}
	public void setBuyer(long buyer) {
		this.buyer = buyer;
	}
	public Date getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public Integer getIsSignin() {
		return isSignin;
	}
	public void setIsSignin(Integer isSignin) {
		this.isSignin = isSignin;
	}
	public long getConsignee() {
		return consignee;
	}
	public void setConsignee(long consignee) {
		this.consignee = consignee;
	}
	public Integer getAuditStateId() {
		return auditStateId;
	}
	public void setAuditStateId(Integer auditStateId) {
		this.auditStateId = auditStateId;
	}
	public String getNotPassDesc() {
		return notPassDesc;
	}
	public void setNotPassDesc(String notPassDesc) {
		this.notPassDesc = notPassDesc;
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
	public long getAuditor() {
		return auditor;
	}
	public void setAuditor(long auditor) {
		this.auditor = auditor;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	public Admin getBuyerEmp() {
		return buyerEmp;
	}
	public void setBuyerEmp(Admin buyerEmp) {
		this.buyerEmp = buyerEmp;
	}
	public Admin getConsigneeEmp() {
		return consigneeEmp;
	}
	public void setConsigneeEmp(Admin consigneeEmp) {
		this.consigneeEmp = consigneeEmp;
	}
	public AuditState getAuditState() {
		return auditState;
	}
	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}
	public Admin getAuditorEmp() {
		return auditorEmp;
	}
	public void setAuditorEmp(Admin auditorEmp) {
		this.auditorEmp = auditorEmp;
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
	public List<PurchaseOrderDesc> getPurchaseOrderDescList() {
		return purchaseOrderDescList;
	}
	public void setPurchaseOrderDescList(List<PurchaseOrderDesc> purchaseOrderDescList) {
		this.purchaseOrderDescList = purchaseOrderDescList;
	}
	public PurchaseOrder(long id, long buyer, Date purchaseTime, Integer isSignin, long consignee, Integer auditStateId,
			String notPassDesc, long leadingDept, long receivePerson, long auditor, Date auditTime, Admin buyerEmp,
			Admin consigneeEmp, AuditState auditState, Admin auditorEmp, Department leadingDepartment,
			Admin receiveAdmin, List<PurchaseOrderDesc> purchaseOrderDescList) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.purchaseTime = purchaseTime;
		this.isSignin = isSignin;
		this.consignee = consignee;
		this.auditStateId = auditStateId;
		this.notPassDesc = notPassDesc;
		this.leadingDept = leadingDept;
		this.receivePerson = receivePerson;
		this.auditor = auditor;
		this.auditTime = auditTime;
		this.buyerEmp = buyerEmp;
		this.consigneeEmp = consigneeEmp;
		this.auditState = auditState;
		this.auditorEmp = auditorEmp;
		this.leadingDepartment = leadingDepartment;
		this.receiveAdmin = receiveAdmin;
		this.purchaseOrderDescList = purchaseOrderDescList;
	}
	public PurchaseOrder() {
		super();
	}
}
