package cn.atc.pojo;

/*
 * ����䷽��ϸ��
 */
public class PartFormulaDesc {
	private long id;// ����䷽��ϸ����
	private long finishedProductsTypeId;// ��Ʒ���ͱ����
	private long partTypeId;// ������ͱ����
	private long requirement;// ������
	private long partformulaId;// ����䷽�����

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFinishedProductsTypeId() {
		return finishedProductsTypeId;
	}

	public void setFinishedProductsTypeId(long finishedProductsTypeId) {
		this.finishedProductsTypeId = finishedProductsTypeId;
	}

	public long getPartTypeId() {
		return partTypeId;
	}

	public void setPartTypeId(long partTypeId) {
		this.partTypeId = partTypeId;
	}

	public long getRequirement() {
		return requirement;
	}

	public void setRequirement(long requirement) {
		this.requirement = requirement;
	}

	public long getPartformulaId() {
		return partformulaId;
	}

	public void setPartformulaId(long partformulaId) {
		this.partformulaId = partformulaId;
	}

	public PartFormulaDesc(long id, long finishedProductsTypeId, long partTypeId, long requirement,
			long partformulaId) {
		super();
		this.id = id;
		this.finishedProductsTypeId = finishedProductsTypeId;
		this.partTypeId = partTypeId;
		this.requirement = requirement;
		this.partformulaId = partformulaId;
	}

	public PartFormulaDesc() {
		super();
		// TODO Auto-generated constructor stub
	}

}
