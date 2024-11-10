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

@Service("FankuihuifuService")
public class FankuihuifuServiceImpl implements FankuihuifuService {

    @Resource
    private FankuihuifuMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Fankuihuifu> select() {
        return dao.select(null);
    }

    /**
     * 根据Fankuihuifu类搜索数据
     * @param y
     * @return
     */
    public List<Fankuihuifu> select(Fankuihuifu y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取反馈回复一行数据
     * @param id
     * @return
     */
    public Fankuihuifu find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据反馈回复获取反馈回复类条件查询一行数据
     * @param id
     * @return
     */
    public Fankuihuifu findEntity(Fankuihuifu id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Fankuihuifu> selectPage(Fankuihuifu obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Fankuihuifu> list = select(obj);
        PageInfo<Fankuihuifu> pageInfo = new PageInfo(list);
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
    public List<Fankuihuifu> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Fankuihuifu> list = dao.selectByExample(obj);
        PageInfo<Fankuihuifu> pageInfo = new PageInfo(list);
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
     * 插入反馈回复     * @param y
     * @return
     */
    public int insert(Fankuihuifu y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新反馈回复     * @param y
     * @return
     */
    public int update(Fankuihuifu y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
