package cn.atc.pojo;

/*
 * 零件配方详细表
 */
public class PartFormulaDesc {
	private long id;// 零件配方详细表编号
	private long finishedProductsTypeId;// 成品类型表外键
	private long partTypeId;// 零件类型表外键
	private long requirement;// 需求量
	private long partformulaId;// 零件配方表外键

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
