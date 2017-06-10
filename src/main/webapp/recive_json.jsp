<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>发送JSON</title>
    <script TYPE="TEXT/JAVASCRIPT" src="js/jquery-3.2.1.min.js"></script>
    <!--不能放在WIN-INF目录,这个目录下面的文件是受服务器保护的。-->
</head>
<p id="z"></p>
<table id="t">
<tbody>
<tr>
    <th>id</th>
    <th>name</th>
</tr>
</tbody>
</table>
<body>
</body>
<p>在Chrome中，它显示在控制台下面的错误：
    Uncaught TypeError: Cannot use 'in' operator to search for '156'
    in [{"id":"1","tagName":"apple"}...
    解决方案：JSON字符串转换为javascript对象。
    要修复它，通过标准JSON.parse()或jquery 的 $.parseJSON 将其转换为JavaScript对象。</p>
</html>
<script>
    $(document).ready(function(){
        testRequest();
    });
    function testRequest(){
        $.post("${PageContext.request.contextPath}/json/sendjson",null,function(data1){
           // var data= $.parseJSON(data1);
            var data=JSON.parse(data1);
            $.each(data,function(idx,obj){
             var tr=$("<tr/>");
             $("<td/>").html(obj.id).appendTo(tr);
             $("<td/>").html(obj.name).appendTo(tr);
             $("#t").append(tr);
                    }
            );
        });
    }
</script>
