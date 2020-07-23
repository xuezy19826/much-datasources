package com.example.mapper.test1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.po.test1.TblTest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 测试表 Mapper 接口
 * </p>
 *
 * @author xuezy
 * @since 2020-7-23
 */
@Repository
public interface TblTestMapper extends BaseMapper<TblTest> {

	void saveTblTest(@Param("entity") TblTest entity);

	void saveTblTest4Mysql(@Param("entity") TblTest entity);

}
