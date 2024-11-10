<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>会员卡管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="huiyuanka_list_zhanghao.do"> 我的会员卡 </a>
        </li>
        <li>
            <a target="main" href="chongzhixinxi_list_zhanghao.do"> 充值信息查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>消费信息管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="xiaofeixinxi_list_zhanghao.do"> 我的消费记录 </a>
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
            <a target="main" href="gonggaoxinxi_list.do"> 公告信息查询 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>留言反馈管理</span>
    </a>
    <ul>
        <li>
            <a target="main" href="liuyanfankui_list.do"> 留言反馈查询 </a>
        </li>
        <li>
            <a target="main" href="liuyanfankui_add.do"> 留言反馈添加 </a>
        </li>
        <li>
            <a target="main" href="fankuihuifu_list.do"> 反馈回复查询 </a>
        </li>
        <li>
            <a target="main" href="fankuihuifu_add.do"> 反馈回复添加 </a>
        </li>
    </ul>
</li>
<li>
    <a href="javascript:;" class="nav-top-item">
        <i class="icon ti-home"></i>
        <span>个人中心</span>
    </a>
    <ul>
        <li>
            <a target="main" href="kehu_updtself.do"> 修改个人资料 </a>
        </li>
        <li>
            <a target="main" href="mod.do"> 修改密码 </a>
        </li>
    </ul>
</li>
