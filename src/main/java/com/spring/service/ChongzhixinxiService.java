package com.spring.service;

import com.spring.entity.Chongzhixinxi;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface ChongzhixinxiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Chongzhixinxi> select();

    /**
     * 根据Chongzhixinxi类搜索数据
     * @param y
     * @return
     */
    public List<Chongzhixinxi> select(Chongzhixinxi y);

    /**
     * 根据主键获取充值信息一行数据
     * @param id
     * @return
     */
    public Chongzhixinxi find(Object id);

    /**
     * 根据充值信息获取充值信息类条件查询一行数据
     * @param id
     * @return
     */
    public Chongzhixinxi findEntity(Chongzhixinxi id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Chongzhixinxi> selectPage(Chongzhixinxi obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Chongzhixinxi> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入充值信息     * @param y
     * @return
     */
    public int insert(Chongzhixinxi y);

    /**
     * 更新充值信息     * @param y
     * @return
     */
    public int update(Chongzhixinxi y);
}
