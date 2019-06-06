<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <div class="card">
            <c:if test="${opt == 'list'}">
                <div class="card-header">
                    <i class="fa fa-align-justify"></i> 列表
                </div>
                <div class="card-block">
                    <button type="button" class="btn btn-success"onclick="location.href='/sys/user?opt=save'">新增</button>
                    <c:if test="${url == '/sys/user'}"><%@include file="list/table-user.jsp"%></c:if>
                    <c:if test="${url == '/sys/role'}"><%@include file="list/table-role.jsp"%></c:if>
                    <c:if test="${url == '/sys/menu'}"><%@include file="list/table-menu.jsp"%></c:if>
                    <nav>
                        <ul class="pagination">
                            <c:if test="${pageList.hasPreviousPage}">
                                <li class="page-item"><a class="page-link" href="/sys/user?pageNum=${pageList.pageNum - 1}&pageSize=${pageList.pageSize}">Prev</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${pageList.pages}" var="i">
                            <li <c:if test="${i == pageList.pageNum}"> class="page-item active" </c:if> >
                                <a class="page-link" href="/sys/user?pageNum=${i}&pageSize=${pageList.pageSize}">${i}</a>
                            </li>
                            </c:forEach>
                            <c:if test="${pageList.hasNextPage}">
                                <li class="page-item"><a class="page-link" href="/sys/user?pageNum=${pageList.pageNum + 1}&pageSize=${pageList.pageSize}">Next</a></li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </c:if>
            <c:if test="${ opt == 'save' || opt == 'update' }">
                <div class="card-header">
                    <i class="fa fa-align-justify"></i> 表单
                </div>
                <c:if test="${url == '/sys/user'}"><%@include file="form/form-user.jsp"%></c:if>
                <c:if test="${url == '/sys/role'}"><%@include file="form/form-role.jsp"%></c:if>
                <c:if test="${url == '/sys/menu'}"><%@include file="form/form-menu.jsp"%></c:if>
            </c:if>
        </div>
    </div>
    <!--/.col-->
</div>
<!--/.row-->
</div>