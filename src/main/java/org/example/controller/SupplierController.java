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

    // 根据名字查询供应商
    @RequestMapping("/querySupplierByName.do")
    public ModelAndView querySupplierByName(String supplierName) {
        ModelAndView mav = new ModelAndView();
        Supplier supplier = supplierService.querySupplierByName(supplierName);

        if (supplier == null) {
            mav.setViewName("forward:queryAllSuppliers.do");
            mav.addObject("msg", "未查询到供应商信息");
            return mav;
        }

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

    // 查询所有供应商
    @RequestMapping("/queryAllSuppliers.do")
    public ModelAndView queryAllSuppliers() {
        ModelAndView mav = new ModelAndView();
        List<Supplier> supplierList = supplierService.queryAllSuppliers();
        mav.addObject("supplierList", supplierList);
        mav.setViewName("viewAllSuppliers");
        return mav;
    }

    // 增加供应商
    @RequestMapping("/addSupplier.do")
    public ModelAndView addSupplier(Supplier supplier) {
        ModelAndView mav = new ModelAndView();
        try {
            supplierService.addSupplier(supplier);
        } catch (Exception e){
            mav.addObject("msg", "重复添加供应商");
        }
        mav.setViewName("forward:queryAllSuppliers.do");
        return mav;
    }

    // 删除供应商
    @RequestMapping("/deleteSupplierByName.do")
    public String deleteSupplierByName(String supplierName) {
        supplierService.deleteSupplierByName(supplierName);
        return "forward:queryAllSuppliers.do";
    }

    // 修改供应商
    @RequestMapping("/modifySupplierByName.do")
    public String modifySupplierByName(Supplier supplier) {
        supplierService.modifySupplier(supplier);
        return "forward:queryAllSuppliers.do";
    }


}
