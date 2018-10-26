package cn.atc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartformulaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PartformulaExample() {
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

        public Criteria andFormulaNameIsNull() {
            addCriterion("formulaName is null");
            return (Criteria) this;
        }

        public Criteria andFormulaNameIsNotNull() {
            addCriterion("formulaName is not null");
            return (Criteria) this;
        }

        public Criteria andFormulaNameEqualTo(String value) {
            addCriterion("formulaName =", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameNotEqualTo(String value) {
            addCriterion("formulaName <>", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameGreaterThan(String value) {
            addCriterion("formulaName >", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameGreaterThanOrEqualTo(String value) {
            addCriterion("formulaName >=", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameLessThan(String value) {
            addCriterion("formulaName <", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameLessThanOrEqualTo(String value) {
            addCriterion("formulaName <=", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameLike(String value) {
            addCriterion("formulaName like", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameNotLike(String value) {
            addCriterion("formulaName not like", value, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameIn(List<String> values) {
            addCriterion("formulaName in", values, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameNotIn(List<String> values) {
            addCriterion("formulaName not in", values, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameBetween(String value1, String value2) {
            addCriterion("formulaName between", value1, value2, "formulaName");
            return (Criteria) this;
        }

        public Criteria andFormulaNameNotBetween(String value1, String value2) {
            addCriterion("formulaName not between", value1, value2, "formulaName");
            return (Criteria) this;
        }

        public Criteria andCompilersIsNull() {
            addCriterion("compilers is null");
            return (Criteria) this;
        }

        public Criteria andCompilersIsNotNull() {
            addCriterion("compilers is not null");
            return (Criteria) this;
        }

        public Criteria andCompilersEqualTo(Long value) {
            addCriterion("compilers =", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersNotEqualTo(Long value) {
            addCriterion("compilers <>", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersGreaterThan(Long value) {
            addCriterion("compilers >", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersGreaterThanOrEqualTo(Long value) {
            addCriterion("compilers >=", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersLessThan(Long value) {
            addCriterion("compilers <", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersLessThanOrEqualTo(Long value) {
            addCriterion("compilers <=", value, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersIn(List<Long> values) {
            addCriterion("compilers in", values, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersNotIn(List<Long> values) {
            addCriterion("compilers not in", values, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersBetween(Long value1, Long value2) {
            addCriterion("compilers between", value1, value2, "compilers");
            return (Criteria) this;
        }

        public Criteria andCompilersNotBetween(Long value1, Long value2) {
            addCriterion("compilers not between", value1, value2, "compilers");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeIsNull() {
            addCriterion("lastChangeTime is null");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeIsNotNull() {
            addCriterion("lastChangeTime is not null");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeEqualTo(Date value) {
            addCriterion("lastChangeTime =", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotEqualTo(Date value) {
            addCriterion("lastChangeTime <>", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeGreaterThan(Date value) {
            addCriterion("lastChangeTime >", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastChangeTime >=", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeLessThan(Date value) {
            addCriterion("lastChangeTime <", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastChangeTime <=", value, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeIn(List<Date> values) {
            addCriterion("lastChangeTime in", values, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotIn(List<Date> values) {
            addCriterion("lastChangeTime not in", values, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeBetween(Date value1, Date value2) {
            addCriterion("lastChangeTime between", value1, value2, "lastChangeTime");
            return (Criteria) this;
        }

        public Criteria andLastChangeTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastChangeTime not between", value1, value2, "lastChangeTime");
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