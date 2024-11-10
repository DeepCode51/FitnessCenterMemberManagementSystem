package com.spring.service;

import com.spring.entity.Xiaofeixinxi;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface XiaofeixinxiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Xiaofeixinxi> select();

    /**
     * 根据Xiaofeixinxi类搜索数据
     * @param y
     * @return
     */
    public List<Xiaofeixinxi> select(Xiaofeixinxi y);

    /**
     * 根据主键获取消费信息一行数据
     * @param id
     * @return
     */
    public Xiaofeixinxi find(Object id);

    /**
     * 根据消费信息获取消费信息类条件查询一行数据
     * @param id
     * @return
     */
    public Xiaofeixinxi findEntity(Xiaofeixinxi id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaofeixinxi> selectPage(Xiaofeixinxi obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Xiaofeixinxi> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入消费信息     * @param y
     * @return
     */
    public int insert(Xiaofeixinxi y);

    /**
     * 更新消费信息     * @param y
     * @return
     */
    public int update(Xiaofeixinxi y);
}
