package com.sise.vo;

public class ProductListVO {
	private Integer id;

    private String name;

    private String subtitle;

    private Float originalprice;

    private Float promoteprice;

    private Integer stock;

    private String cname;

    private String uname;

    private String pstatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Float getOriginalprice() {
		return originalprice;
	}

	public void setOriginalprice(Float originalprice) {
		this.originalprice = originalprice;
	}

	public Float getPromoteprice() {
		return promoteprice;
	}

	public void setPromoteprice(Float promoteprice) {
		this.promoteprice = promoteprice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	@Override
	public String toString() {
		return "ProductListVO [id=" + id + ", name=" + name + ", subtitle=" + subtitle + ", originalprice="
				+ originalprice + ", promoteprice=" + promoteprice + ", stock=" + stock + ", cname=" + cname
				+ ", uname=" + uname + ", pstatus=" + pstatus + "]";
	}
}
