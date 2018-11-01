package com.mr.controller;

import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallProduct;
import com.mr.model.TMallSkuVO;
import com.mr.service.AttrService;
import com.mr.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by leeMeiXin on 2018/10/31.
 */
@Controller
public class SkuController {

    @Autowired
    private SkuService skuService;

    @Autowired
    private AttrService attrService;



    @RequestMapping("toAddSkuPage")
    public String toAddSkuPage(Integer flbh1, Integer flbh2, ModelMap map){

        //查询属性
        List<OBJECTTMallAttr> list = attrService.findAttrByclass2(flbh2);
        map.put("flbh1",flbh1);
        map.put("flbh2",flbh2);
        map.put("attrList",list);

        return "sku-add";
    }

    //查询tmid 和flbh2
    //返回json 数据
    @ResponseBody
    @RequestMapping("selectSpu")
    public List<TMallProduct> selectSpu(TMallProduct spu){
        List<TMallProduct> list =  skuService.selectSpu(spu);
        return list;
    }


    /**
     * 增加sku 和sku属性
     * @param skuVO
     * @return
     */
    @RequestMapping("saveSku")
    public ModelAndView saveSku(TMallSkuVO skuVO,Integer flbh1, Integer flbh2){
        skuService.saveSku(skuVO);

        //重定向
        ModelAndView vie = new ModelAndView();
        vie.addObject("flbh1",flbh1);
        vie.addObject("flbh2",flbh2);
        vie.setViewName("redirect:toAddSkuPage.do");
        return vie;
    }


}
