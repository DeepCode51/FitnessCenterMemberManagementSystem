<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>账号管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="admins_list.do"> 管理员账号管理 </a>
        </li>
        <li>
            <a target="main" href="admins_add.do"> 管理员账号添加 </a>
        </li>
        <li>
            <a target="main" href="mod.do"> 密码修改 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>公告信息管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="gonggaoxinxi_add.do"> 公告信息添加 </a>
        </li>
        <li>
            <a target="main" href="gonggaoxinxi_list.do"> 公告信息查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>客户管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="kehu_add.do"> 客户添加 </a>
        </li>
        <li>
            <a target="main" href="kehu_list.do"> 客户查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>会员卡管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="huiyuanka_list.do"> 会员卡查询 </a>
        </li>
    </ul>
</li>

<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>留言反馈管理</span>
    </a>
    <ul>
        <ul>
            <li>
                <a target="main" href="liuyanfankui_add.do"> 留言反馈添加 </a>
            </li>
            <li>
                <a target="main" href="liuyanfankui_list.do"> 留言反馈查询 </a>
            </li>
            <li>
                <a target="main" href="fankuihuifu_add.do"> 反馈回复添加 </a>
            </li>
            <li>
                <a target="main" href="fankuihuifu_list.do"> 反馈回复查询 </a>
            </li>

        </ul>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>统计报表管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="xiaofeixinxi_list.do"> 消费信息查询 </a>
        </li>
        <li>
            <a target="main" href="chongzhixinxi_list.do"> 充值信息查询 </a>
        </li>
    </ul>
</li>
