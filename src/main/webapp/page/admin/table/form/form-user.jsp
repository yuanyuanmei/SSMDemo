<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="card">
    <div class="card-header">
        Input
        <strong>Sizes</strong>
    </div>
    <form action="/sys/user" method="post" class="form-horizontal ">
        <div class="card-block">
                <div class="form-group row">
                    <input type="hidden" name="id" value="${item.id}"/>
                    <label class="col-sm-3 form-control-label" for="username">用户名</label>
                    <div class="col-sm-6">
                        <input type="text" readonly id="username" name="username" class="form-control" placeholder="username" value="${item.username}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 form-control-label" for="input-normal">昵称</label>
                    <div class="col-sm-6">
                        <input type="text" name="nickname" id="input-normal" class="form-control" placeholder="nickname" value="${item.nickname}">
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3 form-control-label" for="ccmonth">类型</label>
                    <div class="col-sm-6">
                        <select class="form-control" id="ccmonth" name="type">
                            <c:forEach items="${typeEnum}" var="opt">
                                <option value="${opt.key}" <c:if test="${item.type == opt.key}">selected</c:if> >${opt.value}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            <div>${errorMsg}</div>
        </div>

        <div class="card-footer">
            <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-dot-circle-o"></i> Submit</button>
            <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i> Reset</button>
        </div>
    </form>
</div>
</div>