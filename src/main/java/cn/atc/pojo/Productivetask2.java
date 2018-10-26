package cn.atc.pojo;

import java.util.Date;

public class Productivetask2 {


    private String id;

    private String planId;

    private Long partTypeId;

    private Long productionLeader;

    private Long productionNum;

    private Date estimatedTimeOfCompletion;

    private String desc;


    public Productivetask2(){

    }

    public Productivetask2(String id, String planId, Long partTypeId, Long productionLeader, Long productionNum, Date estimatedTimeOfCompletion, String desc) {
        this.id = id;
        this.planId = planId;
        this.partTypeId = partTypeId;
        this.productionLeader = productionLeader;
        this.productionNum = productionNum;
        this.estimatedTimeOfCompletion = estimatedTimeOfCompletion;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    public Long getPartTypeId() {
        return partTypeId;
    }

    public void setPartTypeId(Long partTypeId) {
        this.partTypeId = partTypeId;
    }

    public Long getProductionLeader() {
        return productionLeader;
    }

    public void setProductionLeader(Long productionLeader) {
        this.productionLeader = productionLeader;
    }

    public Long getProductionNum() {
        return productionNum;
    }

    public void setProductionNum(Long productionNum) {
        this.productionNum = productionNum;
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
}