package cn.atc.common;

import java.util.List;

import cn.atc.pojo.FinishedProductsType;
import cn.atc.pojo.PartFormula;
import cn.atc.pojo.ProductionPlan;

public class ProplanAndFormula {
	private List<FinishedProductsType> fpList;//所有成品的集合x
	
	private List<PartFormula> pfList;//所有配方集合
	private PartFormula pf;//使用的配方

	private ProductionPlan pp;//生产计划

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
