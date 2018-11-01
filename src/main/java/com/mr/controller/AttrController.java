package com.mr.controller;

import com.mr.model.OBJECTTMallAttr;
import com.mr.model.TMallAttrVO;
import com.mr.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by leeMeiXin on 2018/10/30.
 */
@Controller
public class AttrController {

    @Autowired
    private AttrService attrService;


    /**
     * 跳转到属性增加（attr-add）页面
     * @param flbh2
     * @param map
     * @return
     */
    //将分类编号2传递
    @RequestMapping("toAddAttrPage")
    public String toAddAttrPage(Integer flbh2, ModelMap map){
        map.put("flbh2",flbh2);
        return "attr-add";
    }

    /**
     * 增加
     * @param flbh2
     * @param attrVO
     */
    @RequestMapping("saveAttr")
    public ModelAndView saveAttr(Integer flbh2, TMallAttrVO attrVO){
        attrService.saveAttr(flbh2,attrVO);
        /**
         * 重定向并返回数据
         */
        ModelAndView vie = new ModelAndView();
        vie.addObject("flbh2",flbh2);
        vie.setViewName("redirect:toAddAttrPage.do");
        return vie;
    }

    //返回属性列表内嵌页
    @RequestMapping("findAttrByclass2")
    public String findAttrByclass2(Integer flbh2,ModelMap map){
        List<OBJECTTMallAttr> list = attrService.findAttrByclass2(flbh2);
        map.put("list",list);
        return "innerAttrPage";
    }


}
