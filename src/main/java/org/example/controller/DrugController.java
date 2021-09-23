package org.example.controller;

import org.example.domain.Drug;
import org.example.service.DetailsService;
import org.example.service.DrugService;
import org.example.service.HeaderService;
import org.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping("/addDrug.do")
    public ModelAndView addDrug(Drug drug) {
        ModelAndView mav = new ModelAndView();
        drugService.addDrug(drug);
        mav.setViewName("viewAllDrugs");
        return mav;
    }

    @RequestMapping("/modifyDrug.do")
    public String modifyDrug(Drug drug) {
        drugService.modifyDrug(drug);
        return "forward:queryAllDrugs.do";
    }

    @RequestMapping("/queryAllDrugs.do")
    public ModelAndView queryAllDrugs() {
        ModelAndView mav = new ModelAndView();
        List<Drug> drugList = drugService.queryAllDrugs();
        mav.addObject("drugList", drugList);
        mav.setViewName("viewAllDrugs");
        return mav;
    }

    @RequestMapping("/queryDrugById.do")
    public ModelAndView queryDrugById(String drugId) {
        ModelAndView mav = new ModelAndView();
        Drug drug = drugService.queryDrugById(drugId);
        mav.addObject("drug", drug);
        mav.setViewName("modifyDrug");
        return mav;
    }

    /**
     * 处理ajax请求
     *
     * @param drugId id
     * @return 查到的drug
     */
    @RequestMapping("/queryDrugByIdAjax.do")
    @ResponseBody
    public Drug queryDrugByIdAjax(String drugId, Integer rows) {
        return drugService.queryDrugById(drugId);
    }

    @RequestMapping("/deleteDrugById.do")
    public String deleteDrugById(String drugId) {
        drugService.deleteDrugById(drugId);
        return "forward:queryAllDrugs.do";
    }
}
