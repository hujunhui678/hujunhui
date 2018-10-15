package cn.atc.pojo;

/**
 * 收领料单详细表
 * 
 * @author ASUS
 *
 */
public class ReceiveCollectMaterialDesc {
	private long id;// 收领料单详细表编号
	private long materialId;// 收领料单表(外键)
	private long partTypeId;// 零件类别表外键
	private long finishedPartTypeId;// 成品零件类别外键
	private long orderNum;// 收领数量

	private PartType partType;// 零件类别
	private FinishedProductsType finishedProductsType;// 成品零件类别
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}
	public long getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(long partTypeId) {
		this.partTypeId = partTypeId;
	}
	public long getFinishedPartTypeId() {
		return finishedPartTypeId;
	}
	public void setFinishedPartTypeId(long finishedPartTypeId) {
		this.finishedPartTypeId = finishedPartTypeId;
	}
	public long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}
	public PartType getPartType() {
		return partType;
	}
	public void setPartType(PartType partType) {
		this.partType = partType;
	}
	public FinishedProductsType getFinishedProductsType() {
		return finishedProductsType;
	}
	public void setFinishedProductsType(FinishedProductsType finishedProductsType) {
		this.finishedProductsType = finishedProductsType;
	}
	public ReceiveCollectMaterialDesc(long id, long materialId, long partTypeId, long finishedPartTypeId, long orderNum,
			PartType partType, FinishedProductsType finishedProductsType) {
		super();
		this.id = id;
		this.materialId = materialId;
		this.partTypeId = partTypeId;
		this.finishedPartTypeId = finishedPartTypeId;
		this.orderNum = orderNum;
		this.partType = partType;
		this.finishedProductsType = finishedProductsType;
	}
	public ReceiveCollectMaterialDesc() {
		super();
	}
}
