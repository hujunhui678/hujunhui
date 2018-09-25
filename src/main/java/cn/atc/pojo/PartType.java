package cn.atc.pojo;

/**
 * 零件类别表
 * @author ASUS
 *
 */
public class PartType {
	private long id;
	private String partType;
	private long partClassId;
	
	private PartClassify partClassify;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public long getPartClassId() {
		return partClassId;
	}

	public void setPartClassId(long partClassId) {
		this.partClassId = partClassId;
	}

	public PartClassify getPartClassify() {
		return partClassify;
	}

	public void setPartClassify(PartClassify partClassify) {
		this.partClassify = partClassify;
	}

	public PartType(long id, String partType, long partClassId, PartClassify partClassify) {
		super();
		this.id = id;
		this.partType = partType;
		this.partClassId = partClassId;
		this.partClassify = partClassify;
	}

	public PartType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
