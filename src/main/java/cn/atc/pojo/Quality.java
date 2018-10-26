package cn.atc.pojo;

import java.util.Date;

//质量检测书
public class Quality {
	private int id;
	private int deptNo;
	private int deptName;
	private int adminPeper;
	private int detectionPartTypeId;
	private int detectionFinishedTypeId;
	private String partImageUrl;
	
	private Date submissionTime;
	private int detectionNum;
	private String desc;
	private int state;
	private String parttypes;//检测零件型号
	private String finishedtype;//检测成品型号
	private String adminName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public int getDeptName() {
		return deptName;
	}
	public void setDeptName(int deptName) {
		this.deptName = deptName;
	}
	public int getAdminPeper() {
		return adminPeper;
	}
	public void setAdminPeper(int adminPeper) {
		this.adminPeper = adminPeper;
	}
	public int getDetectionPartTypeId() {
		return detectionPartTypeId;
	}
	public void setDetectionPartTypeId(int detectionPartTypeId) {
		this.detectionPartTypeId = detectionPartTypeId;
	}
	public int getDetectionFinishedTypeId() {
		return detectionFinishedTypeId;
	}
	public void setDetectionFinishedTypeId(int detectionFinishedTypeId) {
		this.detectionFinishedTypeId = detectionFinishedTypeId;
	}
	public String getPartImageUrl() {
		return partImageUrl;
	}
	public void setPartImageUrl(String partImageUrl) {
		this.partImageUrl = partImageUrl;
	}
	public Date getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(Date submissionTime) {
		this.submissionTime = submissionTime;
	}
	public int getDetectionNum() {
		return detectionNum;
	}
	public void setDetectionNum(int detectionNum) {
		this.detectionNum = detectionNum;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getParttypes() {
		return parttypes;
	}
	public void setParttypes(String parttypes) {
		this.parttypes = parttypes;
	}
	public String getFinishedtype() {
		return finishedtype;
	}
	public void setFinishedtype(String finishedtype) {
		this.finishedtype = finishedtype;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Quality(int id, int deptNo, int deptName, int adminPeper, int detectionPartTypeId,
			int detectionFinishedTypeId, String partImageUrl, Date submissionTime, int detectionNum, String desc,
			String parttypes, String finishedtype, String adminName) {
		super();
		this.id = id;
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.adminPeper = adminPeper;
		this.detectionPartTypeId = detectionPartTypeId;
		this.detectionFinishedTypeId = detectionFinishedTypeId;
		this.partImageUrl = partImageUrl;
		this.submissionTime = submissionTime;
		this.detectionNum = detectionNum;
		this.desc = desc;
		this.parttypes = parttypes;
		this.finishedtype = finishedtype;
		this.adminName = adminName;
	}
	public Quality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
}
