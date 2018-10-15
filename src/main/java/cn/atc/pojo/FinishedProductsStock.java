package cn.atc.pojo;

/**
 * 成品零件库存表
 * @author ASUS
 *
 */
public class FinishedProductsStock {
	private long id; // 编号
	private long productId; // 成品类别表外键
	private long inventoryNum; // 库存量
	private int purchaseWay; // 来源途径
	private String remark; // 备注
	
	private FinishedProductsType finishedProductsType; // 成品类别

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	public FinishedProductsType getFinishedProductsType() {
		return finishedProductsType;
	}

	public void setFinishedProductsType(FinishedProductsType finishedProductsType) {
		this.finishedProductsType = finishedProductsType;
	}

	public FinishedProductsStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinishedProductsStock(long id, long productId, long inventoryNum, int purchaseWay, String remark,
			FinishedProductsType finishedProductsType) {
		super();
		this.id = id;
		this.productId = productId;
		this.inventoryNum = inventoryNum;
		this.purchaseWay = purchaseWay;
		this.remark = remark;
		this.finishedProductsType = finishedProductsType;
	}
}
