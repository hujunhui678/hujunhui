package cn.atc.pojo;

import java.util.Date;
import java.util.List;

/*
 * 生产计划表
 */
public class ProductionPlan {
	private String id;// 生产计划表编号(编写日期_编写人员ID)
	private long finishedProductTypeId;// 成品型号表外键
	private long produceNum;// 生产数量
	private long compilers;// 编写人员(管理员表外键)
	private String imageUrl;// 图片地址
	private Date arrivalTime;// 下达日期
	private Date estimatedTimeOfCompletion;// 规定完成日期
	private int auditStateId;// 审核状态
	private String reason;//审核不通过原因

	private FinishedProductsType finishedProductsType;// 成品类型
	private Admin admin;// 管理员
	private AuditState auditState;// 审核状态
	private List<PartFormulaDesc> partFormulaDesc;// 配方详情表
	private List<PartType> partType;// 零件类别
	private List<PartClassify> partClassify;// 零件分类
	private PartFormula partFormula;// 零件分类

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getFinishedProductTypeId() {
		return finishedProductTypeId;
	}

	public void setFinishedProductTypeId(long finishedProductTypeId) {
		this.finishedProductTypeId = finishedProductTypeId;
	}

	public long getProduceNum() {
		return produceNum;
	}

	public void setProduceNum(long produceNum) {
		this.produceNum = produceNum;
	}

	public long getCompilers() {
		return compilers;
	}

	public void setCompilers(long compilers) {
		this.compilers = compilers;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getEstimatedTimeOfCompletion() {
		return estimatedTimeOfCompletion;
	}

	public void setEstimatedTimeOfCompletion(Date estimatedTimeOfCompletion) {
		this.estimatedTimeOfCompletion = estimatedTimeOfCompletion;
	}

	public int getAuditStateId() {
		return auditStateId;
	}

	public void setAuditStateId(int auditStateId) {
		this.auditStateId = auditStateId;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public FinishedProductsType getFinishedProductsType() {
		return finishedProductsType;
	}

	public void setFinishedProductsType(FinishedProductsType finishedProductsType) {
		this.finishedProductsType = finishedProductsType;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AuditState getAuditState() {
		return auditState;
	}

	public void setAuditState(AuditState auditState) {
		this.auditState = auditState;
	}

	public List<PartFormulaDesc> getPartFormulaDesc() {
		return partFormulaDesc;
	}

	public void setPartFormulaDesc(List<PartFormulaDesc> partFormulaDesc) {
		this.partFormulaDesc = partFormulaDesc;
	}

	public List<PartType> getPartType() {
		return partType;
	}

	public void setPartType(List<PartType> partType) {
		this.partType = partType;
	}

	public List<PartClassify> getPartClassify() {
		return partClassify;
	}

	public void setPartClassify(List<PartClassify> partClassify) {
		this.partClassify = partClassify;
	}

	public PartFormula getPartFormula() {
		return partFormula;
	}

	public void setPartFormula(PartFormula partFormula) {
		this.partFormula = partFormula;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
