<%--
  Created by IntelliJ IDEA.
  User: chunk
  Date: 2017/12/10
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Tabs - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="/jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/jquery/demo/demo.css">
    <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/resources/js/history.js"></script>
</head>
<body>
<h2 align="center">Basic Tabs</h2>
<p align="center">Click tab strip to swap tab panel content.</p>
<div align="center" style="margin:20px 0 10px 0;"></div>
<div class="easyui-tabs" style="width:100%;height:600px">
    <div id="div11" title="降温结束应力" style="padding:10px;text-align: center; background-repeat: no-repeat;  color: #F8F8F8;  ">

    </div>
    <div id="div12" title="降温结束应变" style="padding:10px;text-align: center; background-repeat: no-repeat;  color: #F8F8F8;">

    </div>
    <div id="div13" title="降温结束位移" style="padding:10px;text-align: center; background-repeat: no-repeat; color: #F8F8F8;">

    </div>
    <div id="div21" title="点火结束应力" style="padding:10px;text-align: center; background-repeat: no-repeat;color: #F8F8F8;">

    </div>
    <div id="div22" title="点火结束应变" style="padding:10px;text-align: center; background-repeat: no-repeat; color: #F8F8F8;">

    </div>
    <div id="div23" title="点火结束位移"  style="padding:10px;text-align: center; background-repeat: no-repeat;color: #F8F8F8;">

    </div>
</div>
</body>

<script>
    $(document).ready(function () {
        showResult();
    })

    function getcookie(objname){
        var arrstr = document.cookie.split("; ");
        for(var i = 0;i < arrstr.length;i ++){
            var temp = arrstr[i].split("=");
            if(temp[0] == objname)
                return temp[1];
        }
    }
    function showResult() {
        var pathList = getcookie("resultPicList");
        var temp = pathList.split(",");
        document.getElementById("div11").style.backgroundImage="url('/srm/result/"+temp[0].substr(2,temp[0].length)+"')";
        document.getElementById("div12").style.backgroundImage="url('/srm/result/"+temp[1].substr(1,temp[1].length)+"')";
        document.getElementById("div13").style.backgroundImage="url('/srm/result/"+temp[2].substr(1,temp[1].length)+"')";
        document.getElementById("div21").style.backgroundImage="url('/srm/result/"+temp[3].substr(1,temp[1].length)+"')";
        document.getElementById("div22").style.backgroundImage="url('/srm/result/"+temp[4].substr(1,temp[1].length)+"')";
        document.getElementById("div23").style.backgroundImage="url('/srm/result/"+temp[5].substr(1,temp[2].length-1)+"')";
        return temp[num];
    }
</script>
</html>