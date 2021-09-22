$(function () {

    //获取本地存储数据，并且转换成对象
    arr = [];

    function getData() {
        if (sessionStorage.addTableList == undefined) {
            arr = [];
        } else {
            arr = JSON.parse(sessionStorage.addTableList);
        }
        return arr;
    }

    add()

    //把数据存到本地存储，并且转换成字符串格式的JSON
    function saveData(data, rows) {
        $.each(data, function (i, v) {
            if(i == rows-1 && rows > 0){
                v.drugId = document.getElementById("drugId"+(rows-1)).value;
                v.drugName = document.getElementById("drugName"+(rows-1)).value;
                v.unit = document.getElementById("unit"+(rows-1)).value;
                v.packageType = document.getElementById("packageType"+(rows-1)).value;
                v.purchase = document.getElementById("purchase"+(rows-1)).value;
                v.amount = document.getElementById("amount"+(rows-1)).value;
                v.money = document.getElementById("money"+(rows-1)).value;
                v.effectiveDate = document.getElementById("effectiveDate"+(rows-1)).value;
            }
        });
        sessionStorage.addTableList = JSON.stringify(data);
    }


    //增加行方法
    function add() {
        $("tr:not(tr:first,tr:last)").remove();//每次增加行前删除前面的行，否则会重复增加
        data = getData();
        $.each(data, function (i, v) {
            $("<tr>").attr("index", i).html("<td contenteditable='true' data-role='orderNumber'>" + (v.orderNumber=i+1) + "</td>"
                + "<td data-role='drugId'><input onkeydown='tdval(this)' onkeyup='tdval(this)' id='drugId" + i + "' value='"+v.drugId+"' style='width: 100px;margin-left: 0px'/></td>" +
                "<td data-role='drugName'><input id='drugName" + i + "' value='"+v.drugName+"' readonly style='background-color: #eee;width: 200px;margin-left: 0px'/></td>" +
                "<td data-role='unit'><input id='unit" + i + "' value='"+v.unit+"'readonly style='background-color: #eee;width: 100;margin-left: 0px'/></td>" +
                "<td data-role='packageType'><input id='packageType" + i + "' value='"+v.packageType+"' readonly style='background-color: #eee;width: 100px;margin-left: 0px'/></td>" +
                "<td data-role='purchase'><input id='purchase" + i + "' value='"+v.purchase+"' onkeyup='calculator()' onkeydown='calculator()' style='width: 100px;margin-left: 0px'/></td>" +
                "<td data-role='amount'><input id='amount" + i + "' value='"+v.amount+"' onkeyup='calculator()' onkeydown='calculator()' style='width: 100px;margin-left: 0px'/></td>" +
                "<td data-role='money'><input id='money" + i + "' value='"+v.money+"' style='width: 100px;margin-left: 0px' /></td>" +
                "<td data-role='effectiveDate'><input id='effectiveDate" + i + "' value='"+v.effectiveDate+"' style='width: 150px;margin-left: 0px'/></td>" +
                "<td><button class='btn-danger'>delete</button></td>").insertBefore("tr:last");
            $('#count').val(i + 1);
        });
        var count = document.getElementById("count").value;
        saveData(data, count);
    }



    //点击增加按钮事件
    $('.btn-sm').click(function () {
        data = getData();
        data.push({
            "orderNumber": "",
            "drugId": "",
            "drugName": "",
            "unit": "",
            "packageType": "",
            "purchase": "",
            "amount": "",
            "money": "",
            "effectiveDate": ""
        });
        var count = document.getElementById("count").value;
        saveData(data, count);
        add();
    })


    //删除行方法，事件委派，根据当前点击的按钮的行的索引值
    $('table').on('click', '.btn-danger', function () {
        data = getData();
        var index = $(this).parent().parent().attr("index");
        data.splice(index, 1);
        saveData(data, -11);
        add();
    })

    //可编辑效果 contenteditable='true'
    $('table').on('blur', '[contenteditable="true"]', function () {
        data = getData();
        var index = $(this).parent().attr('index');
        var val = $(this).html();
        var attr = $(this).attr('data-role');
        data[index][attr] = val;
        saveData(data,-11);
    })

})

//把数据存到本地存储，并且转换成字符串格式的JSON
function saveData(data, rows) {
    $.each(data, function (i, v) {
        if(i == rows-1 && rows > 0){
            v.drugId = document.getElementById("drugId"+(rows-1)).value;
            v.drugName = document.getElementById("drugName"+(rows-1)).value;
            v.unit = document.getElementById("unit"+(rows-1)).value;
            v.packageType = document.getElementById("packageType"+(rows-1)).value;
            v.purchase = document.getElementById("purchase"+(rows-1)).value;
            v.amount = document.getElementById("amount"+(rows-1)).value;
            v.money = document.getElementById("money"+(rows-1)).value;
            v.effectiveDate = document.getElementById("effectiveDate"+(rows-1)).value;
        }
    });
    sessionStorage.addTableList = JSON.stringify(data);
}

function tableListData() {
    var count = document.getElementById("count").value;
    saveData(data, count);
    $('#tableListSpan').html("<input type='hidden' name='tableList' value='"
        + JSON.stringify(sessionStorage.addTableList) + "' />");
}

function calculator(){
    var sum = 0;
    $.each(data, function (i, v) {
        // 计算每一行的价格
        v.money = document.getElementById("purchase"+i).value * document.getElementById("amount"+i).value;
        $('#money'+i).val(v.money)

        // 计算总金额
        sum += v.money;
    });
    $("#money").val(sum);
}
