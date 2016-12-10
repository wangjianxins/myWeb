<%--
  Created by IntelliJ IDEA.
  User: wangjianxin
  Date: 2016/10/25
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>萤火之森</title>
    <script src="/resources/js/jquery-1.10.2.min.js"></script>
<decorator:head/>
</head>

<body>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<decorator:body/>


哈哈
</body>
<script>
    $.ajax({
        url:"/s/t.json",
        type:"get",
        success:function(data){
            alert(data);
        }
    })

</script>
</html>
