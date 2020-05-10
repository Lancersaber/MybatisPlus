package com.example.homework.sqlMapper;

import com.example.homework.bean.Institute;
import com.example.homework.bean.InstituteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstituteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    long countByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int deleteByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int deleteByPrimaryKey(Integer instituteId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int insert(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int insertSelective(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    List<Institute> selectByExample(InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    Institute selectByPrimaryKey(Integer instituteId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int updateByExampleSelective(@Param("record") Institute record, @Param("example") InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int updateByExample(@Param("record") Institute record, @Param("example") InstituteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int updateByPrimaryKeySelective(Institute record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Institute
     *
     * @mbg.generated Sat Apr 11 16:02:06 CST 2020
     */
    int updateByPrimaryKey(Institute record);
}