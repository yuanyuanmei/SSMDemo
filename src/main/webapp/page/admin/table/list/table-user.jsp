<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<table class="table table-bordered table-striped table-condensed">
    <thead>
    <tr>
        <th style="width:15%">ID</th>
        <th style="width:35%">用户名</th>
        <th style="width:30%">昵称</th>
        <th style="width:20%">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${pageList.list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.nickname}</td>
            <td>
                <button type="button" class="btn btn-success"onclick="location.href='/sys/user?opt=save'">编辑</button>
                <button type="button" class="btn btn-danger" onclick="location.href=''">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>