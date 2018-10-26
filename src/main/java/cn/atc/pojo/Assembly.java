package cn.atc.pojo;

import java.util.Date;

public class Assembly {
    private Long id;

    private String productiveTaskId;

    private Long assemblyPeople;

    private Long realQuantity;

    private Date finishTime;

    private String dateStr;

    private Employee assemblyPeopleEntity;

    public Assembly() {
    }

    public Assembly(Long id, String productiveTaskId, Long assemblyPeople, Long realQuantity, Date finishTime) {
        this.id = id;
        this.productiveTaskId = productiveTaskId;
        this.assemblyPeople = assemblyPeople;
        this.realQuantity = realQuantity;
        this.finishTime = finishTime;
    }


    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Employee getAssemblyPeopleEntity() {
        return assemblyPeopleEntity;
    }

    public void setAssemblyPeopleEntity(Employee assemblyPeopleEntity) {
        this.assemblyPeopleEntity = assemblyPeopleEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductiveTaskId() {
        return productiveTaskId;
    }

    public void setProductiveTaskId(String productiveTaskId) {
        this.productiveTaskId = productiveTaskId == null ? null : productiveTaskId.trim();
    }

    public Long getAssemblyPeople() {
        return assemblyPeople;
    }

    public void setAssemblyPeople(Long assemblyPeople) {
        this.assemblyPeople = assemblyPeople;
    }

    public Long getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(Long realQuantity) {
        this.realQuantity = realQuantity;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}