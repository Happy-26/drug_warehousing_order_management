package org.example.service.impl;

import org.example.dao.DrugDao;
import org.example.domain.Drug;
import org.example.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    DrugDao drugDao;

    @Override
    public int addDrug(Drug drug) {
        if (drugDao.insertDrug(drug))
            return 1;
        else
            return 0;
    }

    @Override
    public int modifyDrug(Drug drug) {
        if (drugDao.updateDrug(drug))
            return 1;
        else
            return 0;
    }

    @Override
    public int deleteDrugById(String drugId) {
        if (drugDao.deleteDrug(drugId))
            return 1;
        else
            return 0;
    }

    @Override
    public Drug queryDrugById(String id) {
        return drugDao.queryDrugById(id);
    }

    @Override
    public List<Drug> queryAllDrugs() {
        return drugDao.queryAllDrugs();
    }
}
