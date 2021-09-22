package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugWarehousingForm {
    private Header header;
    private Supplier supplier;
    private List<Drug> drugList;
    private List<Details> details;
}
