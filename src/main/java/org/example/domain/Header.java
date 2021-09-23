package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header {
    private String warehousingId;      // 入库单编号
    private String indate;              // 入库日期
    private String indatePerson;        // 入库人员
    private String auditDate;           // 审核日期
    private String reviewer;            // 审核人

    private String supplierNameRef;        // 供应商名称

}
