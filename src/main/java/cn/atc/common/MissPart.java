package cn.atc.common;

import java.util.List;

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
	
	private List<PartClassify> partClassies; // 零件类别
	private List<PartType> partTypes;// 零件类型
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
	public List<PartClassify> getPartClassies() {
		return partClassies;
	}
	public void setPartClassies(List<PartClassify> partClassies) {
		this.partClassies = partClassies;
	}
	public List<PartType> getPartTypes() {
		return partTypes;
	}
	public void setPartTypes(List<PartType> partTypes) {
		this.partTypes = partTypes;
	}
	public MissPart(long partTypeId, long partClassId, long missNum, PartClassify partClassify, PartType partType,
			List<PartClassify> partClassies, List<PartType> partTypes) {
		super();
		this.partTypeId = partTypeId;
		this.partClassId = partClassId;
		this.missNum = missNum;
		this.partClassify = partClassify;
		this.partType = partType;
		this.partClassies = partClassies;
		this.partTypes = partTypes;
	}
	
	public MissPart(List<PartClassify> partClassies, List<PartType> partTypes) {
		super();
		this.partClassies = partClassies;
		this.partTypes = partTypes;
	}
	public MissPart() {
		super();
	}
	
}
