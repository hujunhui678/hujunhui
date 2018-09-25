package cn.atc.pojo;

/**
 * ²É¹º¶©µ¥ÏêÏ¸±í
 * @author ASUS
 *
 */
public class PurchaseOrderDesc {
	private long id;
	private long purchaseOrderId;
	private long partTypeId;
	private long orderNum;
	
	private PurchaseOrder purchaseOrder;
	private PartType partType;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public long getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(long partTypeId) {
		this.partTypeId = partTypeId;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public PartType getPartType() {
		return partType;
	}
	public void setPartType(PartType partType) {
		this.partType = partType;
	}
	public PurchaseOrderDesc(long id, long purchaseOrderId, long partTypeId, long orderNum, PurchaseOrder purchaseOrder,
			PartType partType) {
		super();
		this.id = id;
		this.purchaseOrderId = purchaseOrderId;
		this.partTypeId = partTypeId;
		this.orderNum = orderNum;
		this.purchaseOrder = purchaseOrder;
		this.partType = partType;
	}
	public PurchaseOrderDesc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
