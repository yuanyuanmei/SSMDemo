<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="sidebar">
    <nav class="sidebar-nav">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="/admin/index"><i class="icon-speedometer"></i> 首页</a>
            </li>
            <c:forEach items="${sessionScope.nav}" var="item">
                <li class="nav-title">
                        ${item.name}
                </li>
                <c:forEach items="${item.childList}" var="child">
                    <li class="nav-item nav-dropdown">
                        <a class="nav-link" href="..${child.url}"><i class="icon-puzzle"></i> ${child.name}</a>
                    </li>
                </c:forEach>
            </c:forEach>
        </ul>
    </nav>
</div>