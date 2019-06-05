<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="card">
    <div class="card-header">
        Input
        <strong>Sizes</strong>
    </div>
    <div class="card-block">
        <form action="" method="post" class="form-horizontal ">
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="input-small">Small Input</label>
                <div class="col-sm-6">
                    <input type="text" id="input-small" name="input-small" class="form-control form-control-sm" placeholder=".form-control-sm">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="input-normal">Normal Input</label>
                <div class="col-sm-6">
                    <input type="text" id="input-normal" name="input-normal" class="form-control" placeholder="Normal">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-3 form-control-label" for="input-large">Large Input</label>
                <div class="col-sm-6">
                    <input type="text" id="input-large" name="input-large" class="form-control form-control-lg" placeholder=".form-control-lg">
                </div>
            </div>
        </form>
    </div>
    <div class="card-footer">
        <button type="submit" class="btn btn-sm btn-primary"><i class="fa fa-dot-circle-o"></i> Submit</button>
        <button type="reset" class="btn btn-sm btn-danger"><i class="fa fa-ban"></i> Reset</button>
    </div>
</div>
</div>