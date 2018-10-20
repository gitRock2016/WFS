package com.jp.wonfes.cmmn.dao.mapper;

import com.jp.wonfes.cmmn.dao.qo.DealersDetailProducts;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealersDetailProductsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int countByExample(DealersDetailProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByExample(DealersDetailProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int deleteByPrimaryKey(DealersDetailProductsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insert(DealersDetailProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int insertSelective(DealersDetailProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    List<DealersDetailProducts> selectByExample(DealersDetailProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    DealersDetailProducts selectByPrimaryKey(DealersDetailProductsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExampleSelective(@Param("record") DealersDetailProducts record, @Param("example") DealersDetailProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByExample(@Param("record") DealersDetailProducts record, @Param("example") DealersDetailProductsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKeySelective(DealersDetailProducts record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products
     *
     * @mbggenerated Sat Oct 20 11:37:01 JST 2018
     */
    int updateByPrimaryKey(DealersDetailProducts record);
}