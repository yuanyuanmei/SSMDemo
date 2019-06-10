<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="card">
    <div class="card-header">
        Input
        <strong>Sizes</strong>
    </div>
    <div class="card-block">
        <form action="" method="post" class="form-horizontal " name="form1">
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="input-small">名称</label>
                <div class="col-sm-6">
                    <input type="text" id="input-small" name="name" class="form-control" placeholder="name" value="${item.name}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="input-normal">类型</label>
                <div class="col-sm-6">
                    <input type="text" id="input-normal" name="input-normal" class="form-control" placeholder="type">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="parent_id">父级标签</label>
                <div class="col-sm-6">
                    <input type="text" id="parent_id" name="parent_id" class="form-control" placeholder="parent_id">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="url">路径</label>
                <div class="col-sm-6">
                    <input type="text" id="url" name="url" class="form-control" placeholder="url">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="permission">权限</label>
                <div class="col-sm-6">
                    <input type="text" id="permission" name="permission" class="form-control" placeholder="permission">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="memo">备注</label>
                <div class="col-sm-6">
                    <input type="text" id="memo" name="memo" class="form-control" placeholder="memo">
                </div>
            </div>
        </form>
        <div class="msg"></div>
    </div>
    <div class="card-footer">
        <button type="button" class="btn btn-sm btn-primary" onclick="subForm()"><i class="fa fa-dot-circle-o"></i> Submit</button>
        <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i> Reset</button>
    </div>
</div>
</div>
