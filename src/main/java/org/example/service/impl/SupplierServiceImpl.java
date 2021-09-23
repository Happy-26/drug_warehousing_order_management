package org.example.service.impl;

import org.example.dao.SupplierDao;
import org.example.domain.Supplier;
import org.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierDao supplierDao;

    @Override
    public int addSupplier(Supplier supplier) {
        if (supplierDao.insertSupplier(supplier))
            return 1;
        else
            return 0;
    }

    @Override
    public int modifySupplier(Supplier supplier) {
        if (supplierDao.updateSupplier(supplier))
            return 1;
        else
            return 0;
    }

    @Override
    public int deleteSupplierByName(String supplierName) {
        if (supplierDao.deleteSupplierByName(supplierName))
            return 1;
        else
            return 0;
    }

    @Override
    public Supplier querySupplierByName(String supplierName) {
        return (supplierDao.querySupplierByName(supplierName));
    }

    @Override
    public List<Supplier> queryAllSuppliers() {
        return supplierDao.queryAllSuppliers();
    }
}
