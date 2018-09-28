package cn.atc.pojo;

/**
 * ����(ë��)����
 * 
 * @author ASUS
 *
 */
public class Material {
	private long id;// ���
	private long matType;// ����ͺ����
	private long inventoryNum;// �����
	private int purchaseWay;// ����;��
	private String remark;// ��ע
	private PartType partType;//����ͺ�
	
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
