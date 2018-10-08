package cn.atc.pojo;

/*
 * 权限表
 */
public class Permission {
	private long id;// 权限表编号
	private String permNameC;// 权限名称(中文)
	private String permNameE;// 权限名称(英文)
	private String permURL;// 权限链接URL
	private int permLevel;//权限等级
	private long parentPermId; //父级权限ID 
	private String permDesc; //权限描述(2018年9月13日添加)
	private String icon;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPermNameC() {
		return permNameC;
	}
	public void setPermNameC(String permNameC) {
		this.permNameC = permNameC;
	}
	public String getPermNameE() {
		return permNameE;
	}
	public void setPermNameE(String permNameE) {
		this.permNameE = permNameE;
	}
	public String getPermURL() {
		return permURL;
	}
	public void setPermURL(String permURL) {
		this.permURL = permURL;
	}
	public int getPermLevel() {
		return permLevel;
	}
	public void setPermLevel(int permLevel) {
		this.permLevel = permLevel;
	}
	public long getParentPermId() {
		return parentPermId;
	}
	public void setParentPermId(long parentPermId) {
		this.parentPermId = parentPermId;
	}
	public String getPermDesc() {
		return permDesc;
	}
	public void setPermDesc(String permDesc) {
		this.permDesc = permDesc;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	

}
