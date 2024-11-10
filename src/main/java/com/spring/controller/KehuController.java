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
 * 客户 */
@Controller
public class KehuController extends BaseController {

    @Autowired
    private KehuMapper dao;

    @Autowired
    private KehuService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/kehu_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Kehu.class); //  创建一个扩展搜索类
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
        List<Kehu> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "kehu_list"; // 使用视图文件：WebRoot\kehu_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        if (!Request.get("zhanghao").equals("")) {
            where += " AND zhanghao LIKE '%" + Request.get("zhanghao") + "%' ";
        }
        if (!Request.get("xingming").equals("")) {
            where += " AND xingming LIKE '%" + Request.get("xingming") + "%' ";
        }
        if (!Request.get("xingbie").equals("")) {
            where += " AND xingbie ='" + Request.get("xingbie") + "' ";
        }
        return where;
    }

    @RequestMapping("/kehu_add")
    public String add() {
        return "kehu_add";
    }

    @RequestMapping("/kehu_updt")
    public String updt() {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Kehu mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "kehu_updt";
    }

    /**
     *  更新个人资料
     */
    @RequestMapping("/kehu_updtself")
    public String updtself() {
        // 更新个人资料
        int id = (int) request.getSession().getAttribute("id");
        Kehu mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 1);

        return "kehu_updtself";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/kehuinsert")
    public String insert() {
        String tmp = "";
        Kehu post = new Kehu(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setZhanghao(Request.get("zhanghao"));

        post.setMima(Request.get("mima"));

        post.setXingming(Request.get("xingming"));

        post.setXingbie(Request.get("xingbie"));

        post.setLianxidianhua(Request.get("lianxidianhua"));

        post.setYouxiang(Request.get("youxiang"));

        post.setBeizhu(Request.get("beizhu"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/kehuupdate")
    public String update() {
        // 创建实体类
        Kehu post = new Kehu();
        // 将前台表单数据填充到实体类
        if (!Request.get("zhanghao").equals("")) post.setZhanghao(Request.get("zhanghao"));
        if (!Request.get("mima").equals("")) post.setMima(Request.get("mima"));
        if (!Request.get("xingming").equals("")) post.setXingming(Request.get("xingming"));
        if (!Request.get("xingbie").equals("")) post.setXingbie(Request.get("xingbie"));
        if (!Request.get("lianxidianhua").equals("")) post.setLianxidianhua(Request.get("lianxidianhua"));
        if (!Request.get("youxiang").equals("")) post.setYouxiang(Request.get("youxiang"));
        if (!Request.get("beizhu").equals("")) post.setBeizhu(Request.get("beizhu"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        if (Request.getInt("updtself") == 1) {
            return showSuccess("保存成功", "kehu_updtself.do");
        }
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/kehu_detail")
    public String detail() {
        int id = Request.getInt("id");
        Kehu map = service.find(id); // 根据前台url 参数中的id获取行数据
        request.setAttribute("map", map); // 把数据写到前台
        return "kehu_detail"; // 详情页面：WebRoot\kehu_detail.jsp
    }

    /**
     *  删除
     */
    @RequestMapping("/kehu_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("kehu").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
