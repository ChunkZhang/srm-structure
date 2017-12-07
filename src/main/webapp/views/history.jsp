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
<table id="tt" class="easyui-datagrid" style="width:600px;height:250px"
       url="/srm/history"
       title="Load Data" iconCls="icon-save"
       rownumbers="true" pagination="true">
    <thead>
    <tr>
        <th field="itemid" width="80">Item ID</th>
        <th field="productid" width="80">Product ID</th>
        <th field="listprice" width="80" align="right">List Price</th>
        <th field="unitcost" width="80" align="right">Unit Cost</th>
        <th field="attr1" width="150">Attribute</th>
        <th field="status" width="60" align="center">Stauts</th>
    </tr>
    </thead>
</table>
</body>
</html>
