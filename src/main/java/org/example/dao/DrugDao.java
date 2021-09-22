package org.example.dao;

import org.example.domain.Drug;

import java.util.List;

public interface DrugDao {
    boolean insertDrug(Drug drug);
    boolean updateDrug(Drug drug);
    boolean deleteDrug(Integer drugId);
    List<Drug> queryDrugListById(Integer drugId);
    List<Drug> queryAllDrugs();
    Drug queryDrugById(Integer drugId);
}
