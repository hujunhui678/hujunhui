package cn.atc.pojo;

import java.util.Date;

public class Production {
    private Long id;

    private String taskId;

    private Long partTypeId;

    private Long productionPeople;

    private Long realQuantity;

    private Date finishedTime;

    private String dateStr;

    private String desc;

    private PartType partTypeEntity;

    private Employee productionPeopleEntity;

    public PartType getPartTypeEntity() {
        return partTypeEntity;
    }

    public void setPartTypeEntity(PartType partTypeEntity) {
        this.partTypeEntity = partTypeEntity;
    }

    public Employee getProductionPeopleEntity() {
        return productionPeopleEntity;
    }

    public void setProductionPeopleEntity(Employee productionPeopleEntity) {
        this.productionPeopleEntity = productionPeopleEntity;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Long getPartTypeId() {
        return partTypeId;
    }

    public void setPartTypeId(Long partTypeId) {
        this.partTypeId = partTypeId;
    }

    public Long getProductionPeople() {
        return productionPeople;
    }

    public void setProductionPeople(Long productionPeople) {
        this.productionPeople = productionPeople;
    }

    public Long getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(Long realQuantity) {
        this.realQuantity = realQuantity;
    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", partTypeId=" + partTypeId +
                ", productionPeople=" + productionPeople +
                ", realQuantity=" + realQuantity +
                ", finishedTime=" + finishedTime +
                ", dateStr='" + dateStr + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}