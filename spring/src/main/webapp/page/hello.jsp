<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
${msg}
<form action="<%=request.getContextPath()%>/example/pa/user/profile">
    id: <input id = "id" name="id"/>
    password: <input id = "password" name="password"/>
    name: <input id = "name" name="name"/>
    position: <input id = "position" name="position"/>
    gender: <input id = "gender" name="gender"/>
    phone: <input id = "phone" name="phone"/>
    email: <input id = "email" name="email"/>
    <button id="post">提交</button>
    <button id="get" type="submit">get</button>
    <button id="do">do</button>

</form>



<script src="<%=request.getContextPath()%>/public/vendor/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $("#post").on('click',function() {
        var id = $("#id").val();
        var password = $("#password").val();
        var name = $("#name").val();
        var position = $("#position").val();
        var gender = $("#gender").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var data = {
            id : id,
            password : password,
            name : name,
            position : position,
            gender : gender,
            phone : phone,
            email : email
        };
        data = JSON.stringify(data);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            data: data,
            url:"<%=request.getContextPath()%>/example/pa/user/profile",
            success : function(data) {
                alert(data);
                console.log(data)
            },
            error: function(data) {
                console.log(data);
            }
        });
        return false;
    });
    $("#do").on('click',function() {
        var id = $("#id").val();
        var password = $("#password").val();
        var name = $("#name").val();
        var position = $("#position").val();
        var gender = $("#gender").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var data = {
            id : id,
            password : password,
            name : name,
            position : position,
            gender : gender,
            phone : phone,
            email : email
        };
        data = JSON.stringify(data);
        $.ajax({
            type:"POST",
            contentType:"application/json",
            data: data,
            url:"<%=request.getContextPath()%>/example/pa/user/profile/do",
            success : function(data) {
                alert(data);
                console.log(data)
            },
            error: function(data) {
                console.log(data);
            }
        });
        return false;
    });
</script>
</body>
</html>