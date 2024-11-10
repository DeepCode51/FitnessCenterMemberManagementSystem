package com.spring.controller;

import com.jntoo.db.*;
import com.jntoo.db.utils.*;
import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

/**
 * 消费信息 */
@Controller
public class XiaofeixinxiController extends BaseController {

    @Autowired
    private XiaofeixinxiMapper dao;

    @Autowired
    private XiaofeixinxiService service;

    @Autowired
    private HuiyuankaService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/xiaofeixinxi_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Xiaofeixinxi.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        String where = " 1=1 "; // 创建初始条件为：1=1
        where += getWhere(); // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where); // 将条件写进上面的扩展条件类中
        if (sort.equals("desc")) { // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc(); // 把sql 语句设置成倒序
        } else {
            example.orderBy(order).asc(); // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1, page); // 取两个数的最大值，防止page 小于1
        List<Xiaofeixinxi> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "xiaofeixinxi_list"; // 使用视图文件：WebRoot\xiaofeixinxi_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 判断URL 参数huiyuankaid是否大于0
        if (Request.getInt("huiyuankaid") > 0) {
            // 大于0 则写入条件
            where += " AND huiyuankaid='" + Request.getInt("huiyuankaid") + "' ";
        }
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        if (!Request.get("zhanghao").equals("")) {
            where += " AND zhanghao LIKE '%" + Request.get("zhanghao") + "%' ";
        }
        if (!Request.get("xingming").equals("")) {
            where += " AND xingming LIKE '%" + Request.get("xingming") + "%' ";
        }
        if (!Request.get("huiyuankahao").equals("")) {
            where += " AND huiyuankahao LIKE '%" + Request.get("huiyuankahao") + "%' ";
        }
        if (!Request.get("xiaofeixiangmu").equals("")) {
            where += " AND xiaofeixiangmu LIKE '%" + Request.get("xiaofeixiangmu") + "%' ";
        }
        return where;
    }

    /**
     * 账号列表
     */
    @RequestMapping("/xiaofeixinxi_list_zhanghao")
    public String listzhanghao() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Xiaofeixinxi.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：账号=当前登录用户
        String where = " zhanghao='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Xiaofeixinxi> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "xiaofeixinxi_list_zhanghao";
    }

    @RequestMapping("/xiaofeixinxi_add")
    public String add() {
        int id = Request.getInt("id"); // 根据id 获取 会员卡模块中的数据
        Huiyuanka readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        request.setAttribute("readMap", readMap);
        return "xiaofeixinxi_add";
    }

    @RequestMapping("/xiaofeixinxi_updt")
    public String updt() {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Xiaofeixinxi mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "xiaofeixinxi_updt";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/xiaofeixinxiinsert")
    public String insert() {
        String tmp = "";
        Xiaofeixinxi post = new Xiaofeixinxi(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setHuiyuankaid(Request.getInt("huiyuankaid"));

        post.setZhanghao(Request.get("zhanghao"));

        post.setXingming(Request.get("xingming"));

        post.setHuiyuankahao(Request.get("huiyuankahao"));

        post.setXiaofeijine(Request.getDouble("xiaofeijine"));

        post.setXiaofeixiangmu(Request.get("xiaofeixiangmu"));

        post.setXiaofeiriqi(Request.get("xiaofeiriqi"));

        post.setBeizhu(Request.get("beizhu"));

        post.setHuiyuankaid(Request.getInt("huiyuankaid"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update huiyuanka set kayue=kayue-'" + request.getParameter("xiaofeijine") + "' where id='" + request.getParameter("huiyuankaid") + "'");

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/xiaofeixinxiupdate")
    public String update() {
        // 创建实体类
        Xiaofeixinxi post = new Xiaofeixinxi();
        // 将前台表单数据填充到实体类
        if (!Request.get("huiyuankaid").equals("")) post.setHuiyuankaid(Request.getInt("huiyuankaid"));
        if (!Request.get("zhanghao").equals("")) post.setZhanghao(Request.get("zhanghao"));
        if (!Request.get("xingming").equals("")) post.setXingming(Request.get("xingming"));
        if (!Request.get("huiyuankahao").equals("")) post.setHuiyuankahao(Request.get("huiyuankahao"));
        if (!Request.get("xiaofeijine").equals("")) post.setXiaofeijine(Request.getDouble("xiaofeijine"));
        if (!Request.get("xiaofeixiangmu").equals("")) post.setXiaofeixiangmu(Request.get("xiaofeixiangmu"));
        if (!Request.get("xiaofeiriqi").equals("")) post.setXiaofeiriqi(Request.get("xiaofeiriqi"));
        if (!Request.get("beizhu").equals("")) post.setBeizhu(Request.get("beizhu"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/xiaofeixinxi_detail")
    public String detail() {
        int id = Request.getInt("id");
        Xiaofeixinxi map = service.find(id); // 根据前台url 参数中的id获取行数据
        request.setAttribute("map", map); // 把数据写到前台
        return "xiaofeixinxi_detail"; // 详情页面：WebRoot\xiaofeixinxi_detail.jsp
    }

    /**
     *  删除
     */
    @RequestMapping("/xiaofeixinxi_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("xiaofeixinxi").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
