<%@ page language="java" pageEncoding="UTF-8" %>
 <%@ page language="java" import="java.util.*" %>
 <%@page import="com.spring.util.*" %>
 <%@page import="com.jntoo.db.*" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">公告信息详情</div>
        <div class="panel-body">
            <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">公告编号：</div>
                    <div class="detail-content">${map.gonggaobianhao}</div>
                </div>
                <div class="detail detail-longtext">
                    <div class="detail-title">公告标题：</div>
                    <div class="detail-content">${map.gonggaobiaoti}</div>
                </div>
                <div class="detail detail-textarea">
                    <div class="detail-title">公告描述：</div>
                    <div class="detail-content">${map.gonggaomiaoshu}</div>
                </div>
                <div class="detail detail-autotime">
                    <div class="detail-title">发布日期：</div>
                    <div class="detail-content">${map.faburiqi}</div>
                </div>
                <div class="detail detail-textuser">
                    <div class="detail-title">发布人：</div>
                    <div class="detail-content">${map.faburen}</div>
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

