package com.mr.service;

import com.mr.mapper.SkuMapper;
import com.mr.model.TMallProduct;
import com.mr.model.TMallSkuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leeMeiXin on 2018/10/31.
 */
@Service
public class SkuServiceImpl implements SkuService {


    @Autowired
    private SkuMapper skuMapper;


    //查询
    @Override
    public List<TMallProduct> selectSpu(TMallProduct spu) {
        return skuMapper.selectSpu(spu);
    }

    //增加
    @Override
    public void saveSku(TMallSkuVO skuVO) {
        //增加sku ，返回当前
        skuMapper.saveSku(skuVO);

        //增加sku属性值
        Map<String,Object> map = new HashMap();
        map.put("shpId",skuVO.getShpId());
        map.put("skuId",skuVO.getId());
        map.put("attrValues",skuVO.getAttrValues());
        skuMapper.saveSkuAttrValue(map);

    }

}
