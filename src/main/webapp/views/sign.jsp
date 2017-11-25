<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="/jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery/demo/demo.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>
</head>
<STYLE>
    body{ text-align:center;max-width:500px; margin:0 auto; width:400px; height:100px; border:0px}
</STYLE>
<body >
<h2 align="center">用户注册</h2>
<p align="center">请注册结构完整性计算网站新用户</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="注册信息" style="width:100%;max-width:400px;padding:30px 60px;" align="center">
    <form id="ff" method="post" name="f1" action="/signUp" >
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="userName" style="width:100%" data-options="label:'用户名:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="password" type="password" style="width:100%" data-options="label:'密码:',required:true">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="email" style="width:100%" data-options="label:'邮箱:',required:true,validType:'email'">
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" name="phone" style="width:100%" data-options="label:'电话:',required:true">
        </div>
        <div style="text-align:center;padding:5px 0">
            <input type="submit" formaction="/srm/signUp"  style="width:80px"></input>
            <input type="reset"  style="width:80px"></input>
        </div>
    </form>

</div>
<script>
    function submitForm(){
        $('#ff').form('submit');
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>