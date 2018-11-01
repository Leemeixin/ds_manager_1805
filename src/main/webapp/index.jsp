<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/10/30
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <title>Title</title>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'',split:true" style="height:100px;">
    <center><font color="red" size="7">大牌好货一元抢</font></center>
</div>
<div data-options="region:'west',title:'京东',split:true" style="width:100px;">
    <ul id="tt" class="easyui-tree">
        <li>
            <span>家用电器</span>
            <ul>
                <li>
                    <span><a href="javascript:toShowPage('spu','/toSpuPage.do')">spu</a></span>
                </li>
                <li>
                    <span><a href="javascript:toShowPage('attr','/toAttrPage.do')">attr</a></span>
                </li>
                <li>
                    <span><a href="javascript:toShowPage('sku','/toSkuPage.do')">sku</a></span>
                </li>
            </ul>
        </li>
    </ul>
</div>
<div data-options="region:'center',title:'居中'" style="padding:5px;background:#eee;">
    <div id="tabs" class="easyui-tabs" data-options="fit:true">
        <div title="Tab1" style="padding:20px;display:none;">
            tab1
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function toShowPage(title, url){
        var exists = $('#tabs').tabs('exists',title);
        if(exists){
            $('#tabs').tabs('select',title);
        }else{
            $('#tabs').tabs('add',{
                title:title,
                content:'<iframe style="position:relative;height:100%;width:100%;" frameborder="0" scrolling="true" src="'+url+'"></iframe>',
                closable:true,
                iconCls:'icon-flag-red',
                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler:function(){
                        var tab = $('#tabs').tabs("getSelected");
                        $('#tabs').tabs('update', {tab: tab});
                    }
                }]
            });
        }
    }
</script>
</html>
