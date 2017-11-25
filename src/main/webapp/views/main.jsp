<%--
  Created by IntelliJ IDEA.
  User: chunk
  Date: 2017/11/24
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="keywords" content="jquery,ui,easy,easyui,web">
    <meta name="description" content="easyui help you build your web page easily!">
    <title>固体火箭发动机结构完整性分析网站</title>
    <link rel="stylesheet" type="text/css" href="/jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery/demo/demo.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>


</head>
<body>
<div data-options="region:'north',border:false" style="height: 65px; background: #2596ea; padding: 10px">
    <img src="../images/logo.png" height="60px"/>
    <span style="color: #ffffff;font-size: 20pt" >固体火箭发动机结构完整性分析网站</span>
</div>
<div class="easyui-tabs" style="width:100%;height:100%;">
    <div title="输入计算参数" style="padding:10px;">
        <form>
            <div class="easyui-accordion" style="width:100%;height:700px;">
                <div title="几何参数"   iconCls="icon-ok" style="padding:10px;">
                    <div align="center" class="easyui-layout" style="width:95%;height:600px;">
                        <div id="p" data-options="region:'west'" title="West" style="width:40%;padding:10px">
                            <div  style="width:100%;max-width:400px;padding:30px 60px;" align="center">

                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="starNum" style="width:100%" data-options="label:'星角数:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="starCoefficient" style="width:100%" data-options="label:'星角系数:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="outerRadius" style="width:100%" data-options="label:'外径:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="featureLength" style="width:100%" data-options="label:'特征长度:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="arcRadius" style="width:100%" data-options="label:'过度圆弧半径:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="startAngle" style="width:100%" data-options="label:'星边夹角:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="starArcRadius" style="width:100%" data-options="label:'星角圆弧半径:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="ellipseYAxis" style="width:100%" data-options="label:'封头高度:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="grainLength" style="width:100%" data-options="label:'药柱长度:',required:true">
                                </div>

                                <div style="text-align:center;padding:5px 0">
                                    <input type="submit" formaction="/srm/generateGeometry"  style="width:80px"></input>
                                    <input type="reset"  style="width:80px"></input>
                                </div>
                            </div>
                        </div>
                        <div data-options="region:'center'" title="Center">
                        </div>
                    </div>
                </div>
                <div title="材料参数" iconCls="icon-reload" style="padding:10px;">
                    easyui help you build your web page easily
                </div>
                <div title="载荷参数" iconCls="icon-print">

                </div>
            </div>
        </form>
    </div>
    <div title="Second Tab" closable="true" style="padding:10px;">
        <iframe name="content_frame" marginwidth=0 marginheight=0 width=100% height=100% src="sign.jsp" frameborder=0></iframe>
    </div>
    <div title="Third Tab" iconCls="icon-reload" closable="true" style="padding:10px;">
        Third Tab
    </div>
</div>

</body>
