package org.example.service;

import org.example.entity.Supplier;

import java.util.List;

public interface SupplierService {
    int addSupplier(Supplier supplier);

    int modifySupplier(Supplier supplier);

    int deleteSupplierByName(String supplierName);

    Supplier querySupplierByName(String supplierName);

    List<Supplier> queryAllSuppliers();
}
