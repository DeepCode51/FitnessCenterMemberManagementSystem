<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 ﻿<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>健身中心会员管理系统-后台登录</title>

        <!-- begin::global styles -->
        <link rel="stylesheet" href="assets/vendors/bundle.css" type="text/css" />
        <!-- end::global styles -->

        <!-- begin::custom styles -->
        <link rel="stylesheet" href="assets/css/app.css" type="text/css" />
        <!-- end::custom styles -->
    </head>
    <body class="bg-white h-100-vh p-t-0">
        <!-- begin::page loader-->
        <div class="page-loader">
            <div class="spinner-border"></div>
            <span>Loading ...</span>
        </div>
        <!-- end::page loader -->

        <div class="p-b-50 d-block d-lg-none"></div>

        <div class="container h-100-vh">
            <div class="row align-items-md-center h-100-vh">
                <div class="col-lg-6 d-none d-lg-block">
                    <img class="img-fluid" src="assets/img/login.png" alt="..." />
                </div>
                <div class="col-lg-4 offset-lg-1">
                    <div class="d-flex align-items-center m-b-20">
                        <img src="assets/img/dark-logo.png" class="m-r-15" width="40" alt="" />
                        <h3 class="m-0">健身中心会员管理系统</h3>
                    </div>
                    <p>输入账号密码，登录系统.</p>
                    <form action="authAdminLogin.do?ac=adminlogin&a=a" id="loginForm" name="loginForm" method="post" onsubmit="return submitForm()">
                        <div class="form-group mb-4">
                            <input type="text" name="username" class="form-control form-control-lg" id="username" autofocus placeholder="账号" />
                        </div>
                        <div class="form-group mb-4">
                            <input type="password" name="pwd" class="form-control form-control-lg" id="password" placeholder="密码" />
                        </div>
                        <div class="form-group mb-4">
                            <div class="input-group">
                                <input type="text" name="pagerandom" class="form-control form-control-lg" id="pagerandom" placeholder="验证码" />
                                <span class="input-group-append">
                                    <img src="captcha.do" style="min-width: 60px; min-height: 30px" onClick="this.src='captcha.do?time='+new Date().getTime();" alt="点击刷新" />
                                </span>
                            </div>
                        </div>
                        <div class="form-group mb-4">
                            <select id="sys" name="cx" class="form-control form-control-lg">
                                <option value="管理员">管理员</option>
                                <option value="客户">客户</option>
                            </select>
                        </div>

                        <button class="btn btn-primary btn-lg btn-block btn-uppercase mb-4">登录系统</button>

                        <div class="text-center">版权所有：健身中心会员管理系统</div>
                    </form>
                </div>
            </div>
        </div>

        <!-- begin::global scripts -->
        <script src="assets/vendors/bundle.js"></script>
        <!-- end::global scripts -->

        <!-- begin::custom scripts -->
        <script src="assets/js/app.js"></script>
        <!-- end::custom scripts -->

        <script>
            function submitForm() {
                var frm = $("#loginForm");
                var form = $(frm);
                var input;
                input = form.find("#username");
                if (input.val() == "") {
                    alert("请填写账号");
                    return false;
                }
                input = form.find("#password");
                if (input.val() == "") {
                    alert("请填写密码");
                    return false;
                }
                input = form.find("#pagerandom");
                if (input.val() == "") {
                    alert("请填写验证码");
                    return false;
                }
                return true;
            }
        </script>
    </body>
</html>
