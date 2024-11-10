package com.spring.service;

import com.spring.entity.Huiyuanka;
import java.util.*;
import tk.mybatis.mapper.entity.Example;

public interface HuiyuankaService {
    /**
     * 获取所有数据
     * @return
     */
    public List<Huiyuanka> select();

    /**
     * 根据Huiyuanka类搜索数据
     * @param y
     * @return
     */
    public List<Huiyuanka> select(Huiyuanka y);

    /**
     * 根据主键获取会员卡一行数据
     * @param id
     * @return
     */
    public Huiyuanka find(Object id);

    /**
     * 根据会员卡获取会员卡类条件查询一行数据
     * @param id
     * @return
     */
    public Huiyuanka findEntity(Huiyuanka id);

    /**
     * 搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Huiyuanka> selectPage(Huiyuanka obj, int page, int pageSize);

    /**
     * 根据Example搜索分页
     * @param obj
     * @param page
     * @param pageSize
     * @return
     */
    public List<Huiyuanka> selectPageExample(Example obj, int page, int pageSize);

    /**
     * 根据主键删除一行数据
     * @param id
     * @return
     */
    public int delete(Object id);

    /**
     * 插入会员卡     * @param y
     * @return
     */
    public int insert(Huiyuanka y);

    /**
     * 更新会员卡     * @param y
     * @return
     */
    public int update(Huiyuanka y);
}
