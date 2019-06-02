<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

<%@include file="common/adminHeader.jsp"%>

<div class="app-body">

    <%@include file="nav/nav.jsp"%>

    <!-- Main content -->
    <main class="main">

        <%@include file="nav/breadcrumb.jsp"%>

        <c:if test="${sysType != null}">
            <%@include file="table/index.jsp"%>
        </c:if>

        <!-- /.conainer-fluid -->
    </main>
</div>
<%@include file="common/adminFooter.jsp"%>
<%@include file="../common/footer.jsp"%>
