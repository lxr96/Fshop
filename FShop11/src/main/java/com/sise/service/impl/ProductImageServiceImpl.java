/**
* 模仿天猫整站ssm 教程 为how2j.cn 版权所有
* 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
* 供购买者学习，请勿私自传播，否则自行承担相关法律责任
*/	

package com.sise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.dao.ProductImageMapper;
import com.sise.entity.ProductImage;
import com.sise.entity.ProductImageExample;
import com.sise.service.ProductImageService;



@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    ProductImageMapper productImageMapper;
    
    public void add(ProductImage pi) {
        productImageMapper.insert(pi);
    }

    public void delete(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }


    public void update(ProductImage pi) {
        productImageMapper.updateByPrimaryKeySelective(pi);

    }


    public ProductImage get(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }


    public List list(int pid, String type) {
        ProductImageExample example =new ProductImageExample();
        example.createCriteria()
                .andPidEqualTo(pid)
                .andTypeEqualTo(type);
        example.setOrderByClause("id desc");
        return productImageMapper.selectByExample(example);
    }
}


