package org.example.dao;

import org.example.entity.Drug;

import java.util.List;

public interface DrugDao {
    boolean insertDrug(Drug drug);

    boolean updateDrug(Drug drug);

    boolean deleteDrug(String drugId);

    List<Drug> queryAllDrugs();

    Drug queryDrugById(String drugId);
}
