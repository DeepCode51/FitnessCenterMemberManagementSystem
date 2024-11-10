<%@ page language="java" import="java.util.HashMap" pageEncoding="utf-8" %>
<%@ page import="dao.CommDAO" %>
<%@ page import="com.spring.entity.Shoucangjilu" %>
<%@ page import="dao.Query" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ include file="head.jsp" %>

<div style="padding: 10px">
    <div class="panel panel-default">
        <div class="panel-heading">
        <span class="module-name">
            我的收藏
        </span>
        </div>
        <div class="panel-body">
            <div class="list-table">
                <table width="100%" class="table table-list table-bordered table-hover">
                    <thead>
                    <tr>
                        <td width="25" >序号</td>
                        <td width="790" >标题</td>
                        <td width="180" >收藏时间</td>
                        <td width="100">操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="map">
                    <tr>
                        <td width="25">
                            ${map.id}
                        </td>
                        <td>
                            ${map.biaoti}
                        </td>
                        <td>${map.addtime}
                        </td>
                        <td>
                            <a href="shoucangjilu_delete.do?id=${map.id}" onclick="return confirm('真的要删除？')">删除</a>
                            <a href="${map.biao}detail.do?id=${map.xwid}" target="_blank">详细</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </div>
            ${page.info}
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>