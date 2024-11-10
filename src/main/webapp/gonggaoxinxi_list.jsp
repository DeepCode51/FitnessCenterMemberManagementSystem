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
            <span class="module-name"> 公告信息 </span>
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
                        公告编号

                        <input type="text" class="form-control" style="" name="gonggaobianhao"
                               value="${param.gonggaobianhao}"/>
                    </div>
                    <div class="form-group">
                        公告标题

                        <input type="text" class="form-control" style="" name="gonggaobiaoti"
                               value="${param.gonggaobiaoti}"/>
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
                        <th>公告编号</th>
                        <th>公告标题</th>

                        <th>发布日期</th>
                        <th>发布人</th>
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
                            <td>${map.gonggaobianhao}</td>
                            <td>${map.gonggaobiaoti}</td>

                            <td>${Info.subStr(map.faburiqi , 19 , "")}</td>
                            <td>${map.faburen}</td>
                            <td align="center">
                                <a href="gonggaoxinxi_detail.do?id=${map.id}">详情</a>



                                <c:choose>
                                    <c:when test="${'管理员' == sessionScope.cx }">

                                        <a href="gonggaoxinxi_updt.do?id=${map.id}">编辑</a>

                                        <a href="gonggaoxinxi_delete.do?id=${map.id}" onclick="return confirm('确定要删除？')">删除</a>
                                    </c:when></c:choose>


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

