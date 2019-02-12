package com.sise.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sise.dao.ProductMapper;

import com.sise.entity.Category;
import com.sise.entity.Product;
import com.sise.entity.ProductExample;

import com.sise.service.CategoryService;
import com.sise.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	   @Autowired
	    ProductMapper productMapper;
	    @Autowired
	    CategoryService categoryService;
	    
	    public void add(Product p) {
	        productMapper.insert(p);
	    }

	    public void delete(int id) {
	        productMapper.deleteByPrimaryKey(id);
	    }

	    
	    public void update(Product p) {
	        productMapper.updateByPrimaryKeySelective(p);
	    }

	    
	    public Product get(int id) {
	        Product p = productMapper.selectByPrimaryKey(id);
	        setFirstProductImage(p);
	        setCategory(p);
	        return p;
	    }


	    public void setCategory(List<Product> ps){
	        for (Product p : ps)
	            setCategory(p);
	    }
	    public void setCategory(Product p){
	        int cid = p.getCid();
	        Category c = categoryService.get(cid);
	        p.setCategory(c);
	    }

	    
	    public List list(int cid) {
	        ProductExample example = new ProductExample();
	        example.createCriteria().andCidEqualTo(cid);
	        example.setOrderByClause("id desc");
	        List result = productMapper.selectByExample(example);
	        setFirstProductImage(result);
	        setCategory(result);
	        return result;
	    }

	    
	    public void setFirstProductImage(Product p) {
	        
	    }

	    
	    public void fill(List<Category> cs) {
	        for (Category c : cs) {
	            fill(c);
	        }
	    }

	    
	    public void fillByRow(List<Category> cs) {
	       
	    }

	
	    public void setSaleAndReviewNumber(Product p) {
	       
	    }


	    public void setSaleAndReviewNumber(List<Product> ps) {
	        for (Product p : ps) {
	            setSaleAndReviewNumber(p);
	        }
	    }


	    public List<Product> search(String keyword) {
	        ProductExample example = new ProductExample();
	        example.createCriteria().andNameLike("%" + keyword + "%");
	        example.setOrderByClause("id desc");
	        List result = productMapper.selectByExample(example);
	        setFirstProductImage(result);
	        setCategory(result);
	        return result;
	    }


	    public void fill(Category c) {
	        List<Product> ps = list(c.getId());
	        c.setProducts(ps);
	    }

	    public void setFirstProductImage(List<Product> ps) {
	        for (Product p : ps) {
	            setFirstProductImage(p);
	        }
	    }
	}

