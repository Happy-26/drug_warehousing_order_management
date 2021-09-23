package org.example.controller;

import org.example.domain.Supplier;
import org.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 处理所有对于供应商的操作请求
 */
@Controller
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/querySupplierByName.do")
    public ModelAndView querySupplierByName(String supplierName) {
        ModelAndView mav = new ModelAndView();
        Supplier supplier = supplierService.querySupplierByName(supplierName);
        mav.addObject("supplier", supplier);
        mav.setViewName("modifySupplier");
        return mav;
    }

    /**
     * 处理前端ajax请求，返回supplier对象
     *
     * @param supplierName 前端传近来的要查询的供应商名字
     * @return 返回查询到的供应商信息
     */
    @RequestMapping("/querySupplierByNameAjax.do")
    @ResponseBody
    public Supplier querySupplierByNameAjax(String supplierName) {
        Supplier supplier = supplierService.querySupplierByName(supplierName);
        return supplier;
    }

    @RequestMapping("/queryAllSuppliers.do")
    public ModelAndView queryAllSuppliers() {
        ModelAndView mav = new ModelAndView();
        List<Supplier> supplierList = supplierService.queryAllSuppliers();
        mav.addObject("supplierList", supplierList);
        mav.setViewName("viewAllSuppliers");
        return mav;
    }

    @RequestMapping("/addSupplier.do")
    public String addSupplier(Supplier supplier) {
        supplierService.addSupplier(supplier);
        return "forward:queryAllSuppliers.do";
    }


    @RequestMapping("/deleteSupplierByName.do")
    public String deleteSupplierByName(String supplierName) {
        supplierService.deleteSupplierByName(supplierName);
        return "forward:queryAllSuppliers.do";
    }

    @RequestMapping("/modifySupplierByName.do")
    public String modifySupplierByName(Supplier supplier) {
        supplierService.modifySupplier(supplier);
        return "forward:queryAllSuppliers.do";
    }


}
