
<div class="sidebar">
    <nav class="sidebar-nav">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#"><i class="icon-speedometer"></i> Dashboard <span class="badge badge-info">NEW</span></a>
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