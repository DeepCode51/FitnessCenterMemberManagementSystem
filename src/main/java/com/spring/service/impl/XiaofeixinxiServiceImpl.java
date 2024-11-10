package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service("XiaofeixinxiService")
public class XiaofeixinxiServiceImpl implements XiaofeixinxiService {

    @Resource
    private XiaofeixinxiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Xiaofeixinxi> select() {
        return dao.select(null);
    }

    /**
     * 根据Xiaofeixinxi类搜索数据
     * @param y
     * @return
     */
    public List<Xiaofeixinxi> select(Xiaofeixinxi y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取消费信息一行数据
     * @param id
     * @return
     */
    public Xiaofeixinxi find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据消费信息获取消费信息类条件查询一行数据
     * @param id
     * @return
     */
    public Xiaofeixinxi findEntity(Xiaofeixinxi id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaofeixinxi> selectPage(Xiaofeixinxi obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Xiaofeixinxi> list = select(obj);
        PageInfo<Xiaofeixinxi> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaofeixinxi> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Xiaofeixinxi> list = dao.selectByExample(obj);
        PageInfo<Xiaofeixinxi> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id) {
        return dao.deleteByPrimaryKey(id);
    }

    /**
     * 插入消费信息     * @param y
     * @return
     */
    public int insert(Xiaofeixinxi y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新消费信息     * @param y
     * @return
     */
    public int update(Xiaofeixinxi y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
