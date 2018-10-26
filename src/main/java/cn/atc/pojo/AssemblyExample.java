package cn.atc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssemblyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssemblyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdIsNull() {
            addCriterion("productiveTaskId is null");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdIsNotNull() {
            addCriterion("productiveTaskId is not null");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdEqualTo(String value) {
            addCriterion("productiveTaskId =", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdNotEqualTo(String value) {
            addCriterion("productiveTaskId <>", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdGreaterThan(String value) {
            addCriterion("productiveTaskId >", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("productiveTaskId >=", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdLessThan(String value) {
            addCriterion("productiveTaskId <", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdLessThanOrEqualTo(String value) {
            addCriterion("productiveTaskId <=", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdLike(String value) {
            addCriterion("productiveTaskId like", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdNotLike(String value) {
            addCriterion("productiveTaskId not like", value, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdIn(List<String> values) {
            addCriterion("productiveTaskId in", values, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdNotIn(List<String> values) {
            addCriterion("productiveTaskId not in", values, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdBetween(String value1, String value2) {
            addCriterion("productiveTaskId between", value1, value2, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andProductiveTaskIdNotBetween(String value1, String value2) {
            addCriterion("productiveTaskId not between", value1, value2, "productiveTaskId");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleIsNull() {
            addCriterion("assemblyPeople is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleIsNotNull() {
            addCriterion("assemblyPeople is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleEqualTo(Long value) {
            addCriterion("assemblyPeople =", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleNotEqualTo(Long value) {
            addCriterion("assemblyPeople <>", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleGreaterThan(Long value) {
            addCriterion("assemblyPeople >", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleGreaterThanOrEqualTo(Long value) {
            addCriterion("assemblyPeople >=", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleLessThan(Long value) {
            addCriterion("assemblyPeople <", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleLessThanOrEqualTo(Long value) {
            addCriterion("assemblyPeople <=", value, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleIn(List<Long> values) {
            addCriterion("assemblyPeople in", values, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleNotIn(List<Long> values) {
            addCriterion("assemblyPeople not in", values, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleBetween(Long value1, Long value2) {
            addCriterion("assemblyPeople between", value1, value2, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andAssemblyPeopleNotBetween(Long value1, Long value2) {
            addCriterion("assemblyPeople not between", value1, value2, "assemblyPeople");
            return (Criteria) this;
        }

        public Criteria andRealQuantityIsNull() {
            addCriterion("realQuantity is null");
            return (Criteria) this;
        }

        public Criteria andRealQuantityIsNotNull() {
            addCriterion("realQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andRealQuantityEqualTo(Long value) {
            addCriterion("realQuantity =", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityNotEqualTo(Long value) {
            addCriterion("realQuantity <>", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityGreaterThan(Long value) {
            addCriterion("realQuantity >", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityGreaterThanOrEqualTo(Long value) {
            addCriterion("realQuantity >=", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityLessThan(Long value) {
            addCriterion("realQuantity <", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityLessThanOrEqualTo(Long value) {
            addCriterion("realQuantity <=", value, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityIn(List<Long> values) {
            addCriterion("realQuantity in", values, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityNotIn(List<Long> values) {
            addCriterion("realQuantity not in", values, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityBetween(Long value1, Long value2) {
            addCriterion("realQuantity between", value1, value2, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andRealQuantityNotBetween(Long value1, Long value2) {
            addCriterion("realQuantity not between", value1, value2, "realQuantity");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finishTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finishTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finishTime =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finishTime <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finishTime >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishTime >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finishTime <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finishTime <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finishTime in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finishTime not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finishTime between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finishTime not between", value1, value2, "finishTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}