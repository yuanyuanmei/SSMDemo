<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card mx-2">
                <form action="/admin/register" method="post">
                    <div class="card-block p-2">
                        <h1>Register</h1>
                        <p class="text-muted">Create your account</p>
                        <div class="input-group mb-1">
                                <span class="input-group-addon"><i class="icon-user"></i>
                                </span>
                            <input type="text" name="account" class="form-control" placeholder="Username">
                        </div>

                        <div class="input-group mb-1">
                            <span class="input-group-addon">@</span>
                            <input type="text" name="email" class="form-control" placeholder="Email">
                        </div>

                        <div class="input-group mb-1">
                                <span class="input-group-addon"><i class="icon-lock"></i>
                                </span>
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>

                        <div class="input-group mb-2">
                                <span class="input-group-addon"><i class="icon-lock"></i>
                                </span>
                            <input type="password" class="form-control" placeholder="Repeat password">
                        </div>
                        <input type="hidden" value="1" name="type"/>
                        <button type="submit" class="btn btn-block btn-success">Create Account</button>
                        <div>${errorMsg}</div>
                    </div>
                </form>
                <div class="card-footer p-2">
                    <div class="row">
                        <div class="col-6">
                            <button class="btn btn-block btn-facebook" type="button" onclick="location.href='/admin/login'">
                                <span>login</span>
                            </button>
                        </div>
                        <div class="col-6">
                            <button class="btn btn-block btn-twitter" type="button">
                                <span>twitter</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
