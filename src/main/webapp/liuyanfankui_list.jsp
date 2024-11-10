<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page language="java" import="java.util.*" %>
<%@page import="com.spring.util.*" %>
<%@page import="com.jntoo.db.*" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="module-name"> 留言反馈 </span>
            <span>列表</span>
        </div>
        <div class="panel-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">
                    <!-- form 标签开始 -->

                    <div class="form-group">
                        <i class="glyphicon glyphicon-search"></i>
                    </div>

                    <div class="form-group">
                        状态

                        <select class="form-control class_zhuangtai5" data-value="${param.zhuangtai}" id="zhuangtai"
                                name="zhuangtai">
                            <option value="">请选择</option>
                            <option value="待回复">待回复</option>
                            <option value="已回复">已回复</option>
                        </select>
                        <script>
                            $(".class_zhuangtai5").val($(".class_zhuangtai5").attr("data-value"));
                        </script>
                    </div>
                    <select class="form-control" name="order" id="orderby">
                        <option value="id">按发布时间</option>
                    </select>
                    <select class="form-control" name="sort" id="sort">
                        <option value="desc">倒序</option>
                        <option value="asc">升序</option>
                    </select>
                    <script>
                        $("#orderby").val("${orderby}");
                        $("#sort").val("${sort}");
                    </script>
                    <button type="submit" class="btn btn-default">搜索</button>

                    <!--form标签结束-->
                </form>
            </div>

            <div class="list-table">
                <table width="100%" border="1" class="table table-list table-bordered table-hover">
                    <thead>
                    <tr align="center">
                        <th width="60" data-field="item">序号</th>
                        <th>留言内容</th>
                        <th>留言人</th>
                        <th>留言日期</th>
                        <th>状态</th>
                        <th width="220" data-field="handler">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"
                    ><c:set var="i" value="${i+1}"/><c:set var="map" value="${map}" scope="request"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center">
                                <label> ${i} </label>
                            </td>
                            <td>${map.liuyanneirong}</td>
                            <td>${map.liuyanren}</td>
                            <td>${Info.subStr(map.liuyanriqi , 19 , "")}</td>
                            <td>${map.zhuangtai}</td>
                            <td align="center">


                                <c:choose>
                                    <c:when test="${'待回复' == map.zhuangtai }">

                                        <a href="fankuihuifu_add.do?id=${map.id}">回复</a>
                                    </c:when></c:choose>




                                <a href="liuyanfankui_detail.do?id=${map.id}">详情</a>

                                <a href="liuyanfankui_updt.do?id=${map.id}">编辑</a>

                                <a href="liuyanfankui_delete.do?id=${map.id}" onclick="return confirm('确定要删除？')">删除</a>
                                <!--qiatnalijne-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <%@include file="/page.jsp" %>

        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

