<%@include file="../common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<body class="app flex-row align-items-center">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="clearfix">
                <h1 class="float-left display-3 mr-2">500</h1>
                <h4 class="pt-1">${errorMsg}</h4>
                <p class="text-muted">页面有一点点小问题，请联系管理员，亲</p>
            </div>
            <div class="input-prepend input-group">
                    <span class="input-group-addon"><i class="fa fa-search"></i>
                    </span>
                <input id="prependedInput" class="form-control" size="16" type="text" placeholder="What are you looking for?">
                <span class="input-group-btn">
                        <button class="btn btn-info" type="button">Search</button>
                    </span>
            </div>
        </div>
    </div>
</div>


</body>

</html>