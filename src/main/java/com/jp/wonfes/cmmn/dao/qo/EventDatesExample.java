package com.jp.wonfes.cmmn.dao.qo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EventDatesExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public EventDatesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
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
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEventDateIdIsNull() {
            addCriterion("event_date_id is null");
            return (Criteria) this;
        }

        public Criteria andEventDateIdIsNotNull() {
            addCriterion("event_date_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventDateIdEqualTo(Integer value) {
            addCriterion("event_date_id =", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdNotEqualTo(Integer value) {
            addCriterion("event_date_id <>", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdGreaterThan(Integer value) {
            addCriterion("event_date_id >", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_date_id >=", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdLessThan(Integer value) {
            addCriterion("event_date_id <", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdLessThanOrEqualTo(Integer value) {
            addCriterion("event_date_id <=", value, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdIn(List<Integer> values) {
            addCriterion("event_date_id in", values, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdNotIn(List<Integer> values) {
            addCriterion("event_date_id not in", values, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdBetween(Integer value1, Integer value2) {
            addCriterion("event_date_id between", value1, value2, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventDateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("event_date_id not between", value1, value2, "eventDateId");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateIsNull() {
            addCriterion("event_aboutdate is null");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateIsNotNull() {
            addCriterion("event_aboutdate is not null");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateEqualTo(String value) {
            addCriterion("event_aboutdate =", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateNotEqualTo(String value) {
            addCriterion("event_aboutdate <>", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateGreaterThan(String value) {
            addCriterion("event_aboutdate >", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateGreaterThanOrEqualTo(String value) {
            addCriterion("event_aboutdate >=", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateLessThan(String value) {
            addCriterion("event_aboutdate <", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateLessThanOrEqualTo(String value) {
            addCriterion("event_aboutdate <=", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateLike(String value) {
            addCriterion("event_aboutdate like", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateNotLike(String value) {
            addCriterion("event_aboutdate not like", value, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateIn(List<String> values) {
            addCriterion("event_aboutdate in", values, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateNotIn(List<String> values) {
            addCriterion("event_aboutdate not in", values, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateBetween(String value1, String value2) {
            addCriterion("event_aboutdate between", value1, value2, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventAboutdateNotBetween(String value1, String value2) {
            addCriterion("event_aboutdate not between", value1, value2, "eventAboutdate");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNull() {
            addCriterion("event_date is null");
            return (Criteria) this;
        }

        public Criteria andEventDateIsNotNull() {
            addCriterion("event_date is not null");
            return (Criteria) this;
        }

        public Criteria andEventDateEqualTo(Date value) {
            addCriterionForJDBCDate("event_date =", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("event_date <>", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThan(Date value) {
            addCriterionForJDBCDate("event_date >", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("event_date >=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThan(Date value) {
            addCriterionForJDBCDate("event_date <", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("event_date <=", value, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateIn(List<Date> values) {
            addCriterionForJDBCDate("event_date in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("event_date not in", values, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("event_date between", value1, value2, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("event_date not between", value1, value2, "eventDate");
            return (Criteria) this;
        }

        public Criteria andEventSeasonIsNull() {
            addCriterion("event_season is null");
            return (Criteria) this;
        }

        public Criteria andEventSeasonIsNotNull() {
            addCriterion("event_season is not null");
            return (Criteria) this;
        }

        public Criteria andEventSeasonEqualTo(String value) {
            addCriterion("event_season =", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonNotEqualTo(String value) {
            addCriterion("event_season <>", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonGreaterThan(String value) {
            addCriterion("event_season >", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonGreaterThanOrEqualTo(String value) {
            addCriterion("event_season >=", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonLessThan(String value) {
            addCriterion("event_season <", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonLessThanOrEqualTo(String value) {
            addCriterion("event_season <=", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonLike(String value) {
            addCriterion("event_season like", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonNotLike(String value) {
            addCriterion("event_season not like", value, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonIn(List<String> values) {
            addCriterion("event_season in", values, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonNotIn(List<String> values) {
            addCriterion("event_season not in", values, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonBetween(String value1, String value2) {
            addCriterion("event_season between", value1, value2, "eventSeason");
            return (Criteria) this;
        }

        public Criteria andEventSeasonNotBetween(String value1, String value2) {
            addCriterion("event_season not between", value1, value2, "eventSeason");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wfs.event_dates
     *
     * @mbggenerated do_not_delete_during_merge Sat Oct 20 11:37:01 JST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
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