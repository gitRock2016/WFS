package com.jp.wonfes.cmmn.dao.mapper;

import com.jp.wonfes.cmmn.dao.qo.EventDates;
import com.jp.wonfes.cmmn.dao.qo.EventDatesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventDatesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int countByExample(EventDatesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByExample(EventDatesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByPrimaryKey(Integer eventDateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insert(EventDates record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insertSelective(EventDates record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    List<EventDates> selectByExample(EventDatesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    EventDates selectByPrimaryKey(Integer eventDateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExampleSelective(@Param("record") EventDates record, @Param("example") EventDatesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExample(@Param("record") EventDates record, @Param("example") EventDatesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKeySelective(EventDates record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.event_dates
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKey(EventDates record);
}