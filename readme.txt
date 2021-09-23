开发技术完成药品入库单的增、删、改和保存功能并撰写实验报告；

利用ssm框架进行开发

添加和修改使用两个不同名sessionStorage :addTableList、modifyTableList存储，互不干扰

难点1：  如何获取值:入库单编号	入库日期	入库人员	审核日期	审核人
        1、select * from header


难点2：
    如何从四个表中获取出一个完整的订单信息？  DrugWarehousingForm
    方法：
        1、先从header表中 select warehousingId  得到一个完整的Header ，赋值给 DrugWarehousingForm
        2、然后根据header的 supplierNameRef 得到 供应商信息，赋值给 DrugWarehousingForm
        3、然后查询 receiptitem（details） 中所有外键 warehousingId 为 header的warehousingId 的，得到 List<Details>
        4、将List<Details>中所有 Details 的 drugId 拿来查询  drugdata 得到 List<Drug>


难点三：在页面table展示完整表单
    目前思路： 在sessionStorage里拼接数据


难点四：如何修改一个Form
    1、供应商信息在入库单中只可以修改名称，其余信息应当自动更改                                           ✔
    2、header中可以修改入库日期，入库人员，审核日期，审核人员，但是编号不能改（获取方式暂定为打开页面时自动生成）  ✔
    3、表中数据如何修改？                                                                         ✔
        药品名称等信息不能修改，输入药品编码其余信息应该自动出现，

        找到所有入库单编号为header的 warehousingId 的 details， 存到一个集合中
        读取页面所有details
        将新的集合替换旧的集合，删除所有之前的，添加现在的

难点五、输入供应商名称后供应商其余信息自动补全
    解决：ajax                                                                                 ✔


问题
    <td onclick=a(this)></td>
    function a(item){
    		// 获取td中的值怎么获取
            解决办法：加一个<input />
    }
