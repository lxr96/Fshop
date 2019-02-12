package com.sise.service.impl;

import com.sise.dao.CategoryMapper;
import com.sise.entity.Category;
import com.sise.entity.CategoryExample;
import com.sise.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list() {
        CategoryExample example =new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    public void add(Category category) {
        categoryMapper.insert(category);
    }

    public void delete(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public void update(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}