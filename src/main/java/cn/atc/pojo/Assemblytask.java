package cn.atc.pojo;

import java.util.Date;

public class Assemblytask {
    private String id;

    private Long finishedType;

    private Long assemblyLeader;

    private Long partformulaId;

    private Date estimatedTimeOfCompletion;

    /**
     * 鐢ㄤ簬鎺ユ敹ajax涓紶鏉ョ殑date鏁板��
     */
    private String dateStr;

    private String desc;

    private FinishedProductsType finishedTypeEntity;

    private Admin assemblyLeaderEntity;

    private PartFormula partformulaEntity;

    public Assemblytask() {
    }

    public Assemblytask(String id, Long finishedType, Long assemblyLeader, Long partformulaId, Date estimatedTimeOfCompletion, String desc) {
        this.id = id;
        this.finishedType = finishedType;
        this.assemblyLeader = assemblyLeader;
        this.partformulaId = partformulaId;
        this.estimatedTimeOfCompletion = estimatedTimeOfCompletion;
        this.desc = desc;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }


    public FinishedProductsType getFinishedTypeEntity() {
		return finishedTypeEntity;
	}

	public void setFinishedTypeEntity(FinishedProductsType finishedTypeEntity) {
		this.finishedTypeEntity = finishedTypeEntity;
	}

	public PartFormula getPartformulaEntity() {
		return partformulaEntity;
	}

	public void setPartformulaEntity(PartFormula partformulaEntity) {
		this.partformulaEntity = partformulaEntity;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getFinishedType() {
        return finishedType;
    }

    public void setFinishedType(Long finishedType) {
        this.finishedType = finishedType;
    }

    public Long getAssemblyLeader() {
        return assemblyLeader;
    }

    public void setAssemblyLeader(Long assemblyLeader) {
        this.assemblyLeader = assemblyLeader;
    }

    public Long getPartformulaId() {
        return partformulaId;
    }

    public void setPartformulaId(Long partformulaId) {
        this.partformulaId = partformulaId;
    }

    public Date getEstimatedTimeOfCompletion() {
        return estimatedTimeOfCompletion;
    }

    public void setEstimatedTimeOfCompletion(Date estimatedTimeOfCompletion) {
        this.estimatedTimeOfCompletion = estimatedTimeOfCompletion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Admin getAssemblyLeaderEntity() {
        return assemblyLeaderEntity;
    }

    public void setAssemblyLeaderEntity(Admin assemblyLeaderEntity) {
        this.assemblyLeaderEntity = assemblyLeaderEntity;
    }

    @Override
    public String toString() {
        return "Assemblytask{" +
                "id='" + id + '\'' +
                ", finishedType=" + finishedType +
                ", assemblyLeader=" + assemblyLeader +
                ", partformulaId=" + partformulaId +
                ", estimatedTimeOfCompletion=" + estimatedTimeOfCompletion +
                ", dateStr='" + dateStr + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}