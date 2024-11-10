<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="pages">
    <span class="a1">总计：${page.totalRows}行数据，${page.totalPages}页，每页${page.pageSize}行</span>

    <c:choose>
        <c:when test="${page.IsPrev()}">
            <a href="${page.prevPage}">上一页</a>
        </c:when>
        <c:otherwise>
            <a href="javascript:;" class="disabled">上一页</a>
        </c:otherwise>
    </c:choose>

    <c:forEach items="${page.pageNums}" var="p">
        <c:choose>
            <c:when test="${page.currentPage == p.page}">
                <a href="javascript:;" class="active">${p.page}</a>
            </c:when>
            <c:otherwise>
                <a href="${p.url}">${p.page}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:choose>
        <c:when test="${page.IsNext()}">
            <a href="${page.nextPage}">下一页</a>
        </c:when>
        <c:otherwise>
            <a href="javascript:;" class="disabled">下一页</a>
        </c:otherwise>
    </c:choose>
</div>
