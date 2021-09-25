package org.example.service;

import org.example.entity.Drug;

import java.util.List;

public interface DrugService {
    int addDrug(Drug drug);

    int modifyDrug(Drug drug);

    List<Drug> queryAllDrugs();

    Drug queryDrugById(String id);

    int deleteDrugById(String id);
}
