package cn.atc.pojo;


/**
 * ��������¼��ϸ��
 * @author ASUS
 *
 */
public class StoreHouseOutInDescRecord {
	private long id;// ���
	private long outInRecordId;//��������¼�����
	private long partTypeId;// ����ͺ�(����ͺ����)
	private long finishedProductId;// ��Ʒ���(��Ʒ�������)
	private long num;// ���������
	private long goodsOnHand ;//���
	
	private StoreHouseOutInRecord storeHouseOutInRecord;// ��������¼
	private PartType partType;// ������
	private FinishedProductsType finishedProductsType;// ��Ʒ���
	
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
