<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>药品入库单编辑</title>

    <link rel="stylesheet" href="./css/bootstrap.css">
    <link href="./css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="./css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="./css/plugins/datapicker/datepicker3.css" rel="stylesheet">

    <link rel="stylesheet" href="./js/data-tables/DT_bootstrap.css"/>
    <link href="./css/style2.css" rel="stylesheet">
    <link href="./css/style-responsive.css" rel="stylesheet">

    <!-- Data Tables -->
    <link href="./css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">

    <link href="./css/animate.css" rel="stylesheet">
    <link href="./css/style.css?v=4.1.0" rel="stylesheet">
    <style media="screen">
        table {
            width: 100%;
            line-height: 60px;
            text-align: center;
        }

        tr {
            line-height: 100px;
            font-size: 26px;
        }

        td {
            width: 50%;
        }

        .infom {
            width: 200px;
        }

        .form-control {
            width: 300px;
            border-width: 5px;
            height: 40px;
        }

        .col-sm-10 {
            width: 300px;
            float: unset;
            display: inline-block;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="row">
                    <div class="col-sm-12">
						<span class="ibox float-e-margins" style="text-align: center">
							<div class="ibox-title" align="center">
								<h1><b>修改供应商</b></h1>
								<br>
								<br>
								<center>
									<form name="f" action="modifySupplierByName.do" method="post"
                                          style="width: 100%;text-align: center">
										<table style="text-align: center;line-height: 60px;width: 100%">
											<tr>
												<td><label class="infom">供应商名称:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
                                                               value="${supplier.supplierName}"
                                                               name="supplierName">
													</div>
												</td>
												<td><label class="infom">联系电话:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
                                                               value="${supplier.contactTelephone}"
                                                               name="contactTelephone">
													</div>
												</td>
											</tr>
											<tr>
												<td><label class="infom">地址:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="address"
                                                               value="${supplier.address}">
													</div>
												</td>
												<td><label class="infom">邮编:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="zipCode"
                                                               value="${supplier.zipCode}">
													</div>
												</td>
											</tr>
											<tr>
												<td><label class="infom">供应商开户行:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
                                                               name="supplierBank" value="${supplier.supplierBank}">
													</div>
												</td>
												<td><label class="infom">供应商银行账号:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
                                                               value="${supplier.supplierBankAccount}"
                                                               name="supplierBankAccount">
													</div>
												</td>
											</tr>
											<tr>
												<td><label class="infom">供应商电话:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control"
                                                               value="${supplier.supplierTelephone}"
                                                               name="supplierTelephone">
													</div>
												</td>
												<td><label class="infom">联系人:</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="contacts"
                                                               value="${supplier.contacts}">
													</div>
												</td>
											</tr>
										</table>

										<button type="submit" style="width: 150px;height: 40px">提交</button>
									</form>
								</center>
							</div>
						</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- 全局js -->
<script src="./js/jquery.min.js?v=2.1.4"></script>
<script src="./js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="./js/content.js?v=1.0.0"></script>
<script src="./js/jquery.min.js"></script>


</body>
</html>
