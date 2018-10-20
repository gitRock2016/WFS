package com.jp.wonfes.cmmn.dao.mapper;

import com.jp.wonfes.cmmn.dao.qo.Dealers;
import com.jp.wonfes.cmmn.dao.qo.DealersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int countByExample(DealersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByExample(DealersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByPrimaryKey(Integer dealerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insert(Dealers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insertSelective(Dealers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    List<Dealers> selectByExample(DealersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    Dealers selectByPrimaryKey(Integer dealerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExampleSelective(@Param("record") Dealers record, @Param("example") DealersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExample(@Param("record") Dealers record, @Param("example") DealersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKeySelective(Dealers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKey(Dealers record);
}