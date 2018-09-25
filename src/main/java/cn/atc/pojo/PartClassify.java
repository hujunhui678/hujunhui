package cn.atc.pojo;

/**
 * 零件分类表
 * @author ASUS
 *
 */
public class PartClassify {
	private long id;
	private String partName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public PartClassify(long id, String partName) {
		super();
		this.id = id;
		this.partName = partName;
	}
	public PartClassify() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
