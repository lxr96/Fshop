


package com.sise.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sise.dao.PropertyMapper;
import com.sise.entity.Property;
import com.sise.entity.PropertyExample;
import com.sise.service.PropertyService;

import java.util.List;


@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    PropertyMapper propertyMapper;

    
    public void add(Property p) {
        propertyMapper.insert(p);
    }

    
    public void delete(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    
    public void update(Property p) {
        propertyMapper.updateByPrimaryKeySelective(p);
    }

    
    public Property get(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

  
    public List<Property> list(int cid) {
        PropertyExample example =new PropertyExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }



}

