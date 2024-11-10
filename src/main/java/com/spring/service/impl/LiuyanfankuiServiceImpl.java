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

@Service("LiuyanfankuiService")
public class LiuyanfankuiServiceImpl implements LiuyanfankuiService {

    @Resource
    private LiuyanfankuiMapper dao;

    /**
     * 获取所有数据
     * @return
     */
    public List<Liuyanfankui> select() {
        return dao.select(null);
    }

    /**
     * 根据Liuyanfankui类搜索数据
     * @param y
     * @return
     */
    public List<Liuyanfankui> select(Liuyanfankui y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取留言反馈一行数据
     * @param id
     * @return
     */
    public Liuyanfankui find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据留言反馈获取留言反馈类条件查询一行数据
     * @param id
     * @return
     */
    public Liuyanfankui findEntity(Liuyanfankui id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Liuyanfankui> selectPage(Liuyanfankui obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Liuyanfankui> list = select(obj);
        PageInfo<Liuyanfankui> pageInfo = new PageInfo(list);
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
    public List<Liuyanfankui> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Liuyanfankui> list = dao.selectByExample(obj);
        PageInfo<Liuyanfankui> pageInfo = new PageInfo(list);
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
     * 插入留言反馈     * @param y
     * @return
     */
    public int insert(Liuyanfankui y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新留言反馈     * @param y
     * @return
     */
    public int update(Liuyanfankui y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
