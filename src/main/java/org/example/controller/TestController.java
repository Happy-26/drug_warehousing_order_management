package org.example.controller;

import org.example.domain.Details;
import org.example.domain.Drug;
import org.example.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    DrugService drugService;

    @RequestMapping("/test.do")
    @ResponseBody
    public Drug test01(HttpServletRequest request, String drugId, Integer rows){
        System.out.println("=====================drugId" + drugId);
        System.out.println(rows);
        Drug drug = drugService.queryDrugById(drugId);
        System.out.println(drug);
        return drug;
    }
}
