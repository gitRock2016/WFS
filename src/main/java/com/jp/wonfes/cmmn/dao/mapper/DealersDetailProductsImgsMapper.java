package com.jp.wonfes.cmmn.dao.mapper;

import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgs;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsExample;
import com.jp.wonfes.cmmn.dao.qo.DealersDetailProductsImgsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DealersDetailProductsImgsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int countByExample(DealersDetailProductsImgsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int deleteByExample(DealersDetailProductsImgsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int deleteByPrimaryKey(DealersDetailProductsImgsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int insert(DealersDetailProductsImgs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int insertSelective(DealersDetailProductsImgs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    List<DealersDetailProductsImgs> selectByExample(DealersDetailProductsImgsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    DealersDetailProductsImgs selectByPrimaryKey(DealersDetailProductsImgsKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int updateByExampleSelective(@Param("record") DealersDetailProductsImgs record, @Param("example") DealersDetailProductsImgsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int updateByExample(@Param("record") DealersDetailProductsImgs record, @Param("example") DealersDetailProductsImgsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int updateByPrimaryKeySelective(DealersDetailProductsImgs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wfs.dealers_detail_products_imgs
     *
     * @mbggenerated Sat Jan 05 12:39:34 JST 2019
     */
    int updateByPrimaryKey(DealersDetailProductsImgs record);
}