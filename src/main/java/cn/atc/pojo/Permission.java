package cn.atc.pojo;

/*
 * Ȩ�ޱ�
 */
public class Permission {
	private long id;// Ȩ�ޱ���
	private String permNameC;// Ȩ������(����)
	private String permNameE;// Ȩ������(Ӣ��)
	private String permURL;// Ȩ������URL
	private int permLevel;//Ȩ�޵ȼ�
	private long parentPermId; //����Ȩ��ID 
	private String permDesc; //Ȩ������(2018��9��13�����)
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
