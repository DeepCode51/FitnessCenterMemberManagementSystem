package com.spring.service;

import com.spring.entity.Fankuihuifu;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface FankuihuifuService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Fankuihuifu> select();

    /**
     * 根据Fankuihuifu类搜索数据
     * @param y
     * @return
     */
    public List<Fankuihuifu> select(Fankuihuifu y);

    /**
     * 根据主键获取反馈回复一行数据
     * @param id
     * @return
     */
    public Fankuihuifu find(Object id);

    /**
     * 根据反馈回复获取反馈回复类条件查询一行数据
     * @param id
     * @return
     */
    public Fankuihuifu findEntity(Fankuihuifu id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Fankuihuifu> selectPage(Fankuihuifu obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Fankuihuifu> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入反馈回复     * @param y
     * @return
     */
    public int insert(Fankuihuifu y);

    /**
     * 更新反馈回复     * @param y
     * @return
     */
    public int update(Fankuihuifu y);
}
