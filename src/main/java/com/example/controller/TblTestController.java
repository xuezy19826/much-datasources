package com.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.service.TblTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 测试表 前端控制器
 * </p>
 *
 * @author xuezy
 * @since 2018-11-23
 */
@RestController
@RequestMapping("/tblTest")
public class TblTestController {

    private static final Logger _log = LoggerFactory.getLogger(TblTestController.class);

    /**
     * 测试表 服务类
     */
    @Resource
    private TblTestService tblTestService;

    /**
     * 写入数据到测试表
     * @author xuezy
     * @date 2018/11/23 17:28
     * @param
     * @throws
     * @return
     */
    @RequestMapping("/saveTblTest")
    public void saveTblTest(){
        JSONObject json = new JSONObject();
        try {
            tblTestService.saveTblTest();
        } catch (Exception e) {
            _log.info("方法：[saveTblTest],写入数据失败，异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 获取数据  使用DB注解
     * @author xuezy
     * @date 2018/11/23 17:28
     * @param
     * @throws
     * @return
     */
    @RequestMapping("/getTblTest/{id}")
    public JSONObject getTblTest(@PathVariable("id") String id){
        JSONObject json = new JSONObject();
        try {
            json = tblTestService.getTblTest(id);
            json.put("code", 200);
            json.put("msg", "成功！");
        } catch (Exception e) {
            json.put("code", 500);
            json.put("msg","失败！");
            _log.info("方法：getTblTest,获取数据失败，异常：" + e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 获取数据  不使用DB注解
     * @author xuezy
     * @date 2018/11/23 17:28
     * @param
     * @throws
     * @return
     */
    @RequestMapping("/getTblTest2/{id}")
    public JSONObject getTblTest2(@PathVariable("id") String id){
        JSONObject json = new JSONObject();
        try {
            json = tblTestService.getTblTest2(id);
            json.put("code", 200);
            json.put("msg", "成功！");
        } catch (Exception e) {
            json.put("code", 500);
            json.put("msg","失败！");
            _log.info("方法：getTblTest2,获取数据失败，异常：" + e.getMessage());
            e.printStackTrace();
        }
        return json;
    }

    /**
     * db1中写入数据
     * @author xuezy
     * @date 2018/11/27 19:19
     * @param
     * @throws
     * @return
     */
    @RequestMapping("/saveTblTest1")
    public void saveTblTest1(){
        try {
            tblTestService.saveTblTest1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * db2中写入数据
     * @author xuezy
     * @date 2018/11/27 19:19
     * @param
     * @throws
     * @return
     */
    @RequestMapping("/saveTblTest2")
    public void saveTblTest2(){
        try {
            tblTestService.saveTblTest2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

