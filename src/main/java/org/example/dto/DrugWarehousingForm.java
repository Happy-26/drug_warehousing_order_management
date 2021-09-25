package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Details;
import org.example.entity.Drug;
import org.example.entity.Header;
import org.example.entity.Supplier;

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
