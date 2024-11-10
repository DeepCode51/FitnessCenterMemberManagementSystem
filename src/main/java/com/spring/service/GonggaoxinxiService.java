package com.spring.service;

import com.spring.entity.Gonggaoxinxi;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface GonggaoxinxiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Gonggaoxinxi> select();

    /**
     * 根据Gonggaoxinxi类搜索数据
     * @param y
     * @return
     */
    public List<Gonggaoxinxi> select(Gonggaoxinxi y);

    /**
     * 根据主键获取公告信息一行数据
     * @param id
     * @return
     */
    public Gonggaoxinxi find(Object id);

    /**
     * 根据公告信息获取公告信息类条件查询一行数据
     * @param id
     * @return
     */
    public Gonggaoxinxi findEntity(Gonggaoxinxi id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gonggaoxinxi> selectPage(Gonggaoxinxi obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Gonggaoxinxi> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入公告信息     * @param y
     * @return
     */
    public int insert(Gonggaoxinxi y);

    /**
     * 更新公告信息     * @param y
     * @return
     */
    public int update(Gonggaoxinxi y);
}
