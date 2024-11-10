<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">充值信息详情</div>
        <div class="panel-body">
            <div class="admin-detail clearfix">
                <div class="detail detail-readmodule">
                    <div class="detail-title">会员卡id：</div>
                    <div class="detail-content">${map.huiyuankaid}</div>
                </div>
                <div class="detail detail-textuser">
                    <div class="detail-title">账号：</div>
                    <div class="detail-content">${map.zhanghao}</div>
                </div>
                <div class="detail detail-textuser">
                    <div class="detail-title">充值人：</div>
                    <div class="detail-content">${map.chongzhiren}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">姓名：</div>
                    <div class="detail-content">${map.xingming}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">会员卡号：</div>
                    <div class="detail-content">${map.huiyuankahao}</div>
                </div>
                <div class="detail detail-money">
                    <div class="detail-title">充值金额：</div>
                    <div class="detail-content">${map.chongzhijine}</div>
                </div>
                <div class="detail detail-autotime">
                    <div class="detail-title">充值日期：</div>
                    <div class="detail-content">${map.chongzhiriqi}</div>
                </div>
            </div>

            <div class="button-list mt10">
                <div class="">
                    <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                    <button type="button" class="btn btn-default" onclick="window.print()">打印本页</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

