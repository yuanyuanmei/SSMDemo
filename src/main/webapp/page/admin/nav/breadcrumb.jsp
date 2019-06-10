<!-- Breadcrumb -->
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<ol class="breadcrumb">
    <c:if test="${url == '/admin/index' || url == null }"><li class="breadcrumb-item"><a href="#">首页</a></li></c:if>
    <c:forEach items="${breadCrumbs}" var="item" varStatus="i">
        <c:choose>
            <c:when test="${i.last}">
                <li class="breadcrumb-item"><a href="${item.url}">${item.name}</a></li>
            </c:when>
            <c:otherwise>
                <li class="breadcrumb-item noactive"><a href="${item.url}">${item.name}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <!-- Breadcrumb Menu-->
    <li class="breadcrumb-menu hidden-md-down">
        <div class="btn-group" role="group" aria-label="Button group with nested dropdown">


            <a class="btn btn-secondary" href="#"><i class="icon-speech"></i></a>
            <a class="btn btn-secondary" href=".."><i class="icon-graph"></i> &nbsp;Dashboard</a>
            <a class="btn btn-secondary" href="#"><i class="icon-settings"></i> &nbsp;Settings</a>
        </div>
    </li>
</ol>

<style>
    .noactive a{
        color:gray;
    }
</style>
