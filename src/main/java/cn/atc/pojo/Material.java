package cn.atc.pojo;

/**
 * 物料(毛坯)库存表
 * 
 * @author ASUS
 *
 */
public class Material {
	private long id;// 编号
	private long matType;// 零件型号外键
	private long inventoryNum;// 库存量
	private int purchaseWay;// 购买途径
	private String remark;// 备注
	private PartType partType;//零件型号
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMatType() {
		return matType;
	}

	public void setMatType(long matType) {
		this.matType = matType;
	}

	public long getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(long inventoryNum) {
		this.inventoryNum = inventoryNum;
	}

	public int getPurchaseWay() {
		return purchaseWay;
	}

	public void setPurchaseWay(int purchaseWay) {
		this.purchaseWay = purchaseWay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public PartType getPartType() {
		return partType;
	}

	public void setPartType(PartType partType) {
		this.partType = partType;
	}

	public Material(long id, long matType, long inventoryNum, int purchaseWay, String remark, PartType partType) {
		super();
		this.id = id;
		this.matType = matType;
		this.inventoryNum = inventoryNum;
		this.purchaseWay = purchaseWay;
		this.remark = remark;
		this.partType = partType;
	}

	public Material() {
		super();
	}
}
