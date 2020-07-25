package cn.mogeek.rmi.ptteng.mapper;

import cn.mogeek.rmi.ptteng.model.Representative;
import cn.mogeek.rmi.ptteng.model.RepresentativeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepresentativeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    long countByExample(RepresentativeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int deleteByExample(RepresentativeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int insert(Representative record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int insertSelective(Representative record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    List<Representative> selectByExample(RepresentativeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    Representative selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int updateByExampleSelective(@Param("record") Representative record, @Param("example") RepresentativeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int updateByExample(@Param("record") Representative record, @Param("example") RepresentativeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int updateByPrimaryKeySelective(Representative record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table representative
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    int updateByPrimaryKey(Representative record);
}