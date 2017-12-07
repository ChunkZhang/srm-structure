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
    <script type="text/javascript" src="/resources/js/main.js"></script>



</head>
<body>
<div data-options="region:'north',border:false" style="height: 65px; background: #2596ea; padding: 10px">
    <img src="../images/logo.png" height="60px"/>
    <span style="color: #ffffff;font-size: 20pt" >固体火箭发动机结构完整性分析网站</span>
</div>
<div class="easyui-tabs" style="width:100%;height:100%;">
    <div title="输入计算参数" style="padding:10px;">
        <form id="form" >
            <div class="easyui-accordion" style="width:100%;height:700px;">
                <div title="几何参数"   iconCls="icon-ok" style="padding:10px;">
                    <div align="center" class="easyui-layout" style="width:95%;height:600px;">
                        <div id="pp" data-options="region:'west'" title="" style="width:40%;padding:10px">
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
                                    <%--<input type="submit" formaction="/srm/generateGeometry"  style="width:80px"></input>--%>
                                        <input id="generateGeometryInput" formaction="/srm/generateGeometry" type="submit"  style="width:80px"></input>
                                        <input type="reset"  style="width:80px"></input>
                                </div>
                            </div>
                        </div>
                        <div id="divshow" data-options="region:'center'" title="" style="background-image: url('../images/banner2.jpg');background-repeat: no-repeat;background-size: cover;">
                            <a onclick="a()" class="easyui-linkbutton" plain="true">1</a>
                            <a onclick="b()" class="easyui-linkbutton" plain="true">2</a>
                            <a onclick="c()" class="easyui-linkbutton" plain="true">3</a><br>
                        </div>
                    </div>
                </div>
                <div title="材料参数" iconCls="icon-reload" style="padding:10px;">
                    <div align="center" class="easyui-layout" style="width:95%;height:600px;">
                        <div id="p" data-options="region:'west'" title="" style="width:50%;padding:10px">
                            <div  style="width:100%;max-width:400px;padding:30px 60px;" align="center">

                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="poissonRatio" style="width:100%" data-options="label:'泊松比:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="expansion" style="width:100%" data-options="label:'热膨胀系数:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="density" style="width:100%" data-options="label:'密度:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                    <input class="easyui-textbox" name="modulus" style="width:100%" data-options="label:'模量:',required:true">
                                </div>

                                <TABLE title="prony级数" style="width: 320px;height:150px">
                                    <THEAD>
                                    <tr>
                                        <th></th>
                                        <th >g_i Prony</th>
                                        <th >k_i Prony</th>
                                        <th>tau_i Prony</th>
                                    </tr>
                                    <tr>
                                        <th >1</th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable1][0]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable1][1]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable1][2]" style="width:60px" data-options="required:true">
                                        </th>
                                    </tr>
                                    <tr>
                                        <th >2</th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable2][0]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable2][1]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable2][2]" style="width:60px" data-options="required:true">
                                        </th>
                                    </tr>
                                    <tr>
                                        <th >3</th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable3][0]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable3][1]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="pronyTable[PronyTable3][2]" style="width:60px" data-options="required:true">
                                        </th>
                                    </tr>
                                    </thead>
                                </TABLE>

                                <table title="室温等效因子" style="width: 320px;height:100px">
                                    <thead>
                                    <tr>
                                        <th ></th>
                                        <th>Theta 0</th>
                                        <th >C1</th>
                                        <th >C2</th>
                                    </tr>
                                    <tr>
                                        <th >1</th>
                                        <th >
                                            <input class="easyui-textbox" name="trsTable[0]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="trsTable[1]" style="width:60px" data-options="required:true">
                                        </th>
                                        <th >
                                            <input class="easyui-textbox" name="trsTable[2]" style="width:60px" data-options="required:true">
                                        </th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                        </div>
                        <div data-options="region:'center'" title="">
                            <div  style="width:100%;max-width:400px;padding:30px 60px;" align="center">

                                <div style="margin-bottom:20px">
                                <input class="easyui-textbox" name="originTemperature" style="width:100%" data-options="label:'初始温度:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                <input class="easyui-textbox" name="finalTemperature" style="width:100%" data-options="label:'最终温度:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                <input class="easyui-textbox" name="timeSpan" style="width:100%" data-options="label:'降温时间:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                <input class="easyui-textbox" name="maxPressure" style="width:100%" data-options="label:'最大压力:',required:true">
                                </div>
                                <div style="margin-bottom:20px">
                                <input class="easyui-textbox" name="ignitionTimeSpan" style="width:100%" data-options="label:'点火时间:',required:true">
                                </div>
                                <div style="text-align:center;padding:5px 0">
                                    <%--<input type="submit" formaction="/srm/generateGeometry"  style="width:80px"></input>--%>
                                    <input id="calculateTestInput" onclick="changeAction()" type="submit"  style="width:80px"></input>
                                    <input type="reset"  style="width:80px"></input>
                                </div>
                            </div>
                        </div>
                    </div>
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
<script>
    function a() {
        document.getElementById("divshow").style.backgroundImage="url('/srm/result/"+getPath(0)+".png')";
    }
    function b() {
        document.getElementById("divshow").style.backgroundImage="url('/srm/result/"+getPath(1)+".png')";
    }
    function c() {
        document.getElementById("divshow").style.backgroundImage="url('/srm/result/"+getPath(2)+".png')";

    }
    function getcookie(objname){
        var arrstr = document.cookie.split("; ");
        for(var i = 0;i < arrstr.length;i ++){
            var temp = arrstr[i].split("=");
            if(temp[0] == objname)
                return temp[1];
        }
    }
    function getPath(num) {
        var pathList = getcookie("picPathList");
        var temp = pathList.split(",");
        temp[0] = temp[0].substr(2,temp[0].length);
        temp[1] = temp[1].substr(1,temp[1].length);
        temp[2] = temp[2].substr(1,temp[2].length-3);
        return temp[num];
    }

    function changeAction() {
        var form = document.getElementById("generateGeometryInput");
        form.setAttribute("formaction","/srm/calculateTest");
    }

</script>
</body>
