package cn.mogeek.rmi.ptteng.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table banner
 *
 * @mbg.generated do_not_delete_during_merge Mon Jul 20 02:59:46 CST 2020
 */
@Data
public class Banner implements Serializable {
    private static final long serialVersionUID = 7922376624132141432L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.id
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   图片地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.imges
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private String imges;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.updateat
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Date updateat;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column banner.createat
     *
     * @mbg.generated Mon Jul 20 02:59:46 CST 2020
     */
    private Date createat;
}