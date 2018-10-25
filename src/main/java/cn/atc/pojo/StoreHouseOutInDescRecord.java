package cn.atc.pojo;


/**
 * ��������¼��ϸ��
 * @author ASUS
 *
 */
public class StoreHouseOutInDescRecord {
	private long id;// ���
	private String outInRecordId;//��������¼�����
	private long partTypeId;// ����ͺ�(����ͺ����)
	private long finishedProductId;// ��Ʒ���(��Ʒ�������)
	private long num;// ���������
	private long goodsOnHand ;//���
	
	private StoreHouseOutInRecord storeHouseOutInRecord;// ��������¼
	private PartType partType;// ������
	private FinishedProductsType finishedProductsType;// ��Ʒ���
	
	public String getOutInRecordId() {
		return outInRecordId;
	}
	public void setOutInRecordId(String outInRecordId) {
		this.outInRecordId = outInRecordId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public StoreHouseOutInDescRecord(long id, String outInRecordId, long partTypeId, long finishedProductId, long num,
			long goodsOnHand, StoreHouseOutInRecord storeHouseOutInRecord, PartType partType,
			FinishedProductsType finishedProductsType) {
		super();
		this.id = id;
		this.outInRecordId = outInRecordId;
		this.partTypeId = partTypeId;
		this.finishedProductId = finishedProductId;
		this.num = num;
		this.goodsOnHand = goodsOnHand;
		this.storeHouseOutInRecord = storeHouseOutInRecord;
		this.partType = partType;
		this.finishedProductsType = finishedProductsType;
	}
	public StoreHouseOutInDescRecord() {
		super();
	}
	
}
