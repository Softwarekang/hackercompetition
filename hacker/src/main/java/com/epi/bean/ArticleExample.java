package com.epi.bean;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(Integer value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(Integer value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(Integer value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(Integer value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(Integer value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<Integer> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<Integer> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(Integer value1, Integer value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(Integer value1, Integer value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRAuthorIsNull() {
            addCriterion("r_author is null");
            return (Criteria) this;
        }

        public Criteria andRAuthorIsNotNull() {
            addCriterion("r_author is not null");
            return (Criteria) this;
        }

        public Criteria andRAuthorEqualTo(String value) {
            addCriterion("r_author =", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorNotEqualTo(String value) {
            addCriterion("r_author <>", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorGreaterThan(String value) {
            addCriterion("r_author >", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("r_author >=", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorLessThan(String value) {
            addCriterion("r_author <", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorLessThanOrEqualTo(String value) {
            addCriterion("r_author <=", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorLike(String value) {
            addCriterion("r_author like", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorNotLike(String value) {
            addCriterion("r_author not like", value, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorIn(List<String> values) {
            addCriterion("r_author in", values, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorNotIn(List<String> values) {
            addCriterion("r_author not in", values, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorBetween(String value1, String value2) {
            addCriterion("r_author between", value1, value2, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRAuthorNotBetween(String value1, String value2) {
            addCriterion("r_author not between", value1, value2, "rAuthor");
            return (Criteria) this;
        }

        public Criteria andRSummaryIsNull() {
            addCriterion("r_summary is null");
            return (Criteria) this;
        }

        public Criteria andRSummaryIsNotNull() {
            addCriterion("r_summary is not null");
            return (Criteria) this;
        }

        public Criteria andRSummaryEqualTo(String value) {
            addCriterion("r_summary =", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryNotEqualTo(String value) {
            addCriterion("r_summary <>", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryGreaterThan(String value) {
            addCriterion("r_summary >", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("r_summary >=", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryLessThan(String value) {
            addCriterion("r_summary <", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryLessThanOrEqualTo(String value) {
            addCriterion("r_summary <=", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryLike(String value) {
            addCriterion("r_summary like", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryNotLike(String value) {
            addCriterion("r_summary not like", value, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryIn(List<String> values) {
            addCriterion("r_summary in", values, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryNotIn(List<String> values) {
            addCriterion("r_summary not in", values, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryBetween(String value1, String value2) {
            addCriterion("r_summary between", value1, value2, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRSummaryNotBetween(String value1, String value2) {
            addCriterion("r_summary not between", value1, value2, "rSummary");
            return (Criteria) this;
        }

        public Criteria andRImageIsNull() {
            addCriterion("r_image is null");
            return (Criteria) this;
        }

        public Criteria andRImageIsNotNull() {
            addCriterion("r_image is not null");
            return (Criteria) this;
        }

        public Criteria andRImageEqualTo(String value) {
            addCriterion("r_image =", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageNotEqualTo(String value) {
            addCriterion("r_image <>", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageGreaterThan(String value) {
            addCriterion("r_image >", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageGreaterThanOrEqualTo(String value) {
            addCriterion("r_image >=", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageLessThan(String value) {
            addCriterion("r_image <", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageLessThanOrEqualTo(String value) {
            addCriterion("r_image <=", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageLike(String value) {
            addCriterion("r_image like", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageNotLike(String value) {
            addCriterion("r_image not like", value, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageIn(List<String> values) {
            addCriterion("r_image in", values, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageNotIn(List<String> values) {
            addCriterion("r_image not in", values, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageBetween(String value1, String value2) {
            addCriterion("r_image between", value1, value2, "rImage");
            return (Criteria) this;
        }

        public Criteria andRImageNotBetween(String value1, String value2) {
            addCriterion("r_image not between", value1, value2, "rImage");
            return (Criteria) this;
        }

        public Criteria andRDateIsNull() {
            addCriterion("r_date is null");
            return (Criteria) this;
        }

        public Criteria andRDateIsNotNull() {
            addCriterion("r_date is not null");
            return (Criteria) this;
        }

        public Criteria andRDateEqualTo(String value) {
            addCriterion("r_date =", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotEqualTo(String value) {
            addCriterion("r_date <>", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateGreaterThan(String value) {
            addCriterion("r_date >", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateGreaterThanOrEqualTo(String value) {
            addCriterion("r_date >=", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateLessThan(String value) {
            addCriterion("r_date <", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateLessThanOrEqualTo(String value) {
            addCriterion("r_date <=", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateLike(String value) {
            addCriterion("r_date like", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotLike(String value) {
            addCriterion("r_date not like", value, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateIn(List<String> values) {
            addCriterion("r_date in", values, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotIn(List<String> values) {
            addCriterion("r_date not in", values, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateBetween(String value1, String value2) {
            addCriterion("r_date between", value1, value2, "rDate");
            return (Criteria) this;
        }

        public Criteria andRDateNotBetween(String value1, String value2) {
            addCriterion("r_date not between", value1, value2, "rDate");
            return (Criteria) this;
        }

        public Criteria andRStatusIsNull() {
            addCriterion("r_status is null");
            return (Criteria) this;
        }

        public Criteria andRStatusIsNotNull() {
            addCriterion("r_status is not null");
            return (Criteria) this;
        }

        public Criteria andRStatusEqualTo(Integer value) {
            addCriterion("r_status =", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotEqualTo(Integer value) {
            addCriterion("r_status <>", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusGreaterThan(Integer value) {
            addCriterion("r_status >", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("r_status >=", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusLessThan(Integer value) {
            addCriterion("r_status <", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusLessThanOrEqualTo(Integer value) {
            addCriterion("r_status <=", value, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusIn(List<Integer> values) {
            addCriterion("r_status in", values, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotIn(List<Integer> values) {
            addCriterion("r_status not in", values, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusBetween(Integer value1, Integer value2) {
            addCriterion("r_status between", value1, value2, "rStatus");
            return (Criteria) this;
        }

        public Criteria andRStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("r_status not between", value1, value2, "rStatus");
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