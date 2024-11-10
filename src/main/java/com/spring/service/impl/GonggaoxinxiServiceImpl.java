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

@Service("GonggaoxinxiService")
public class GonggaoxinxiServiceImpl implements GonggaoxinxiService {

    @Resource
    private GonggaoxinxiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Gonggaoxinxi> select() {
        return dao.select(null);
    }

    /**
     * 根据Gonggaoxinxi类搜索数据
     * @param y
     * @return
     */
    public List<Gonggaoxinxi> select(Gonggaoxinxi y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取公告信息一行数据
     * @param id
     * @return
     */
    public Gonggaoxinxi find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据公告信息获取公告信息类条件查询一行数据
     * @param id
     * @return
     */
    public Gonggaoxinxi findEntity(Gonggaoxinxi id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gonggaoxinxi> selectPage(Gonggaoxinxi obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Gonggaoxinxi> list = select(obj);
        PageInfo<Gonggaoxinxi> pageInfo = new PageInfo(list);
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
    public List<Gonggaoxinxi> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Gonggaoxinxi> list = dao.selectByExample(obj);
        PageInfo<Gonggaoxinxi> pageInfo = new PageInfo(list);
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
     * 插入公告信息     * @param y
     * @return
     */
    public int insert(Gonggaoxinxi y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新公告信息     * @param y
     * @return
     */
    public int update(Gonggaoxinxi y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
