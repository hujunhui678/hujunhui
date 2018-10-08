package cn.atc.pojo;


/**
 * 出库入库记录详细表
 * @author ASUS
 *
 */
public class StoreHouseOutInDescRecord {
	private long id;// 编号
	private long outInRecordId;//出库入库记录表外键
	private long partTypeId;// 零件型号(零件型号外键)
	private long finishedProductId;// 成品类别(成品类别表外键)
	private long num;// 出入库数量
	private long goodsOnHand ;//结存
	
	private StoreHouseOutInRecord storeHouseOutInRecord;// 出库入库记录
	private PartType partType;// 零件类别
	private FinishedProductsType finishedProductsType;// 成品类别
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOutInRecordId() {
		return outInRecordId;
	}
	public void setOutInRecordId(long outInRecordId) {
		this.outInRecordId = outInRecordId;
	}
	public long getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(long partTypeId) {
		this.partTypeId = partTypeId;
	}
	public long getFinishedProductId() {
		return finishedProductId;
	}
	public void setFinishedProductId(long finishedProductId) {
		this.finishedProductId = finishedProductId;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public long getGoodsOnHand() {
		return goodsOnHand;
	}
	public void setGoodsOnHand(long goodsOnHand) {
		this.goodsOnHand = goodsOnHand;
	}
	public StoreHouseOutInRecord getStoreHouseOutInRecord() {
		return storeHouseOutInRecord;
	}
	public void setStoreHouseOutInRecord(StoreHouseOutInRecord storeHouseOutInRecord) {
		this.storeHouseOutInRecord = storeHouseOutInRecord;
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
	public StoreHouseOutInDescRecord() {
		super();
	}
	
}
