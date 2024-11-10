package com.spring.service;

import com.spring.entity.Liuyanfankui;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface LiuyanfankuiService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Liuyanfankui> select();

    /**
     * 根据Liuyanfankui类搜索数据
     * @param y
     * @return
     */
    public List<Liuyanfankui> select(Liuyanfankui y);

    /**
     * 根据主键获取留言反馈一行数据
     * @param id
     * @return
     */
    public Liuyanfankui find(Object id);

    /**
     * 根据留言反馈获取留言反馈类条件查询一行数据
     * @param id
     * @return
     */
    public Liuyanfankui findEntity(Liuyanfankui id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Liuyanfankui> selectPage(Liuyanfankui obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Liuyanfankui> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入留言反馈     * @param y
     * @return
     */
    public int insert(Liuyanfankui y);

    /**
     * 更新留言反馈     * @param y
     * @return
     */
    public int update(Liuyanfankui y);
}
