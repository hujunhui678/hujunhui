package cn.atc.pojo;

import java.sql.Date;
import java.util.List;

/*
 * 零件配方表
 */
public class PartFormula {
	private long id;// 零件配方表编号
	private String formulaName;// 配方名称
	private long compilers;// 编写人员(管理员外键)
	private Date createTime;// 创建时间
	private Date lastChangeTime;// 最后修改时间
	private List<PartFormulaDesc> partFormulaDesc;//配方详情表
	private FinishedProductsType finishedProductsType;//成品类型
	private List<PartType> partType;//零件类别
	private List<PartClassify> partClassify;//零件分类
	private Admin admin;//管理员
	
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
