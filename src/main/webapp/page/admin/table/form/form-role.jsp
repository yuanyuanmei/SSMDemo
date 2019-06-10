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
                <label class="col-sm-3 form-control-label" for="input-normal">描述</label>
                <div class="col-sm-6">
                    <input type="text" id="input-normal" name="desc" class="form-control" placeholder="desc" value="${item.desc}">
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
