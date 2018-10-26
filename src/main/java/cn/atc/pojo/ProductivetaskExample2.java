package cn.atc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductivetaskExample2 {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductivetaskExample2() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("planId is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("planId is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("planId =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("planId <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("planId >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("planId >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("planId <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("planId <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("planId like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("planId not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("planId in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("planId not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("planId between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("planId not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdIsNull() {
            addCriterion("partTypeId is null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdIsNotNull() {
            addCriterion("partTypeId is not null");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdEqualTo(Long value) {
            addCriterion("partTypeId =", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdNotEqualTo(Long value) {
            addCriterion("partTypeId <>", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdGreaterThan(Long value) {
            addCriterion("partTypeId >", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("partTypeId >=", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdLessThan(Long value) {
            addCriterion("partTypeId <", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("partTypeId <=", value, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdIn(List<Long> values) {
            addCriterion("partTypeId in", values, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdNotIn(List<Long> values) {
            addCriterion("partTypeId not in", values, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdBetween(Long value1, Long value2) {
            addCriterion("partTypeId between", value1, value2, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andPartTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("partTypeId not between", value1, value2, "partTypeId");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderIsNull() {
            addCriterion("productionLeader is null");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderIsNotNull() {
            addCriterion("productionLeader is not null");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderEqualTo(Long value) {
            addCriterion("productionLeader =", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderNotEqualTo(Long value) {
            addCriterion("productionLeader <>", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderGreaterThan(Long value) {
            addCriterion("productionLeader >", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderGreaterThanOrEqualTo(Long value) {
            addCriterion("productionLeader >=", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderLessThan(Long value) {
            addCriterion("productionLeader <", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderLessThanOrEqualTo(Long value) {
            addCriterion("productionLeader <=", value, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderIn(List<Long> values) {
            addCriterion("productionLeader in", values, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderNotIn(List<Long> values) {
            addCriterion("productionLeader not in", values, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderBetween(Long value1, Long value2) {
            addCriterion("productionLeader between", value1, value2, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionLeaderNotBetween(Long value1, Long value2) {
            addCriterion("productionLeader not between", value1, value2, "productionLeader");
            return (Criteria) this;
        }

        public Criteria andProductionNumIsNull() {
            addCriterion("productionNum is null");
            return (Criteria) this;
        }

        public Criteria andProductionNumIsNotNull() {
            addCriterion("productionNum is not null");
            return (Criteria) this;
        }

        public Criteria andProductionNumEqualTo(Long value) {
            addCriterion("productionNum =", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumNotEqualTo(Long value) {
            addCriterion("productionNum <>", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumGreaterThan(Long value) {
            addCriterion("productionNum >", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumGreaterThanOrEqualTo(Long value) {
            addCriterion("productionNum >=", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumLessThan(Long value) {
            addCriterion("productionNum <", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumLessThanOrEqualTo(Long value) {
            addCriterion("productionNum <=", value, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumIn(List<Long> values) {
            addCriterion("productionNum in", values, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumNotIn(List<Long> values) {
            addCriterion("productionNum not in", values, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumBetween(Long value1, Long value2) {
            addCriterion("productionNum between", value1, value2, "productionNum");
            return (Criteria) this;
        }

        public Criteria andProductionNumNotBetween(Long value1, Long value2) {
            addCriterion("productionNum not between", value1, value2, "productionNum");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionIsNull() {
            addCriterion("estimatedTimeOfCompletion is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionIsNotNull() {
            addCriterion("estimatedTimeOfCompletion is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionEqualTo(Date value) {
            addCriterion("estimatedTimeOfCompletion =", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionNotEqualTo(Date value) {
            addCriterion("estimatedTimeOfCompletion <>", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionGreaterThan(Date value) {
            addCriterion("estimatedTimeOfCompletion >", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionGreaterThanOrEqualTo(Date value) {
            addCriterion("estimatedTimeOfCompletion >=", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionLessThan(Date value) {
            addCriterion("estimatedTimeOfCompletion <", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionLessThanOrEqualTo(Date value) {
            addCriterion("estimatedTimeOfCompletion <=", value, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionIn(List<Date> values) {
            addCriterion("estimatedTimeOfCompletion in", values, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionNotIn(List<Date> values) {
            addCriterion("estimatedTimeOfCompletion not in", values, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionBetween(Date value1, Date value2) {
            addCriterion("estimatedTimeOfCompletion between", value1, value2, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andEstimatedTimeOfCompletionNotBetween(Date value1, Date value2) {
            addCriterion("estimatedTimeOfCompletion not between", value1, value2, "estimatedTimeOfCompletion");
            return (Criteria) this;
        }

        public Criteria andDescIsNull() {
            addCriterion("desc is null");
            return (Criteria) this;
        }

        public Criteria andDescIsNotNull() {
            addCriterion("desc is not null");
            return (Criteria) this;
        }

        public Criteria andDescEqualTo(String value) {
            addCriterion("desc =", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotEqualTo(String value) {
            addCriterion("desc <>", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThan(String value) {
            addCriterion("desc >", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescGreaterThanOrEqualTo(String value) {
            addCriterion("desc >=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThan(String value) {
            addCriterion("desc <", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLessThanOrEqualTo(String value) {
            addCriterion("desc <=", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescLike(String value) {
            addCriterion("desc like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotLike(String value) {
            addCriterion("desc not like", value, "desc");
            return (Criteria) this;
        }

        public Criteria andDescIn(List<String> values) {
            addCriterion("desc in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotIn(List<String> values) {
            addCriterion("desc not in", values, "desc");
            return (Criteria) this;
        }

        public Criteria andDescBetween(String value1, String value2) {
            addCriterion("desc between", value1, value2, "desc");
            return (Criteria) this;
        }

        public Criteria andDescNotBetween(String value1, String value2) {
            addCriterion("desc not between", value1, value2, "desc");
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