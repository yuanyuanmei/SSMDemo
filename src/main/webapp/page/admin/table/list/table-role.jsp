<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th style="width:20%">ID</th>
        <th style="width:30%">角色名称</th>
        <th style="width:30%">描述</th>
        <th style="width:20%">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageList.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.desc}</td>
            <td>
                <button type="button" class="btn btn-success"onclick="location.href='/sys/role?opt=save'">编辑</button>
                <button type="button" class="btn btn-danger" onclick="location.href=''">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>