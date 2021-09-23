package org.example.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import org.example.domain.*;
import org.example.service.DetailsService;
import org.example.service.DrugService;
import org.example.service.HeaderService;
import org.example.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理所有对于一个完整入库单的请求
 */
@Controller
public class FromController {

    @Autowired
    private DetailsService detailsService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private HeaderService headerService;
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/queryAllForm.do")
    public ModelAndView queryAllOrder() {
        ModelAndView mav = new ModelAndView();
        List<Header> headerList = headerService.queryAllHeader();
        mav.addObject("headerList", headerList);

        mav.setViewName("viewAllForms");
        return mav;
    }

    @RequestMapping("/queryFormById.do")
    public ModelAndView queryFormById(String warehousingId) {
        ModelAndView mav = new ModelAndView();
        DrugWarehousingForm dwf = new DrugWarehousingForm();

        Header header = headerService.queryHeaderById(warehousingId);
        dwf.setHeader(header);

        Supplier supplier = supplierService.querySupplierByName(header.getSupplierNameRef());
        dwf.setSupplier(supplier);

        List<Drug> drugList = new ArrayList<>();
        List<Details> detailsList = detailsService.queryDetailsByHeaderId(header.getWarehousingId());
        for (Details details : detailsList) {
            Drug drug = drugService.queryDrugById(details.getDrugId());
            drugList.add(drug);
        }

        dwf.setDetails(detailsList);
        dwf.setDrugList(drugList);

        mav.addObject("dwf", dwf);
        mav.setViewName("modifyForm");
        return mav;
    }

    @RequestMapping("/modifyForm.do")
    public String modifyForm(Header header, Supplier supplier, HttpServletRequest request) {
        // 获取前端药品资料和入库单单目数据 [{name:zhangsan,id:1001,age:18}，{name:zhangsan,id:1001,age:18}]
        String tableList = request.getParameter("tableList");

        // 清空之前该入库单下的所有旧数据
        detailsService.deleteDetails(header.getWarehousingId());

        // 原始数据为字符串[{},{}],在这里先取出最外层的[],然后根据 },{ 分割
        String[] detailsStr = StrUtil.removeAll(StrUtil.removeAll(tableList, "["), "]").split("},\\{");

        // 对每个元素再进行分割{name:zhangsan,id:1001,age:18}
        for (String aa : detailsStr) {
            // 将每一条数据添加到集合中，然后挑选出对应信息放到对象中（drug和details是混合在一起的）
            List<String> strings = new ArrayList<>();

            // 去除"" 和 \
            String[] split = StrUtil.removeAll(StrUtil.removeAll(StrUtil.removeAll(aa, "\\"), "\""), "}").split(",");
            for (int i = 0; i < split.length; i++) {

                // 拼接出一个完整和
                strings.add(split[i].split(":")[1]);
            }

            Details details = new Details(strings.get(0), Convert.toDouble(strings.get(5)),
                    Convert.toInt(strings.get(6)), strings.get(8), header.getWarehousingId(),strings.get(1));
            try {
                // 添加新的数据
                detailsService.addDetails(details);
            } catch (Exception e) {
                System.out.println("重复插入");
            }
        }

        header.setSupplierNameRef(supplier.getSupplierName());
        headerService.modifyHeader(header);

        return "forward:queryAllForm.do";
    }

    @RequestMapping("/deleteForm.do")
    public String deleteForm(String warehousingId) {
        headerService.deleteHeader(warehousingId);
        detailsService.deleteDetails(warehousingId);
        return "forward:queryAllForm.do";
    }

    @RequestMapping("/addForm.do")
    public String addOrder(Header header, Supplier supplier, HttpServletRequest request) {
        // 获取前端药品资料和入库单单目数据 [{name:zhangsan,id:1001,age:18}，{name:zhangsan,id:1001,age:18}]
        String tableList = request.getParameter("tableList");

        // 原始数据为字符串[{},{}],在这里先取出最外层的[],然后根据 },{ 分割
        String[] detailsStr = StrUtil.removeAll(StrUtil.removeAll(tableList, "["), "]").split("},\\{");

        // 对每个元素再进行分割{name:zhangsan,id:1001,age:18}
        for (String aa : detailsStr) {
            // 将每一条数据添加到集合中，然后挑选出对应信息放到对象中（drug和details是混合在一起的）
            List<String> strings = new ArrayList<>();

            // 去除"" 和 \
            String[] split = StrUtil.removeAll(StrUtil.removeAll(StrUtil.removeAll(aa, "\\"), "\""), "}").split(",");
            for (int i = 0; i < split.length; i++) {
                // 拼接出一个完整和
                strings.add(split[i].split(":")[1]);
            }

            Details details = new Details(strings.get(0), Convert.toDouble(strings.get(5)),
                    Convert.toInt(strings.get(6)), strings.get(8), header.getWarehousingId(), strings.get(1));
            try {
                detailsService.addDetails(details);
            } catch (Exception e) {
                System.out.println("重复插入");
                e.printStackTrace();
            }
        }

        header.setSupplierNameRef(supplier.getSupplierName());
        headerService.addHeader(header);

        // 转发到查询所有入库单请求
        return "forward:queryAllForm.do";
    }


}
