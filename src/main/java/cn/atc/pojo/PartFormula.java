package cn.atc.pojo;

import java.sql.Date;
import java.util.List;

/*
 * ����䷽��
 */
public class PartFormula {
	private long id;// ����䷽����
	private String formulaName;// �䷽����
	private long compilers;// ��д��Ա(����Ա���)
	private Date createTime;// ����ʱ��
	private Date lastChangeTime;// ����޸�ʱ��
	private List<PartFormulaDesc> partFormulaDesc;//�䷽�����
	private FinishedProductsType finishedProductsType;//��Ʒ����
	private List<PartType> partType;//������
	private List<PartClassify> partClassify;//�������
	private Admin admin;//����Ա
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	public long getCompilers() {
		return compilers;
	}

	public void setCompilers(long compilers) {
		this.compilers = compilers;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastChangeTime() {
		return lastChangeTime;
	}

	public void setLastChangeTime(Date lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}

	public List<PartFormulaDesc> getPartFormulaDesc() {
		return partFormulaDesc;
	}

	public void setPartFormulaDesc(List<PartFormulaDesc> partFormulaDesc) {
		this.partFormulaDesc = partFormulaDesc;
	}

	public FinishedProductsType getFinishedProductsType() {
		return finishedProductsType;
	}

	public void setFinishedProductsType(FinishedProductsType finishedProductsType) {
		this.finishedProductsType = finishedProductsType;
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

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
