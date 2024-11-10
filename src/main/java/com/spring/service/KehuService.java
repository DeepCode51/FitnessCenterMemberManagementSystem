package com.spring.service;

import com.spring.entity.Kehu;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface KehuService {
    public Kehu login(String username, String password);

    public boolean updatePassword(int id, String newPassword);

    /**
     * 获取所有数据
     * @return
     */
    public List<Kehu> select();

    /**
     * 根据Kehu类搜索数据
     * @param y
     * @return
     */
    public List<Kehu> select(Kehu y);

    /**
     * 根据主键获取客户一行数据
     * @param id
     * @return
     */
    public Kehu find(Object id);

    /**
     * 根据客户获取客户类条件查询一行数据
     * @param id
     * @return
     */
    public Kehu findEntity(Kehu id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Kehu> selectPage(Kehu obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Kehu> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入客户     * @param y
     * @return
     */
    public int insert(Kehu y);

    /**
     * 更新客户     * @param y
     * @return
     */
    public int update(Kehu y);
}
