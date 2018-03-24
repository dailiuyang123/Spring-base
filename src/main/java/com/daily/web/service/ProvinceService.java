package com.daily.web.service;

import com.daily.mybatis.dao.ProvinceMapper;
import com.daily.mybatis.entity.Province;
import com.daily.mybatis.entity.ProvinceExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Azir on 2017/12/31.
 */
@Service
@Transactional
public class ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;


    /**
    *  Author: 代刘洋
    *  Time：  2017/12/31  22:35
    *  Title:
    *  Param:
    *  Response:
    *   练习example
    */
    public  void  getProvince(){
        ProvinceExample provinceExample=new ProvinceExample();
        ProvinceExample.Criteria criteria = provinceExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Province> provinces = provinceMapper.selectByExample(provinceExample);

    }




}
