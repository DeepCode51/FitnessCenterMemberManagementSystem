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

@Service("ChongzhixinxiService")
public class ChongzhixinxiServiceImpl implements ChongzhixinxiService {

    @Resource
    private ChongzhixinxiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Chongzhixinxi> select() {
        return dao.select(null);
    }

    /**
     * 根据Chongzhixinxi类搜索数据
     * @param y
     * @return
     */
    public List<Chongzhixinxi> select(Chongzhixinxi y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取充值信息一行数据
     * @param id
     * @return
     */
    public Chongzhixinxi find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据充值信息获取充值信息类条件查询一行数据
     * @param id
     * @return
     */
    public Chongzhixinxi findEntity(Chongzhixinxi id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Chongzhixinxi> selectPage(Chongzhixinxi obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Chongzhixinxi> list = select(obj);
        PageInfo<Chongzhixinxi> pageInfo = new PageInfo(list);
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
    public List<Chongzhixinxi> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Chongzhixinxi> list = dao.selectByExample(obj);
        PageInfo<Chongzhixinxi> pageInfo = new PageInfo(list);
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
     * 插入充值信息     * @param y
     * @return
     */
    public int insert(Chongzhixinxi y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新充值信息     * @param y
     * @return
     */
    public int update(Chongzhixinxi y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
