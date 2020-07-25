package cn.mogeek.rmi.ptteng.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table representative
 *
 * @mbg.generated do_not_delete_during_merge Mon Jul 20 02:59:46 CST 2020
 */
@Data
public class Representative implements Serializable {
    private static final long serialVersionUID = 6621228260425834676L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.id
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   学员姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.name
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private String name;

    /**
     * Database Column Remarks:
     *   头像图片地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.imges
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private String imges;

    /**
     * Database Column Remarks:
     *   学习方向
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.major
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private String major;

    /**
     * Database Column Remarks:
     *   学员简介
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.introduction
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private String introduction;

    /**
     * Database Column Remarks:
     *   薪资
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.salary
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Integer salary;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.updateat
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Date updateat;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column representative.createat
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Date createat;
}