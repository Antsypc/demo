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
<script src="${ctx}/public/vendor/DataTables-1.10.12/js/jquery.dataTables.js"></script>
<%--<script src="${ctx}/public/vendor/DataTables-1.10.12/js/jquery.dataTables.min.js"></script>--%>
<script src="${ctx}/public/vendor/DataTables-1.10.12/js/dataTables.bootstrap.js"></script>
<%--<script src="${ctx}/public/vendor/DataTables-1.10.12/js/dataTables.bootstrap.min.js"></script>--%>

<script type="text/javascript">
    $(function () {
        var myTable = $("#student-table").DataTable({
            serverSide: true,
            // 为了对接后台接口, ajax 有三种可以自定义的方式
            ajax: {
                url: '${ctx}/paging/students/json',
                type: 'POST',
                // 为了对接后台接口, data 有多种可以自定义的方式
                data: function (d) {
                    console.log(d);
                    return {
                        draw: d.draw,
                        start: d.start,
                        length: d.length,
                        "order[0].column": d.order[0].column,
                        "order[0].dir": d.order[0].dir,
                        department: $("#department").val(),
                        major: $("#major").val(),
                        classes: $("#classes").val()
                    };
                }
            },
            columns: [
                {data: "studentId"},
                {data: "password"},
                {data: "name"},
                {data: "department"},
                {data: "major"},
                {data: "classes"},
                {data: "gender"},
                {data: "inYear"},
                {data: "nativePlace"},
                {data: "phone"},
                {data: "email"}
            ]
            // 或者将 ajax 用function (data, callback, settings)赋值, 最后一定要回调 callback
            //ajax: function (data, callback, settings) {
            //    var d = {
            //        // 自定义上传的数据,分页参数和额外参数
            //    };
            //    // 自定义ajax执行
            //    $.ajax({
            //        url: '${ctx}/paging/students',
            //        type: 'POST',
            //        data: d
            //    }).done(function (data) {
            //        callback(data); // 一定要回调,才能把数据填充到表格
            //    }).fail(function (reason) {
            //        console.log(reason);
            //    });
            //}


        });

        $("#search").click(function () {
            myTable.ajax.reload();
        });
    });

</script>

</body>
</html>
