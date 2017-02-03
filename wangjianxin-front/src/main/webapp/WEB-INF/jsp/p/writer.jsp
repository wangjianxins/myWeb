<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2017/1/9
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"  class="demo-2 no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>写文章</title>
    <jsp:include  page="/WEB-INF/jsp/header.jsp"/>

    <link rel="stylesheet" type="text/css" href="/resources/css/start_/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/start_/component.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/p/p.css" />
    <script src="/resources/js/star/snap.svg-min.js"></script>
    <!--[if IE]>
    <!--<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>-->
    <%--<![endif]-->--%>

    <link href="/resources/css/p/umeditor.css" type="text/css" rel="stylesheet">


    <script src="/resources/js/alert/jquery-confirm.js"></script>
    <script src="/resources/js/alert/jquery.sticky.min.js"></script>
    <script src="/resources/js/alert/pretty.js"></script>
    <script src="/resources/js/star/star.js"></script>
    <%--<link rel="stylesheet" href="/resources/css/alert/jquery-confirm.css">--%>

    <%--<script type="text/javascript" src="/resources/js/p/jquery.min.js"></script>--%>
    <script type="text/javascript" charset="utf-8" src="/resources/js/p/umeditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/js/p/umeditor.min.js"></script>
    <script type="text/javascript" src="/resources/js/p/zh-cn.js"></script>
    <script src="/resources/js/p/writer.js"></script>

</head>
<body>
<h1>UMEDITOR 完整demo</h1>
<div id="wangjianxin">

</div>
<!--style给定宽度可以影响编辑器的最终宽度-->
<%--<script type="text/plain" id="wangjianxin" style="width:1000px;height:240px;"></script>--%>

<div class="clear"></div>
    <div id="btns">
        <table>
            <tr>
                <td>
                    <button class="btn" unselected="on" onclick="getAllHtml()">获得整个html的内容</button>&nbsp;
                    <button class="btn" onclick="getContent()">获得内容</button>&nbsp;
                    <button class="btn" onclick="setContent()">写入内容</button>&nbsp;
                    <button class="btn" onclick="setContent(true)">追加内容</button>&nbsp;
                    <button class="btn" onclick="getContentTxt()">获得纯文本</button>&nbsp;
                    <button class="btn" onclick="getPlainTxt()">获得带格式的纯文本</button>&nbsp;
                    <button class="btn" onclick="hasContent()">判断是否有内容</button>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn" onclick="setFocus()">编辑器获得焦点</button>&nbsp;
                    <button class="btn" onmousedown="isFocus();return false;">编辑器是否获得焦点</button>&nbsp;
                    <button class="btn" onclick="doBlur()">编辑器取消焦点</button>&nbsp;
                    <button class="btn" onclick="insertHtml()">插入给定的内容</button>&nbsp;
                    <button class="btn" onclick="getContentTxt()">获得纯文本</button>&nbsp;
                    <button class="btn" id="enable" onclick="setEnabled()">可以编辑</button>&nbsp;
                    <button class="btn" onclick="setDisabled()">不可编辑</button>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn" onclick="UM.getEditor('myEditor').setHide()">隐藏编辑器</button>&nbsp;
                    <button class="btn" onclick="UM.getEditor('myEditor').setShow()">显示编辑器</button>&nbsp;
                    <button class="btn" onclick="UM.getEditor('myEditor').setHeight(300)">设置编辑器的高度为300</button>&nbsp;
                    <button class="btn" onclick="UM.getEditor('myEditor').setWidth(1200)">设置编辑器的宽度为1200</button>
                </td>
            </tr>

        </table>
    </div>
    <table>
        <tr>
            <td>
                <button class="btn" onclick="createEditor()"/>创建编辑器</button>
                <button class="btn" onclick="deleteEditor()"/>删除编辑器</button>
            </td>
        </tr>
    </table>

    <div>
        <h3 id="focush2"></h3>
    </div>
</body>
</html>
