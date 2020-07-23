package com.example.po.test1;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * <p>
 * 测试表
 * </p>
 *
 * @author xuezy
 * @since 2018-11-23
 */
@Data
@TableName("tbl_test")
@KeySequence(value = "SEQ_TBL_TEST")
public class TblTest {

    private static final long serialVersionUID = 1L;

    /**
     * 主键  ORACLE 用 IdType.INPUT
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Integer id;
    /**
     * 名称
     */
    @TableField(value="NAME")
    private String name;
    /**
     * 描述
     */
    @TableField(value="DESCRIPTION")
    private String description;

}
