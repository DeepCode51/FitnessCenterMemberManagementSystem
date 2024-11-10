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

@Service("HuiyuankaService")
public class HuiyuankaServiceImpl implements HuiyuankaService {

    @Resource
    private HuiyuankaMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Huiyuanka> select() {
        return dao.select(null);
    }

    /**
     * 根据Huiyuanka类搜索数据
     * @param y
     * @return
     */
    public List<Huiyuanka> select(Huiyuanka y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取会员卡一行数据
     * @param id
     * @return
     */
    public Huiyuanka find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据会员卡获取会员卡类条件查询一行数据
     * @param id
     * @return
     */
    public Huiyuanka findEntity(Huiyuanka id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Huiyuanka> selectPage(Huiyuanka obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Huiyuanka> list = select(obj);
        PageInfo<Huiyuanka> pageInfo = new PageInfo(list);
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
    public List<Huiyuanka> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Huiyuanka> list = dao.selectByExample(obj);
        PageInfo<Huiyuanka> pageInfo = new PageInfo(list);
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
     * 插入会员卡     * @param y
     * @return
     */
    public int insert(Huiyuanka y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新会员卡     * @param y
     * @return
     */
    public int update(Huiyuanka y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
