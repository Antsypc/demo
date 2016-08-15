<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>学生查询 | 分页查询DEMO</title>
    <link rel="stylesheet" href="${ctx}/public/vendor/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${ctx}/public/vendor/DataTables-1.10.12/css/jquery.dataTables.min.css"/>
</head>
<body>

    <div>
        <form class="form-inline">
            <div class="form-group">
                <label for="department">学院</label>
                <input type="text" class="form-control" id="department" placeholder="">
            </div>
            <div class="form-group">
                <label for="major">专业</label>
                <input type="text" class="form-control" id="major" placeholder="">
            </div>
            <div class="form-group">
                <label for="classes">班级</label>
                <input type="text" class="form-control" id="classes" placeholder="">
            </div>

            <button type="button" class="btn btn-default" id="search">查询</button>
        </form>

        <div class="box-body" style="padding:20px">
            <table id="student-table" class="cell-border display compact" cellspacing="0" width="100%">
                <thead>
                <tr>
                    <c:forEach var="head" items="${requestScope.heads}">
                        <td data-head="">${head}</td>
                    </c:forEach>
                </tr>
                </thead>
            </table>
        </div>
    </div>



<script src="${ctx}/public/vendor/jQuery/jquery-2.2.3.min.js"></script>
<script src="${ctx}/public/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/public/vendor/DataTables-1.10.12/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/public/vendor/DataTables-1.10.12/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript">
    $("#student-table").DataTable({

    });
</script>

</body>
</html>
