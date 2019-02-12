package com.sise.entity;

import java.util.Date;
import java.util.List;


public class Category {
    private Integer id;

    private Integer orderCid;

    private String name;

    private Date createTime;

    private Date updateTime;
    
    /*如下是非数据库字段*/
    private List<Product> products;

    private List<List<Product>> productsByRow;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderCid() {
        return orderCid;
    }

    public void setOrderCid(Integer orderCid) {
        this.orderCid = orderCid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<List<Product>> getProductsByRow() {
		return productsByRow;
	}

	public void setProductsByRow(List<List<Product>> productsByRow) {
		this.productsByRow = productsByRow;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", orderCid=" + orderCid + ", name=" + name + "]";
	}
    
}