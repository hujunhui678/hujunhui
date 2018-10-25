package cn.atc.common;

import java.util.List;

import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.ProductionPlan;

public class ProplanAndFormula {
	private List<FinishedProductsType> fpList;//���г�Ʒ�ļ���x
	
	private List<PartFormula> pfList;//�����䷽����
	private PartFormula pf;//ʹ�õ��䷽

	private ProductionPlan pp;//�����ƻ�

	public List<FinishedProductsType> getFpList() {
		return fpList;
	}

	public void setFpList(List<FinishedProductsType> fpList) {
		this.fpList = fpList;
	}

	public List<PartFormula> getPfList() {
		return pfList;
	}

	public void setPfList(List<PartFormula> pfList) {
		this.pfList = pfList;
	}

	public PartFormula getPf() {
		return pf;
	}

	public void setPf(PartFormula pf) {
		this.pf = pf;
	}

	public ProductionPlan getPp() {
		return pp;
	}

	public void setPp(ProductionPlan pp) {
		this.pp = pp;
	}

	public ProplanAndFormula(List<FinishedProductsType> fpList, List<PartFormula> pfList,
			PartFormula pf, ProductionPlan pp) {
		super();
		this.fpList = fpList;
		this.pfList = pfList;
		this.pf = pf;
		this.pp = pp;
	}

	public ProplanAndFormula(List<PartFormula> pfList, PartFormula pf) {
		super();
		this.pfList = pfList;
		this.pf = pf;
	}

	public ProplanAndFormula() {
		super();
	}

}
