package com.mr.mapper;

import com.mr.model.TMallProduct;

import java.util.Map;

/**
 * Created by leeMeiXin on 2018/10/30.
 */
public interface SpuMapper {


    void saveSpu(TMallProduct spu);

    void saveSpuImgs(Map<String, Object> map);
}
