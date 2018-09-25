package cn.atc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 采购订单表
 * @author ASUS
 *
 */
public class PurchaseOrder {
	private long id;//采购订单表编号(程序控制生成)
	private long buyer;//采购员(雇员表外键)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm" )
	private Date purchaseTime;//采购时间
	private Integer isSignin;//是否签收(0未签收1已签收)
	private long consignee;//收货人(雇员表外键)
	private Integer auditStateId;//审核状态(审核状态表外键)
	private String notPassDesc;//未通过备注
	private long auditor;//审核人(雇员表外键)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	private Date auditTime;//审核完成时间
	
	private Employee buyerEmp;
	private Employee consigneeEmp;
	private AuditState auditState;
	private Employee auditorEmp;
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
	public Employee getBuyerEmp() {
		return buyerEmp;
	}
	public void setBuyerEmp(Employee buyerEmp) {
		this.buyerEmp = buyerEmp;
	}
	public Employee getConsigneeEmp() {
		return consigneeEmp;
	}
	public void setConsigneeEmp(Employee consigneeEmp) {
		this.consigneeEmp = consigneeEmp;
	}
	public AuditState getAuditState() {
		return auditState;
	}
	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}
	public Employee getAuditorEmp() {
		return auditorEmp;
	}
	public void setAuditorEmp(Employee auditorEmp) {
		this.auditorEmp = auditorEmp;
	}
	public PurchaseOrder(long id, long buyer, Date purchaseTime, Integer isSignin, long consignee, Integer auditStateId,
			String notPassDesc, long auditor, Date auditTime, Employee buyerEmp, Employee consigneeEmp,
			AuditState auditState, Employee auditorEmp) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.purchaseTime = purchaseTime;
		this.isSignin = isSignin;
		this.consignee = consignee;
		this.auditStateId = auditStateId;
		this.notPassDesc = notPassDesc;
		this.auditor = auditor;
		this.auditTime = auditTime;
		this.buyerEmp = buyerEmp;
		this.consigneeEmp = consigneeEmp;
		this.auditState = auditState;
		this.auditorEmp = auditorEmp;
	}
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
