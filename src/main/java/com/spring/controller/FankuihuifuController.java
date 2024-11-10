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
 * 反馈回复 */
@Controller
public class FankuihuifuController extends BaseController {

    @Autowired
    private FankuihuifuMapper dao;

    @Autowired
    private FankuihuifuService service;

    @Autowired
    private LiuyanfankuiService serviceRead;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/fankuihuifu_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Fankuihuifu.class); //  创建一个扩展搜索类
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
        List<Fankuihuifu> list = service.selectPageExample(example, page, 12); // 获取当前页的行数
        // 将列表写给界面使用
        assign("list", list);
        assign("orderby", order); // 把当前排序结果写进前台
        assign("sort", sort); // 把当前排序结果写进前台
        assign("where", where); // 把当前条件写给前台
        return "fankuihuifu_list"; // 使用视图文件：WebRoot\fankuihuifu_list.jsp
    }

    /**
     *  获取前台搜索框填写的内容,并组成where 语句
     */
    public String getWhere() {
        String where = " ";
        // 判断URL 参数liuyanfankuiid是否大于0
        if (Request.getInt("liuyanfankuiid") > 0) {
            // 大于0 则写入条件
            where += " AND liuyanfankuiid='" + Request.getInt("liuyanfankuiid") + "' ";
        }
        // 以下是判断搜索框中是否有输入内容，判断是否前台是否有填写相关条件，符合则写入sql搜索语句
        return where;
    }

    /**
     * 留言人列表
     */
    @RequestMapping("/fankuihuifu_list_liuyanren")
    public String listliuyanren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Fankuihuifu.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：留言人=当前登录用户
        String where = " liuyanren='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Fankuihuifu> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "fankuihuifu_list_liuyanren";
    }

    /**
     * 回复人列表
     */
    @RequestMapping("/fankuihuifu_list_huifuren")
    public String listhuifuren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc

        Example example = new Example(Fankuihuifu.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria(); // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：回复人=当前登录用户
        String where = " huifuren='" + session.getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where); // 将条件写入
        if (sort.equals("desc")) { // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Fankuihuifu> list = service.selectPageExample(example, page, 12);

        request.setAttribute("list", list);
        assign("orderby", order);
        assign("sort", sort);
        assign("where", where);
        return "fankuihuifu_list_huifuren";
    }

    @RequestMapping("/fankuihuifu_add")
    public String add() {
        int id = Request.getInt("id"); // 根据id 获取 留言反馈模块中的数据
        Liuyanfankui readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        request.setAttribute("readMap", readMap);
        return "fankuihuifu_add";
    }

    @RequestMapping("/fankuihuifu_updt")
    public String updt() {
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Fankuihuifu mmm = service.find(id);
        request.setAttribute("mmm", mmm);
        request.setAttribute("updtself", 0);
        return "fankuihuifu_updt";
    }

    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/fankuihuifuinsert")
    public String insert() {
        String tmp = "";
        Fankuihuifu post = new Fankuihuifu(); // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setLiuyanfankuiid(Request.getInt("liuyanfankuiid"));

        post.setLiuyanren(Request.get("liuyanren"));

        post.setHuifuneirong(Request.get("huifuneirong"));

        post.setHuifuren(Request.get("huifuren"));

        post.setHuifuriqi(Info.getDateStr());

        post.setLiuyanfankuiid(Request.getInt("liuyanfankuiid"));

        service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update liuyanfankui set zhuangtai='已回复' where id='" + request.getParameter("liuyanfankuiid") + "'");

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 更新内容
     * @return
     */
    @RequestMapping("/fankuihuifuupdate")
    public String update() {
        // 创建实体类
        Fankuihuifu post = new Fankuihuifu();
        // 将前台表单数据填充到实体类
        if (!Request.get("liuyanfankuiid").equals("")) post.setLiuyanfankuiid(Request.getInt("liuyanfankuiid"));
        if (!Request.get("liuyanren").equals("")) post.setLiuyanren(Request.get("liuyanren"));
        if (!Request.get("huifuneirong").equals("")) post.setHuifuneirong(Request.get("huifuneirong"));
        if (!Request.get("huifuren").equals("")) post.setHuifuren(Request.get("huifuren"));
        if (!Request.get("huifuriqi").equals("")) post.setHuifuriqi(Request.get("huifuriqi"));

        post.setId(Request.getInt("id"));
        service.update(post); // 更新数据
        int charuid = post.getId().intValue();
        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     *  后台详情
     */
    @RequestMapping("/fankuihuifu_detail")
    public String detail() {
        int id = Request.getInt("id");
        Fankuihuifu map = service.find(id); // 根据前台url 参数中的id获取行数据
        request.setAttribute("map", map); // 把数据写到前台
        return "fankuihuifu_detail"; // 详情页面：WebRoot\fankuihuifu_detail.jsp
    }

    /**
     *  删除
     */
    @RequestMapping("/fankuihuifu_delete")
    public String delete() {
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id"); // 根据id 删除某行数据
        Map map = Query.make("fankuihuifu").find(id);

        service.delete(id); // 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer")); //弹出删除成功，并跳回上一页
    }
}
