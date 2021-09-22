# 开发技术完成药品入库单的增、删、改和保存功能并撰写实验报告；

# 药品资料档案
create table drugData
(
    drugId   int PRIMARY KEY auto_increment, # 药品编号
    drugName varchar(50),                    # 药品名称
    unit     char(2),                        # 单位
    package  char(2)                         # 包装
);

# 供应商档案
create table supplierData
(
    supplierName        varchar(20) PRIMARY KEY, # 供应商名称
    contacts            varchar(20),             # 联系人
    contactTelephone    char(11),                # 联系电话
    SupplierTelephone   char(11),                # 供应商电话
    address             varchar(100),            # 地址
    zipCode             char(7),                 # 邮编
    supplierBank        varchar(20),             # 供应商开户行
    supplierBankAccount char(16)                 # 供应商银行账号
);

# 入库单单头
create table header
(
    warehousingId int PRIMARY KEY auto_increment, # 入库单编号
    indate        char(10),                       #	入库日期
    indatePerson  varchar(20),                    # 入库人员
    auditDate     char(10),                       # 审核日期
    Reviewer      char(20),                       # 审核人
    supplierName  varchar(20),
    FOREIGN KEY (supplierName) REFERENCES supplierData (supplierName)
);

# 入库单单目
create table receiptItem
(
    orderNumber   int,      # 序号
    purchase      double,   # 进价
    amount        int,      # 数量
    effectiveDate char(10), # 有效日期
    warehousingId int,
    drugId        int,
    FOREIGN KEY (warehousingId) REFERENCES header (warehousingId),
    FOREIGN KEY (drugId) REFERENCES drugData (drugId)
);


