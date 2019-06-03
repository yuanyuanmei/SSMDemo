<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th>ID</th>
        <th>角色名称</th>
        <th>描述</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageList.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.desc}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>