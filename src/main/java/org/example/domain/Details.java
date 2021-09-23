package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class    Details {
    private String orderNumber;        // 序号
    private Double purchase;            // 进价
    private Integer amount;             // 数量
    private String effectiveDate;       // 有效日期

    private String warehousingId;      // 入库单编号
    private String drugId;             // 药品编号

    @Override
    public String toString() {
        return "{" +
                "'orderNumber':'" + orderNumber +
                "', 'purchase':'" + purchase +
                "', 'amount':'" + amount +
                "', 'effectiveDate':'" + effectiveDate +
                "', 'warehousingId':'" + warehousingId +
                "', 'drugId':'" + drugId +
                "'}";
    }
}
