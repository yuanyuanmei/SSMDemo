<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<body class="app flex-row align-items-center">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card-group mb-0">
                <div class="card p-2">
                    <form action="/user/login" method="post" name="form1">
                        <div class="card-block">
                            <h1>登录</h1>
                            <p class="text-muted">登录你的账号</p>
                            <div class="input-group mb-1">
                                    <span class="input-group-addon"><i class="icon-user"></i>
                                    </span>
                                <input type="text" class="form-control" placeholder="Username" name="account">
                            </div>
                            <div class="input-group mb-2">
                                    <span class="input-group-addon"><i class="icon-lock"></i>
                                    </span>
                                <input type="password" class="form-control" placeholder="Password" name="password">
                                <input type="hidden" value="1" name="type"/>
                            </div>
                            <div class="msg"></div>
                            <div class="row">
                                <div class="col-6">
                                    <button type="button" class="btn btn-primary px-2" onclick="login()">Login</button>
                                </div>
                                <div class="col-6 text-right">
                                    <button type="button" class="btn btn-link px-0">忘记密码?</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card card-inverse card-primary py-3 hidden-md-down" style="width:44%">
                    <div class="card-block text-center">
                        <div>
                            <h2>注册</h2>
                            <p>注册...........</p>
                            <button type="button" class="btn btn-primary active mt-1" onclick='location.href="/user/register"'>Register Now!</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function login(){
        var url = "/user/login";
        var data = $("*[name=form1]").serialize();
        $.post(url,data,function(res){
            if(res.code == 204){
                $(".msg").text(res.msg);
            }else if(res.code == 200){
                alert(res.msg);
                window.setTimeout(function(){
                    location.href = "/admin/index";
                },"2000");
            }
        },"json");
    }

</script>

<%@include file="../common/footer.jsp"%>



