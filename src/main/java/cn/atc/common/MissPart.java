package cn.atc.common;

import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartType;

/**
 * 当订单所需材料数量与库存材料数量比对后缺少的零件组成的表
 * @author ASUS
 *
 */
public class MissPart {
	private long partTypeId; // 零件类型id
	private long partClassId;// 零件类别id
	private long missNum;// 缺少的数目
	
	private PartClassify partClassify; // 零件类别
	private PartType partType;// 零件类型
	public long getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(long partTypeId) {
		this.partTypeId = partTypeId;
	}
	public long getPartClassId() {
		return partClassId;
	}
	public void setPartClassId(long partClassId) {
		this.partClassId = partClassId;
	}
	public long getMissNum() {
		return missNum;
	}
	public void setMissNum(long missNum) {
		this.missNum = missNum;
	}
	public MissPart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MissPart(long partTypeId, long partClassId, long missNum, PartClassify partClassify, PartType partType) {
		super();
		this.partTypeId = partTypeId;
		this.partClassId = partClassId;
		this.missNum = missNum;
		this.partClassify = partClassify;
		this.partType = partType;
	}
	public PartClassify getPartClassify() {
		return partClassify;
	}
	public void setPartClassify(PartClassify partClassify) {
		this.partClassify = partClassify;
	}
	public PartType getPartType() {
		return partType;
	}
	public void setPartType(PartType partType) {
		this.partType = partType;
	}
}
