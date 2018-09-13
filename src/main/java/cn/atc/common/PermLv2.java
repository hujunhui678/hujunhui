package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Permission;

/**
 * 2JȨ����
 * 
 * @author ASUS
 *
 */
public class PermLv2 {
	private long id;// Ȩ�ޱ���
	private String permNameC;// Ȩ������(����)
	private String permNameE;// Ȩ������(Ӣ��)
	private String permURL;// Ȩ������URL
	private int permLevel;// Ȩ�޵ȼ�
	private List<Permission> permListLv3;// ������3JȨ�޼���

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


	public List<Permission> getPermListLv3() {
		return permListLv3;
	}

	public void setPermListLv3(List<Permission> permListLv3) {
		this.permListLv3 = permListLv3;
	}

	public PermLv2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermLv2(long id, String permNameC, String permNameE, String permURL, int permLevel,
			List<Permission> permListLv3) {
		super();
		this.id = id;
		this.permNameC = permNameC;
		this.permNameE = permNameE;
		this.permURL = permURL;
		this.permLevel = permLevel;
		this.permListLv3 = permListLv3;
	}


}
