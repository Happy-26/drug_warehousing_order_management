<%@ page import="org.example.entity.Header" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.entity.Drug" %>
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
<br/>
<div align="center">
	<form action="queryDrugById.do">
		<input class="searchText" name="drugId" placeholder="输入要查询的药品编号" type="text" />
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
            List<Drug> drugList = (List<Drug>) request.getAttribute("drugList");
             for (int i = 0; i < drugList.size(); i++){
                 String drugId = "<a href='queryDrugById.do?drugId=" +
                 drugList.get(i).getDrugId() + "'>"+drugList.get(i).getDrugId() +"</a>";
         %>
		{
			"drugId": "<%=drugId %>",
			"drugName": "<%=drugList.get(i).getDrugName()%>",
			"unit": "<%=drugList.get(i).getUnit()%>",
			"packageType": "<%=drugList.get(i).getPackageType()%>",
			"option": "<a href='queryDrugById.do?drugId=<%=drugList.get(i).getDrugId()%>'>编辑</a> " +
					"<a href='deleteDrugById.do?drugId=<%=drugList.get(i).getDrugId()%>'>删除</a>",
		},
		<%
            }
        %>
	];

	<%
        if (request.getAttribute("msg") != null) {
    %>
	// 未查到药品提示
	alert("<%=request.getAttribute("msg")%>")
	<%
    }
    %>

	//前台分页的样子
	$('#histroyBox').CJJTable({
		'title': ["药品编号", "药品名称", "药品单位", "药品包装","操作"],//thead中的标题 必填
		'body': ["drugId", "drugName", "unit", "packageType", "option"],//tbody td 取值的字段 必填
		'display': [1, 1, 1, 1],//隐藏域，1显示，2隐藏 必填
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
