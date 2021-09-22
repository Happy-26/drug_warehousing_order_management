package org.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drug {
    private Integer drugId;             // 药品编号
    private String drugName;            // 药品名称
    private String unit;                // 单位
    private String packageType;         // 包装
}
