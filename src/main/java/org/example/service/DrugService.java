package org.example.service;

import org.example.domain.Drug;

import java.util.List;

public interface DrugService {
    int addDrug(Drug drug);

    int modifyDrug(Drug drug);

    List<Drug> queryDrugListById(String id);

    List<Drug> queryAllDrugs();

    Drug queryDrugById(String id);

    int deleteDrugById(String id);
}
