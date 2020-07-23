package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.mapper.test1.TblTestMapper;
import com.example.mapper.test2.TblTest2Mapper;
import com.example.po.test1.TblTest;
import com.example.po.test2.TblTest2;
import com.example.service.TblTestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author xuezy
 * @since 2018-11-23
 */
@Service
public class TblTestServiceImpl implements TblTestService {

    /**
     * 测试表 Mapper 接口
     */
    @Resource
    TblTestMapper tblTestMapper;

    @Resource
    TblTest2Mapper tblTest2Mapper;


    @Override
    public void saveTblTest(){
        TblTest tblTest = new TblTest();
        tblTest.setName("不妄语");
        tblTest.setDescription("测试1");
        tblTestMapper.saveTblTest4Mysql(tblTest);
    }


    /**
     * @Cacheable(value="tblTest", key = "#p0")
     * @Cacheable缓存key为id(第一个参数值,经过多次尝试，只能为字符串)的数据到缓存tblTest中
     * @param id 主键
     * @return
     * @throws Exception
     */
    @Override
    public JSONObject getTblTest(String id) throws Exception {
        JSONObject json = new JSONObject();
        TblTest tblTest = tblTestMapper.selectById(id);
        json.put("data", tblTest);
        return json;
    }

    @Override
    public JSONObject getTblTest2(String id) throws Exception {
        JSONObject json = new JSONObject();
        TblTest2 tblTest = tblTest2Mapper.selectById(id);
        json.put("data", tblTest);
        return json;
    }

    // 主库事务可以不用指定transactional配置
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveTblTest1(){
        TblTest tblTest = new TblTest();
        tblTest.setName("地藏菩萨1");
        tblTest.setDescription("行大愿1");
//        tblTest.setName("观音菩萨");
//        tblTest.setDescription("行大悲");
//        tblTest.setName("普贤菩萨111");
//        tblTest.setDescription("行大力111");
        // 写入oracle
        tblTestMapper.saveTblTest(tblTest);
        // 写入mysql
//        tblTestMapper.saveTblTest4Mysql(tblTest);
        int a = 1/0;
        System.out.println(a);
    }

    // 从库必须指定transactional事务配置  DataSource2Config中 test2TransactionManager
    @Transactional(rollbackFor = Exception.class, value = "test2TransactionManager")
    @Override
    public void saveTblTest2(){
        TblTest2 tblTest2 = new TblTest2();

        tblTest2.setName("观音菩萨1");
        tblTest2.setDescription("行大悲1");
//        tblTest.setName("普贤菩萨");
//        tblTest.setDescription("行大力");
//        tblTest2.setName("文殊菩萨222-1");
//        tblTest2.setDescription("行大智222-1");
        // 写入oracle
        tblTest2Mapper.saveTblTest2(tblTest2);
        // 写入mysql
//        tblTest2Mapper.saveTblTest4Mysql(tblTest2);
        int a = 1/0;
        System.out.println(a);
    }
}
