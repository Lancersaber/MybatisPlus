package com.example.homework.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public NewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
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

        public Criteria andNewsIdIsNull() {
            addCriterion("NewsId is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("NewsId is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Integer value) {
            addCriterion("NewsId =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Integer value) {
            addCriterion("NewsId <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Integer value) {
            addCriterion("NewsId >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("NewsId >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Integer value) {
            addCriterion("NewsId <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Integer value) {
            addCriterion("NewsId <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Integer> values) {
            addCriterion("NewsId in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Integer> values) {
            addCriterion("NewsId not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Integer value1, Integer value2) {
            addCriterion("NewsId between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("NewsId not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNull() {
            addCriterion("NewsTitle is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("NewsTitle is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("NewsTitle =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("NewsTitle <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("NewsTitle >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("NewsTitle >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("NewsTitle <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("NewsTitle <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("NewsTitle like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("NewsTitle not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("NewsTitle in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("NewsTitle not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("NewsTitle between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("NewsTitle not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNull() {
            addCriterion("NewsTime is null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIsNotNull() {
            addCriterion("NewsTime is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTimeEqualTo(Date value) {
            addCriterion("NewsTime =", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotEqualTo(Date value) {
            addCriterion("NewsTime <>", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThan(Date value) {
            addCriterion("NewsTime >", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("NewsTime >=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThan(Date value) {
            addCriterion("NewsTime <", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeLessThanOrEqualTo(Date value) {
            addCriterion("NewsTime <=", value, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeIn(List<Date> values) {
            addCriterion("NewsTime in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotIn(List<Date> values) {
            addCriterion("NewsTime not in", values, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeBetween(Date value1, Date value2) {
            addCriterion("NewsTime between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsTimeNotBetween(Date value1, Date value2) {
            addCriterion("NewsTime not between", value1, value2, "newsTime");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNull() {
            addCriterion("NewsAuthor is null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNotNull() {
            addCriterion("NewsAuthor is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorEqualTo(String value) {
            addCriterion("NewsAuthor =", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotEqualTo(String value) {
            addCriterion("NewsAuthor <>", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThan(String value) {
            addCriterion("NewsAuthor >", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("NewsAuthor >=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThan(String value) {
            addCriterion("NewsAuthor <", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThanOrEqualTo(String value) {
            addCriterion("NewsAuthor <=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLike(String value) {
            addCriterion("NewsAuthor like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotLike(String value) {
            addCriterion("NewsAuthor not like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIn(List<String> values) {
            addCriterion("NewsAuthor in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotIn(List<String> values) {
            addCriterion("NewsAuthor not in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorBetween(String value1, String value2) {
            addCriterion("NewsAuthor between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotBetween(String value1, String value2) {
            addCriterion("NewsAuthor not between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andSave1IsNull() {
            addCriterion("Save1 is null");
            return (Criteria) this;
        }

        public Criteria andSave1IsNotNull() {
            addCriterion("Save1 is not null");
            return (Criteria) this;
        }

        public Criteria andSave1EqualTo(String value) {
            addCriterion("Save1 =", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1NotEqualTo(String value) {
            addCriterion("Save1 <>", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1GreaterThan(String value) {
            addCriterion("Save1 >", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1GreaterThanOrEqualTo(String value) {
            addCriterion("Save1 >=", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1LessThan(String value) {
            addCriterion("Save1 <", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1LessThanOrEqualTo(String value) {
            addCriterion("Save1 <=", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1Like(String value) {
            addCriterion("Save1 like", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1NotLike(String value) {
            addCriterion("Save1 not like", value, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1In(List<String> values) {
            addCriterion("Save1 in", values, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1NotIn(List<String> values) {
            addCriterion("Save1 not in", values, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1Between(String value1, String value2) {
            addCriterion("Save1 between", value1, value2, "save1");
            return (Criteria) this;
        }

        public Criteria andSave1NotBetween(String value1, String value2) {
            addCriterion("Save1 not between", value1, value2, "save1");
            return (Criteria) this;
        }

        public Criteria andSave2IsNull() {
            addCriterion("Save2 is null");
            return (Criteria) this;
        }

        public Criteria andSave2IsNotNull() {
            addCriterion("Save2 is not null");
            return (Criteria) this;
        }

        public Criteria andSave2EqualTo(String value) {
            addCriterion("Save2 =", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2NotEqualTo(String value) {
            addCriterion("Save2 <>", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2GreaterThan(String value) {
            addCriterion("Save2 >", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2GreaterThanOrEqualTo(String value) {
            addCriterion("Save2 >=", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2LessThan(String value) {
            addCriterion("Save2 <", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2LessThanOrEqualTo(String value) {
            addCriterion("Save2 <=", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2Like(String value) {
            addCriterion("Save2 like", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2NotLike(String value) {
            addCriterion("Save2 not like", value, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2In(List<String> values) {
            addCriterion("Save2 in", values, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2NotIn(List<String> values) {
            addCriterion("Save2 not in", values, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2Between(String value1, String value2) {
            addCriterion("Save2 between", value1, value2, "save2");
            return (Criteria) this;
        }

        public Criteria andSave2NotBetween(String value1, String value2) {
            addCriterion("Save2 not between", value1, value2, "save2");
            return (Criteria) this;
        }

        public Criteria andSave3IsNull() {
            addCriterion("Save3 is null");
            return (Criteria) this;
        }

        public Criteria andSave3IsNotNull() {
            addCriterion("Save3 is not null");
            return (Criteria) this;
        }

        public Criteria andSave3EqualTo(String value) {
            addCriterion("Save3 =", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3NotEqualTo(String value) {
            addCriterion("Save3 <>", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3GreaterThan(String value) {
            addCriterion("Save3 >", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3GreaterThanOrEqualTo(String value) {
            addCriterion("Save3 >=", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3LessThan(String value) {
            addCriterion("Save3 <", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3LessThanOrEqualTo(String value) {
            addCriterion("Save3 <=", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3Like(String value) {
            addCriterion("Save3 like", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3NotLike(String value) {
            addCriterion("Save3 not like", value, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3In(List<String> values) {
            addCriterion("Save3 in", values, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3NotIn(List<String> values) {
            addCriterion("Save3 not in", values, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3Between(String value1, String value2) {
            addCriterion("Save3 between", value1, value2, "save3");
            return (Criteria) this;
        }

        public Criteria andSave3NotBetween(String value1, String value2) {
            addCriterion("Save3 not between", value1, value2, "save3");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table News
     *
     * @mbg.generated do_not_delete_during_merge Sat Apr 11 19:18:02 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table News
     *
     * @mbg.generated Sat Apr 11 19:18:02 CST 2020
     */
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