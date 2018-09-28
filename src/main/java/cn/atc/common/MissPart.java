package cn.atc.common;

import cn.atc.pojo.PartClassify;
import cn.atc.pojo.PartType;

/**
 * �����������������������������ȶԺ�ȱ�ٵ������ɵı�
 * @author ASUS
 *
 */
public class MissPart {
	private long partTypeId; // �������id
	private long partClassId;// ������id
	private long missNum;// ȱ�ٵ���Ŀ
	
	private PartClassify partClassify; // ������
	private PartType partType;// �������
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
