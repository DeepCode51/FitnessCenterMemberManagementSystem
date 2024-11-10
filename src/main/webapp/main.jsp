<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
﻿<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>健身中心会员管理系统后台管理系统</title>

    <!-- begin::global styles -->
    <link rel="stylesheet" href="assets/vendors/bundle.css" type="text/css">
    <!-- end::global styles -->

    <!-- begin::custom styles -->
    <link rel="stylesheet" href="assets/css/app.css" type="text/css">
    <!-- end::custom styles -->

</head>
<body>

<!-- begin::page loader-->
<div class="page-loader">
    <div class="spinner-border"></div>
    <span>Loading ...</span>
</div>
<!-- end::page loader -->

<!-- begin::side menu -->
<div class="side-menu">
    <div class='side-menu-body'>
        <ul>
            <li class="side-menu-divider">Navigation</li>
            <c:choose>
                <c:when test="${'管理员' == sessionScope.cx }">

                    <%@ include file="left_guanliyuan.jsp" %>
                </c:when></c:choose>
            <c:choose>
                <c:when test="${'客户' == sessionScope.cx }">

                    <%@ include file="left_kehu.jsp" %>
                </c:when></c:choose>

        </ul>
    </div>
</div>
<!-- end::side menu -->

<!-- begin::navbar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="header-logo">
            <a href="#">
                <img src="assets/img/light-logo.png" alt="">
                <span class="logo-text d-none d-lg-block">健身中心会员管理系统</span>
            </a>
        </div>
        <div class="header-body">
            <form class="search">
                <div class="input-group">
                    <input disabled type="text" class="form-control" placeholder=""
                           aria-label="Recipient's username"
                           aria-describedby="button-addon2">
                    <!--<div class="input-group-append">
                        <button class="btn" type="button" id="button-addon2">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>-->
                </div>
            </form>
            <ul class="navbar-nav">

                <!-- 消息通知，不要就删除 -->

                <!-- 消息通知结束，不要就删除 -->
                <li class="nav-item">
                    <a href="sy.do" target="main" class="nav-link nav-link-notify">后台主页</a>
                </li>
                <li class="nav-item">
                    <a href="javascript:;" class="nav-link">
                        ${sessionScope.username}，${sessionScope.cx}
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a href="#" data-toggle="dropdown">
                        <figure class="avatar avatar-sm avatar-state-success">
                            <c:choose>
                                <c:when test="${sessionScope.touxiang != null && sessionScope.touxiang !=  '' }">

                                    <img src="${sessionScope.touxiang}" class="rounded-circle" alt="User Image">
                                </c:when><c:otherwise>
                                <img class="rounded-circle" src="assets/img/avatar.jpg" alt="...">
                            </c:otherwise></c:choose>
                        </figure>
                        <i class="fa fa-angle-down"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <!--<a href="profile.html" class="dropdown-item">Profile</a>
                        <a href="#" data-sidebar-target="#settings" class="sidebar-open dropdown-item">Settings</a>-->
                        <div class="dropdown-divider"></div>
                        <a href="logout.do" onclick="return confirm('确定退出系统？')"
                           class="text-danger dropdown-item">退出登录</a>
                    </div>
                </li>

                <li class="nav-item d-lg-none d-sm-block">
                    <a href="javascript:;" class="nav-link side-menu-open">
                        <i class="ti-menu"></i>
                    </a>
                </li>

            </ul>
        </div>

    </div>
</nav>
<!-- end::navbar -->

<!-- begin::main content -->
<main class="main-content">
    <iframe name="main" class="cke_wysiwyg_frame" src="sy.do"></iframe>
</main>
<!-- end::main content -->

<!-- begin::global scripts -->
<script src="assets/vendors/bundle.js"></script>
<!-- end::global scripts -->

<!-- begin::custom scripts -->
<!--<script src="assets/js/custom.js"></script>-->
<script src="assets/js/app.js"></script>
<!-- end::custom scripts -->

</body>
</html>
