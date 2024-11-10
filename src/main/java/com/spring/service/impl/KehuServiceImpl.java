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

@Service("KehuService")
public class KehuServiceImpl implements KehuService {

    @Resource
    private KehuMapper dao;

    public Kehu login(String username, String password) {
        Kehu user = new Kehu();
        user.setZhanghao(username);
        user.setMima(password);

        return this.dao.login(user);
    }

    public boolean updatePassword(int id, String newPassword) {
        Kehu user = new Kehu();
        user.setId(id);
        user.setMima(newPassword);
        int i = this.dao.updateByPrimaryKeySelective(user);
        return i == 1;
    }

    /**
     * 获取所有数据
     * @return
     */
    public List<Kehu> select() {
        return dao.select(null);
    }

    /**
     * 根据Kehu类搜索数据
     * @param y
     * @return
     */
    public List<Kehu> select(Kehu y) {
        return dao.select(y);
    }

    /**
     * 根据主键获取客户一行数据
     * @param id
     * @return
     */
    public Kehu find(Object id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 根据客户获取客户类条件查询一行数据
     * @param id
     * @return
     */
    public Kehu findEntity(Kehu id) {
        return dao.selectOne(id);
    }

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Kehu> selectPage(Kehu obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Kehu> list = select(obj);
        PageInfo<Kehu> pageInfo = new PageInfo(list);
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
    public List<Kehu> selectPageExample(Example obj, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Kehu> list = dao.selectByExample(obj);
        PageInfo<Kehu> pageInfo = new PageInfo(list);
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
     * 插入客户     * @param y
     * @return
     */
    public int insert(Kehu y) {
        return dao.insertSelective(y);
    }

    /**
     * 更新客户     * @param y
     * @return
     */
    public int update(Kehu y) {
        return dao.updateByPrimaryKeySelective(y);
    }
}
