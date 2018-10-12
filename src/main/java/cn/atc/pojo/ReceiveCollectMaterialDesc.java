package cn.atc.pojo;

/**
 * �����ϵ���ϸ��
 * 
 * @author ASUS
 *
 */
public class ReceiveCollectMaterialDesc {
	private long id;// �����ϵ���ϸ����
	private long materialId;// �����ϵ���(���)
	private long partTypeId;// ����������
	private long finishedPartTypeId;// ��Ʒ���������
	private long orderNum;// ��������

	private PartType partType;// ������
	private FinishedProductsType finishedProductsType;// ��Ʒ������
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
