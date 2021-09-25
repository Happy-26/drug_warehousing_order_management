package org.example.controller;

import org.example.entity.Drug;
import org.example.service.DrugService;
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

    // 添加药品请求
    @RequestMapping("/addDrug.do")
    public ModelAndView addDrug(Drug drug) {
        ModelAndView mav = new ModelAndView();
        try{
            drugService.addDrug(drug);
        } catch (Exception e){
            mav.addObject("msg", "重复添加药品");
        }
        mav.setViewName("forward:queryAllDrugs.do");
        return mav;
    }

    // 修改药品请求
    @RequestMapping("/modifyDrug.do")
    public String modifyDrug(Drug drug) {
        drugService.modifyDrug(drug);
        return "forward:queryAllDrugs.do";
    }

    // 查询所有药品请求
    @RequestMapping("/queryAllDrugs.do")
    public ModelAndView queryAllDrugs() {
        ModelAndView mav = new ModelAndView();
        List<Drug> drugList = drugService.queryAllDrugs();
        mav.addObject("drugList", drugList);
        mav.setViewName("viewAllDrugs");
        return mav;
    }

    // 根据id查询药品请求
    @RequestMapping("/queryDrugById.do")
    public ModelAndView queryDrugById(String drugId) {
        ModelAndView mav = new ModelAndView();
        Drug drug = drugService.queryDrugById(drugId);
        if (drug == null) {
            mav.setViewName("forward:queryAllDrugs.do");
            mav.addObject("msg", "未查询到药品信息");
            return mav;
        }

        mav.addObject("drug", drug);
        mav.setViewName("modifyDrug");
        return mav;
    }

    /**
     * 处理前台ajax请求，实现输入药品id后局部刷新页面，自动显示药品其余信息
     *
     * @param drugId id
     * @return 查到的drug
     */
    @RequestMapping("/queryDrugByIdAjax.do")
    @ResponseBody
    public Drug queryDrugByIdAjax(String drugId, Integer rows) {
        return drugService.queryDrugById(drugId);
    }

    // 删除药品
    @RequestMapping("/deleteDrugById.do")
    public String deleteDrugById(String drugId) {
        drugService.deleteDrugById(drugId);
        return "forward:queryAllDrugs.do";
    }
}
