package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    private String supplierName;        // 供应商名称
    private String address;             // 地址
    private String zipCode;             // 邮编
    private String supplierBank;        // 供应商开户行
    private String supplierBankAccount; // 供应商银行账号
    private String SupplierTelephone;   // 供应商电话
    private String contacts;            // 联系人
    private String contactTelephone;    // 联系电话
}
