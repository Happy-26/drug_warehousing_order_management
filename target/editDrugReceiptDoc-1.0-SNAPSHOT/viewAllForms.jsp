<%@ page import="org.example.domain.Header" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HAPPY
  Date: 2021/9/12
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="./js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="./js/front-endPage.js"></script><!-- 前台分页 -->

    <link rel="stylesheet" type="text/css" href="./css/table.css">
    <style type="text/css">
        a{
            font-size: 24px;
        }
        .searchText{
            font-size: 24px;
            background-color: #D0DCF3;
            border-style: solid;
            border: #0a6aa1;
            border: 5px;
            width: 400px;
            height: 50px;
        }
        .serachButt{
            width: 100px;
            font-size: 23px;
            background-color: #0a6aa1;
            height: 50px;
        }
    </style>    
</head>

<body>

<body>
<br/>
<div align="center">
    <form action="queryFormById.do">
        <input class="searchText" name="warehousingId" placeholder="输入要查询的入库单编号" type="text" />
        <input class="serachButt" type="submit" value="查询" >
    </form>
</div>
<br/>

<div id="histroyBox"></div>
<script type="text/javascript">
    // 表单的数据
    var data = [
        // 使用jstl或者el将数据库数据拼接进去
        <%
            List<Header> headerList = (List<Header>) request.getAttribute("headerList");
             for (int i = 0; i < headerList.size(); i++){
                 String warehousingId = "<a href='queryFormById.do?warehousingId=" +
                 headerList.get(i).getWarehousingId() + "'>"+headerList.get(i).getWarehousingId() +"</a>";
         %>
            {
                "warehousingId": "<%=warehousingId %>",
                "indate": "<%=headerList.get(i).getIndate()%>",
                "indatePerson": "<%=headerList.get(i).getIndatePerson()%>",
                "auditDate": "<%=headerList.get(i).getAuditDate()%>",
                "reviewer": "<%=headerList.get(i).getReviewer()%>",
                "option": "<a href='queryFormById.do?warehousingId=<%=headerList.get(i).getWarehousingId()%>'>编辑</a> " +
                    "<a href='deleteForm.do?warehousingId=<%=headerList.get(i).getWarehousingId()%>'>删除</a>",
            },
        <%
            }
        %>
    ];
    //前台分页的样子
    $('#histroyBox').CJJTable({
        'title': ["入库单编号", "入库日期", "入库人员", "审核日期", "审核人", "操作"],//thead中的标题 必填
        'body': ["warehousingId", "indate", "indatePerson", "auditDate", "reviewer", "option"],//tbody td 取值的字段 必填
        'display': [1, 1, 1, 1, 1, 1],//隐藏域，1显示，2隐藏 必填
        'pageNUmber': 10,//每页显示的条数 选填
        'pageLength': data.length,//选填
        'url': data,//数据源 必填
        dbTrclick: function (e) {//双击tr事件
            alert(e.find('.warehousingId').html())
        }
    });
</script>

</body>
</html>
