package com.mr.service;

import com.mr.model.TMallProduct;

import java.util.List;

/**
 * Created by leeMeiXin on 2018/10/30.
 */
public interface SpuService {

    void saveSpu(TMallProduct spu, List<String> urlList);
}
