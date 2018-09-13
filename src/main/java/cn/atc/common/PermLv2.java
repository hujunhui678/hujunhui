package cn.atc.common;

import java.util.List;

import cn.atc.pojo.Permission;

/**
 * 2J权限类
 * 
 * @author ASUS
 *
 */
public class PermLv2 {
	private long id;// 权限表编号
	private String permNameC;// 权限名称(中文)
	private String permNameE;// 权限名称(英文)
	private String permURL;// 权限链接URL
	private int permLevel;// 权限等级
	private List<Permission> permListLv3;// 包含的3J权限集合

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
