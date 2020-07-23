package com.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>
 * 测试表 服务类
 * </p>
 *
 * @author xuezy
 * @since 2018-11-23
 */
public interface TblTestService {

    /**
     * 保存数据
     * @author xuezy
     * @date 2018/11/23 18:26
     * @param
     * @throws Exception
     * @return
     */
    void saveTblTest();

    /**
     * 根据主键获取数据（使用redis缓存） 使用DB2
     * @author xuezy
     * @date 2018/11/27 14:35
     * @param id 主键
     * @throws Exception
     * @return
     */
    JSONObject getTblTest(String id) throws Exception;

    /**
     * @describe 根据主键获取数据  不适用DB注解
     * @author xuezy
     * @date 2020/7/14 14:45
     * @param id
     * @return com.alibaba.fastjson.JSONObject
     */
    JSONObject getTblTest2(String id) throws Exception;

    /**
     * db1中写入数据
     * @author xuezy
     * @date 2018/11/27 19:11
     * @param 
     * @throws 
     * @return 
     */
    void saveTblTest1() throws Exception;

    /**
     * db2中写入数据
     * @author xuezy
     * @date 2018/11/27 19:11
     * @param
     * @throws
     * @return
     */
    void saveTblTest2() throws Exception;

}
