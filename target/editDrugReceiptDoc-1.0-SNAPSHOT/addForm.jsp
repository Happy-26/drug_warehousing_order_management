<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
        .table {
            text-align: center;
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
								<h1><b>药品入库单</b></h1>
							</div>
								<form name="f" action="javascript:;" method="post">

								<center class="ibox-content" style="width: 100%;">
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">入库单编号:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="warehousingId" id="warehousingId"
                                           readonly>
								</div>
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">入库日期</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" id="indate" name="indate">
								</div>
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">入库人员:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="indatePerson">
								</div>
								<br>
								<br>
								<br>
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">供应商名称:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" id="supplierName" class="form-control" name="supplierName">
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">地址:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="address" id="address" readonly>
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">邮编:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="zipCode" id="zipCode" readonly>
								</div>
								<br>
								<br>
								<br>
								<label class="col-sm-2 control-label"
                                       style="width: 150px;line-height: 32px;text-align: left">供应商开户行:</label>
								<div class="col-sm-10" style="width: 280px;margin-right: 40px">
									<input type="text" class="form-control" name="supplierBank" id="supplierBank"
                                           readonly>
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 150px;line-height: 32px">供应商银行账号:</label>
								<div class="col-sm-10" style="width: 280px">
									<input type="text" class="form-control" name="supplierBankAccount"
                                           id="supplierBankAccount" readonly>
								</div>
								<br>
								<br>
								<br>
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">供应商电话:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="supplierTelephone"
                                           id="supplierTelephone" readonly>
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">联系人:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="contacts" id="contacts" readonly>
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">联系电话:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="contactTelephone"
                                           id="contactTelephone" readonly>
								</div>
								<br>
								<br>

								<table class="table table-bordered table-hover">
									<tr class="info">
										<td>序号</td>
										<td>药品编码</td>
										<td>药品名称</td>
										<td>单位</td>
										<td>包装</td>
										<td>进价</td>
										<td>数量</td>
										<td>金额</td>
										<td>有效日期</td>
										<td>操作</td>
									</tr>
									<tr>
										<td colspan="10" class="danger"><button class="btn btn-primary btn-sm"
                                                                                type="button"
                                                                                style="height: 36px;width: 120px;margin: 0px">增加空行</button></td>
									</tr>
								</table>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px;margin-left: 45%">
									<h3>总金额:</h3>
								</label>
								<label class="col-sm-2 control-label" style="width: 100px;line-height: 32px">
									<h3><input id="money" value="0.0" readonly style="width: 100px;background-color: #eee" ></h3>
								</label>
								<br>
								<br>
								<br>
								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">审核人:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="reviewer">
								</div>

								<label class="col-sm-2 control-label"
                                       style="width: 100px;line-height: 32px">审核日期:</label>
								<div class="col-sm-10" style="width: 200px">
									<input type="text" class="form-control" name="auditDate">
								</div>
								<br>
								<br>
								<br>
									<span id="tableListSpan">
										<input type="hidden" id="count" name="count" value="0"/>
										<input type="hidden" id="hang" name="hang" value="0"/>
									</span>

									<button type="submit" style="width: 150px;height: 40px"
                                            onclick="javascript:tableListData();document.f.action='addForm.do';document.f.submit();">提交</button>
								</center>
								</form>
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

<script src="./js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="./js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="./js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script src="./js/plugins/datapicker/bootstrap-datepicker.js"></script>

<!-- 自定义js -->
<script src="./js/content.js?v=1.0.0"></script>
<script src="./js/jquery.min.js"></script>
<script type="text/javascript">
    $(sessionStorage.removeItem("addTableList"))
</script>
<script src="./js/addtTable.js"></script>

<!-- Placed js at the end of the document so the pages load faster -->
<script src="./js/jquery-1.10.2.min.js"></script>
<script src="./js/jquery-ui-1.9.2.custom.min.js"></script>
<script src="./js/jquery-migrate-1.2.1.min.js"></script>
<script src="./js/modernizr.min.js"></script>
<script src="./js/jquery.nicescroll.js"></script>

<!--data table-->
<!--common scripts for all pages-->
<script src="./js/scripts.js"></script>

<script type="text/javascript">
    $(function () {
            // 自动生成订单编号
            var warehousingId = new Date;
            $('#warehousingId').val('' + (warehousingId.getFullYear() % 2000) + (warehousingId.getMonth() + 1) +
                warehousingId.getDate() + warehousingId.getHours() + warehousingId.getMinutes() + warehousingId.getSeconds());

            // 初始化入库日期
            $('#indate').val(warehousingId.getFullYear() + "-" + (warehousingId.getMonth() + 1) + "-" +
                warehousingId.getDate());

            $("#supplierName").keydown, $("#supplierName").keyup(function () {
                $.ajax({
                    url: "querySupplierByNameAjax.do",
                    data: {
                        supplierName: $('#supplierName').val()
                    },
                    type: "post",
                    dataType: "json",
                    success: function (res) {
                        $("#address").val(res.address);
                        $("#zipCode").val(res.zipCode);
                        $("#supplierBank").val(res.supplierBank);
                        $("#supplierBankAccount").val(res.supplierBankAccount);
                        $("#supplierTelephone").val(res.supplierTelephone);
                        $("#contacts").val(res.contacts);
                        $("#contactTelephone").val(res.contactTelephone);
                    }
                })
            })
        },
    )

	function tdval(item) {
    	// 获取当前td所在行
		var rows = $(item.parentNode).parent().prevAll().length-1;
		var drugId = 'drugId'+rows;
		$.ajax({
			url: "queryDrugByIdAjax.do",
			data: {
				drugId: document.getElementById(drugId).value,
				rows: rows
			},
			type: "post",
			dataType: "json",
			success: function (res) {
				$.each(arr, function (i, v) {
					// alert(i,rows)
					if(i == rows){
						v.drugName = $("#drugName"+i).value;
						v.unit = $("#unit"+i).value;
						v.packageType = $("#packageType"+i).value;
					}
				});
				$('#drugName' + rows).val(res.drugName);
				$('#unit' + rows).val(res.unit);
				$('#packageType' + rows).val(res.packageType);
			}
		})
    }
</script>
</body>
</html>
