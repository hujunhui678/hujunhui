package cn.atc.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 采购订单表
 * 
 * @author ASUS
 *
 */
public class PurchaseOrder {
	private String id;// 采购订单表编号(程序控制生成)
	private long buyer;// 采购员(雇员表外键)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date purchaseTime;// 采购时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date releaseTime;// 发布时间
	private Integer isSignin;// 是否签收(0未签收1已签收)
	private long consignee;// 收货人(雇员表外键)
	private Integer auditStateId;// 审核状态(审核状态表外键)
	private String notPassDesc;// 未通过备注
	private long leadingDept;// 领用部门(部门表外键)
	private long receivePerson;// 领用人(用户表外键)
	private long auditor;// 审核人(雇员表外键)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date auditTime;// 审核完成时间

	private Admin buyerEmp;// 采购员
	private Admin consigneeEmp;// 收货人
	private AuditState auditState;// 审核状态
	private Admin auditorEmp;// 审核人
	private Department leadingDepartment;// 领用部门
	private Admin receiveAdmin;// 领用人
	private List<PurchaseOrderDesc> purchaseOrderDescList;// 采购订单详细
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
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
	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", buyer=" + buyer + ", purchaseTime=" + purchaseTime + ", releaseTime="
				+ releaseTime + ", isSignin=" + isSignin + ", consignee=" + consignee + ", auditStateId=" + auditStateId
				+ ", notPassDesc=" + notPassDesc + ", leadingDept=" + leadingDept + ", receivePerson=" + receivePerson
				+ ", auditor=" + auditor + ", auditTime=" + auditTime + ", buyerEmp=" + buyerEmp + ", consigneeEmp="
				+ consigneeEmp + ", auditState=" + auditState + ", auditorEmp=" + auditorEmp + ", leadingDepartment="
				+ leadingDepartment + ", receiveAdmin=" + receiveAdmin + ", purchaseOrderDescList="
				+ purchaseOrderDescList + "]";
	}
	public PurchaseOrder() {
		super();
	}
}
