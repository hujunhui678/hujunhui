package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Permission;

/**
 * ����Ȩ�޵��� 1J����2J 2J����3J
 * @author ASUS
 *
 */
public class AllPerm {
	private long id;// Ȩ�ޱ���
	private String permNameC;// Ȩ������(����)
	private String permNameE;// Ȩ������(Ӣ��)
	private String permURL;// Ȩ������URL
	private int permLevel;//Ȩ�޵ȼ�
	private List<PermLv2> permListLv2;// ������2JȨ�޼���
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
	public List<PermLv2> getPermListLv2() {
		return permListLv2;
	}
	public void setPermListLv2(List<PermLv2> permListLv2) {
		this.permListLv2 = permListLv2;
	}
	public AllPerm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllPerm(long id, String permNameC, String permNameE, String permURL, int permLevel,
			List<PermLv2> permListLv2) {
		super();
		this.id = id;
		this.permNameC = permNameC;
		this.permNameE = permNameE;
		this.permURL = permURL;
		this.permLevel = permLevel;
		this.permListLv2 = permListLv2;
	}
	
}
