package cn.atc.pojo;

import java.util.Date;
import java.util.List;

/*
 * �����ƻ���
 */
public class ProductionPlan {
	private String id;// �����ƻ�����(��д����_��д��ԱID)
	private long finishedProductTypeId;// ��Ʒ�ͺű����
	private long produceNum;// ��������
	private long compilers;// ��д��Ա(����Ա�����)
	private String imageUrl;// ͼƬ��ַ
	private Date arrivalTime;// �´�����
	private Date estimatedTimeOfCompletion;// �涨�������
	private int auditStateId;// ���״̬
	private String reason;//��˲�ͨ��ԭ��

	private FinishedProductsType finishedProductsType;// ��Ʒ����
	private Admin admin;// ����Ա
	private AuditState auditState;// ���״̬
	private List<PartFormulaDesc> partFormulaDesc;// �䷽�����
	private List<PartType> partType;// ������
	private List<PartClassify> partClassify;// �������
	private PartFormula partFormula;// �������

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
