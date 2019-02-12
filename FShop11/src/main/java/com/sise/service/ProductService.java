package com.sise.service;

import java.util.List;

import com.sise.entity.Category;
import com.sise.entity.Product;


/**
	 * @author:lxrong
	 * @description:
	 * @createTime:2019年1月24日 下午5:33:45
*/
public interface ProductService {
	
	void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
    void setFirstProductImage(Product p);

    void fill(List<Category> cs);

    void fill(Category c);

    void fillByRow(List<Category> cs);

    void setSaleAndReviewNumber(Product p);

    void setSaleAndReviewNumber(List<Product> ps);

    List<Product> search(String keyword);
}