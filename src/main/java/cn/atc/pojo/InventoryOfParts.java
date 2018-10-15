package cn.atc.pojo;

/**
 * 零件库存表
 * @author ASUS
 *
 */
public class InventoryOfParts {
	private long id; //编号
	private long partId; //零件表外键
	private long inventoryNum; //库存量
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPartId() {
		return partId;
	}
	public void setPartId(long partId) {
		this.partId = partId;
	}
	public long getInventoryNum() {
		return inventoryNum;
	}
	public void setInventoryNum(long inventoryNum) {
		this.inventoryNum = inventoryNum;
	}
	public InventoryOfParts() {
		super();
	}
	public InventoryOfParts(long id, long partId, long inventoryNum) {
		super();
		this.id = id;
		this.partId = partId;
		this.inventoryNum = inventoryNum;
	}
}
