package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.Details;
import org.example.domain.Drug;
import org.example.domain.Header;
import org.example.domain.Supplier;

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
