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
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageList.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.typeName}</td>
            <td>${item.url}</td>
            <td>${item.permission}</td>
            <td>
                <button type="button" class="btn btn-success"onclick="location.href='/sys/menu?opt=save'">编辑</button>
                <button type="button" class="btn btn-danger" onclick="location.href=''">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>