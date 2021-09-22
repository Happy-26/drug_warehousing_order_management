package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItem {
    private Integer orderNumber;        // 序号
    private Integer drugId;             // 药品编号
    private String drugName;            // 药品名称
    private String unit;                // 单位
    private String packageType;         // 包装
    private Double purchase;            // 进价
    private Integer amount;             // 数量
    private Double money;            // 进价
    private String effectiveDate;       // 有效日期

    @Override
    public String toString() {
        return "{" +
                "'orderNumber':'" + orderNumber +
                "', 'drugId':'" + drugId +
                "', 'drugName':'" + drugName +
                "', 'unit':'" + unit +
                "', 'packageType':'" + packageType +
                "', 'purchase':'" + purchase +
                "', 'amount':'" + amount +
                "', 'money':'" + money +
                "', 'effectiveDate':'" + effectiveDate +
                "'}";
    }
}

