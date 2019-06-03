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
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">编辑</button>
                <button type="button" class="btn btn-danger" onclick="location.href=''">删除</button>
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    Launch demo modal
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>