<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>发送JSON</title>
    <script TYPE="TEXT/JAVASCRIPT" src="js/jquery-3.2.1.min.js"></script>
    <!--不能放在WIN-INF目录,这个目录下面的文件是受服务器保护的。-->
</head>
<p id="z"></p>
<body>
</body>
</html>
<script>
    $(document).ready(function(){
        testRequest();
    });
    function testRequest(){
        $.ajax({ url: "${PageContext.request.contextPath}/json/recjson",
            method: "post",
            dataType:"json",
            contentType:"appliction/json",
            data:JSON.stringify({id:"1 ", name:"spring MVC学习指南"}),
            async:true,      //异步请求
            success: function(data){
                console.log(data);
                //alert(data);
            $("#z").html("id为"+data.id);
         }});
    }
</script>
