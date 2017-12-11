<%--
  Created by IntelliJ IDEA.
  User: chunk
  Date: 2017/11/30
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>固体火箭发动机结构完整性分析网站</title>
    <link rel="stylesheet" type="text/css" href="/jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery/demo/demo.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/resources/js/history.js"></script>
</head>
<body>
<h2>Basic DataGrid</h2>
<p>The DataGrid is created from markup, no JavaScript code needed.</p>
<div style="margin:20px 0;"></div>

<table id="dg" class="easyui-datagrid" title="Basic DataGrid" style="width:850px;height:250px"
       data-options="singleSelect:true,collapsible:true,url:'/srm/history',method:'get'">
    <thead>
    <tr>
        <th data-options="field:'userName',width:60,align:'center'">用户名</th>
        <th data-options="field:'geometric',width:80,align:'center'">药型</th>
        <th data-options="field:'geometricId',width:80,align:'center'">药型ID</th>
        <th data-options="field:'time',width:200,align:'center',formatter:function(value,row,index){
                         var unixTimestamp = new Date(value);
                         return unixTimestamp.toLocaleString();
                         } ">计算日期</th>
        <th data-options="field:'eprincipal1',width:150,align:'center'">冷却降温应变</th>
        <th data-options="field:'eprincipal2',width:150,align:'center'">点火应变</th>
        <th data-options="field:'id',width:60,align:'center',formatter:input">查看参数</th>
        <th data-options="field:'calculatePath',width:60,align:'center',formatter:result">查看结果</th>

    </tr>
    </thead>
</table>

</body>

<script>
    function input(value,row,index){
        return "<a href='/srm/views/sign.jsp' target='_blank'>查看参数</a>";
    }

    function result(value,row,index){
        return "<a href='/srm/resultPic?path="+value+"' target='_blank'>查看结果</a>";
    }
</script>

</html>
