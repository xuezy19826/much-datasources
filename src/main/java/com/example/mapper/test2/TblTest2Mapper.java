package com.example.mapper.test2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.po.test2.TblTest2;
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
public interface TblTest2Mapper extends BaseMapper<TblTest2> {

	void saveTblTest2(@Param("entity") TblTest2 entity);

	void saveTblTest4Mysql(@Param("entity") TblTest2 entity);

}
