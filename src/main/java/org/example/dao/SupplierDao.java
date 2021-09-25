package org.example.dao;

import org.example.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    boolean insertSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplierByName(String name);

    Supplier querySupplierByName(String name);

    List<Supplier> queryAllSuppliers();

}
