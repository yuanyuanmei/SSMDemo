<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th>ID</th>
        <th>菜单名称</th>
        <th>类型</th>
        <th>路径</th>
        <th>授权标识</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageList.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.type}</td>
            <td>${item.url}</td>
            <td>${item.permission}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>